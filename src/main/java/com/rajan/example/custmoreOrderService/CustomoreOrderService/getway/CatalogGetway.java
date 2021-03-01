package com.rajan.example.custmoreOrderService.CustomoreOrderService.getway;

import com.rajan.example.custmoreOrderService.CustomoreOrderService.models.HardCatalog;
import com.rajan.example.custmoreOrderService.CustomoreOrderService.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@Component
public class CatalogGetway {

    @Autowired
    RestTemplate restTemplate;

    private String uri ="/catalog/hardsku/";
    private String port="8081";
    private String hostname="localhost";

    public HardCatalog getskuInfo(String skuId) {
        HardCatalog hardCatalog = new HardCatalog();
        try{
             hardCatalog =
                    restTemplate.getForObject("http://" + hostname + ":" + port + uri + skuId, HardCatalog.class);
        }
        catch (Exception e){
            System.out.println("Exception"+e);
        }

        return hardCatalog;
    }
}
