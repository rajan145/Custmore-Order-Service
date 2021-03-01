package com.rajan.example.custmoreOrderService.CustomoreOrderService.getway;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Component
public class IndexServiceGetway {

    @Autowired
    RestTemplate restTemplate;

    private String uri ="/search/customer/";
    private String port="8081";
    private String hostname="localhost";

    public List<String> getOrders(String customerId) {

      ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://" + hostname + ":" + port + uri + customerId, String.class);

      JSONObject ob = new JSONObject(responseEntity.getBody());
      JSONArray array = ob.getJSONArray("orderId");

      List<String> orderId = new ArrayList<>();
      array.forEach(s->orderId.add(s.toString()));
      return orderId;

    }
}
