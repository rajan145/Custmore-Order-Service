package com.rajan.example.custmoreOrderService.CustomoreOrderService.controller;

import com.rajan.example.custmoreOrderService.CustomoreOrderService.models.OrderDetails;
import com.rajan.example.custmoreOrderService.CustomoreOrderService.models.OrderSummary;
import com.rajan.example.custmoreOrderService.CustomoreOrderService.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustmoreOrderController {

    @Autowired
    OrderDetailsService orderDetailsService;

    /*
    * Get Order summaries  for all the orders
    * */
    @RequestMapping("{customerId}/orderSummary")
    public List<OrderSummary> getOrderSummary(@PathVariable String customerId){
        return orderDetailsService.getOrderSummary(customerId);
    }

    /*
    * Get Order Details by OrderID
    * */
    @RequestMapping("{customerId}/order/{orderId}")
    public OrderDetails getOrderByOrderId(@PathVariable String customerId, @PathVariable String orderId){
        return orderDetailsService.getOrderByOrderId(customerId,orderId);

    }

    /*
    * Get latest order summary
    * */
    @RequestMapping("{customerId}/orderSummary/latest")
    public OrderSummary getRecentOrderSummary(@PathVariable String customerId){
        return orderDetailsService.getRecentOrderSummary(customerId);
    }


}
