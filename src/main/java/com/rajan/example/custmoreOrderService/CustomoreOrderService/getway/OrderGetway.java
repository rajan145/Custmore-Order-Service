package com.rajan.example.custmoreOrderService.CustomoreOrderService.getway;

import com.rajan.example.custmoreOrderService.CustomoreOrderService.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class OrderGetway {

    @Autowired
    RestTemplate restTemplate;

    private String uri ="/order/";
    private String port="8081";
    private String hostname="localhost";


    public Order getOrderDetails(String orderId){

        Order order =
                restTemplate.getForObject("http://" + hostname + ":" + port + uri + orderId, Order.class);
        return order;

    }
}
