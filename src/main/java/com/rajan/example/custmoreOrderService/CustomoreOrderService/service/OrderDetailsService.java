package com.rajan.example.custmoreOrderService.CustomoreOrderService.service;

import com.rajan.example.custmoreOrderService.CustomoreOrderService.getway.CatalogGetway;
import com.rajan.example.custmoreOrderService.CustomoreOrderService.getway.IndexServiceGetway;
import com.rajan.example.custmoreOrderService.CustomoreOrderService.getway.OrderGetway;
import com.rajan.example.custmoreOrderService.CustomoreOrderService.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService {

    @Autowired
    IndexServiceGetway indexServiceGetway;

    @Autowired
    OrderGetway orderGetway;

    @Autowired
    CatalogGetway catalogGetway;

    @Bean
    public RestTemplate getRestTemplete(){
        return new RestTemplate();
    }

    public List<OrderSummary> getOrderSummary(String customerId){
        //1 Get all the orders IDs
        List<String> orders = indexServiceGetway.getOrders(customerId);

        // Get all the order details
        List<Order> orderDetails = orders.stream()
                .map(order -> orderGetway.getOrderDetails(order))
                .collect(Collectors.toList());

        return buildOrderSummary(orderDetails);
    }

    public OrderSummary getRecentOrderSummary(String customerId){
        List<String> orders = indexServiceGetway.getOrders(customerId);

        List<Order> orderDetails = orders.stream()
                .map(order -> orderGetway.getOrderDetails(order))
                .sorted(Comparator.comparing(order -> order.getOrderId()))
                .collect(Collectors.toList());

        return buildOrderSummary(orderDetails).get(0);

    }

    private List<OrderSummary> buildOrderSummary(List<Order> orders){
        return orders.stream().map(
                order -> {
                    List<ItemsSummary> itemSummary = getItemSummary(order.getItems());
                    return new OrderSummary(order.getOrderId(), order.getStatus(), itemSummary,
                            order.getStatus());
                })
                .collect(Collectors.toList());
    }

    private List<ItemsSummary> getItemSummary(List<OrderItem> items){
        return items.stream()
                .map(item -> {
                    HardCatalog hardCatalog = catalogGetway.getskuInfo(item.getSkuId());
                    return new ItemsSummary(hardCatalog.getModel(),hardCatalog.getColor(),
                            hardCatalog.getSize(),hardCatalog.getName(), item.getEstimatedShipDateRange().get("fromDate"),
                            item.getEstimatedShipDateRange().get("toDate"),item.getStatus(),item.getQuantity());
                }).collect(Collectors.toList());

    }

    public OrderDetails getOrderByOrderId(String customerId, String orderId) {
            List<String> orders = indexServiceGetway.getOrders(customerId);
            if(!orderId.contains(orderId)){
                return null;
            }

            Order order = orderGetway.getOrderDetails(orderId);
            return buildOrderDetails(order);
    }

    private OrderDetails buildOrderDetails(Order order){
        List<ItemDetails> items = order.getItems().stream()
                .map(item -> {
                    HardCatalog hardCatalog = catalogGetway.getskuInfo(item.getSkuId());
                    ItemDetails itemDetails = new ItemDetails();
                    itemDetails.setId(item.getId());
                    itemDetails.setName(item.getName());
                    itemDetails.setPlanId(item.getPlanId());
                    itemDetails.setQuantity(item.getQuantity());
                    itemDetails.setTelephoneNumber(item.getTelephoneNumber());
                    itemDetails.setStatus(item.getStatus());
                    itemDetails.setComplete(item.isComplete());
                    itemDetails.setEstimatedShipDateRange(item.getEstimatedShipDateRange());
                    itemDetails.setNewEstimatedShipDateRange(item.getNewEstimatedShipDateRange());
                    itemDetails.setUserAcceptedDelay(item.isUserAcceptedDelay());
                    itemDetails.setHardCatalog(hardCatalog);
                    return itemDetails;
                } ).collect(Collectors.toList());

            OrderDetails orderDetails = new OrderDetails();

            if(order.getStatus().equals("shipped")){

                List<Shipments> shippedItem = order.getShipments().stream().map(
                        shipment -> {
                            List<String> itemsId = shipment.getItems();
                            System.out.println(itemsId.toString());

                            List<ItemDetails> shippedItems = getshippedItem(items, itemsId);

                            System.out.println("shipped"+shippedItems.size());
                            Shipments sp = new Shipments();
                            sp.setId(shipment.getId());
                            sp.setCarrier(shipment.getCarrier());
                            sp.setTrackingNumber(shipment.getTrackingNumber());
                            sp.setTrackingUrl(shipment.getTrackingUrl());
                            sp.setEstimatedDeliveryDate(shipment.getEstimatedDeliveryDate());
                            sp.setShipDate(shipment.getShipDate());
                            sp.setItems(shippedItems);
                            System.out.println("Shipment "+sp.getId());
                            return sp;
                        }
                ).collect(Collectors.toList());


                orderDetails.setShipments(shippedItem);

            }
            else {
                orderDetails.setOrderItem(items);
            }

        orderDetails.setOrderId(order.getOrderId());
        orderDetails.setStatus(order.getStatus());
        orderDetails.setCustomerId(order.getCustomerId());
        orderDetails.setShipingAddress(order.getShipingAddress());


        return orderDetails;

    }

    private List<ItemDetails> getshippedItem(List<ItemDetails> itemDetails, List<String> items){
        HashMap<String, ItemDetails> hashMap = new HashMap<>();
                itemDetails.stream().forEach(item -> {
                    hashMap.put(item.getId(),item);
                });

        return items.stream()
                .map( item -> hashMap.get(item))
                .collect(Collectors.toList());

    }
}
