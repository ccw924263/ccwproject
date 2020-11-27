package com.ccw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用springcloud-provide的/config/info接口
     * @return
     */
    @GetMapping("/echo/info")
    public String echoConfigInfo(){
        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("ccw-nacos-provider");
        String path = String.format("http://%s:%s/provider/info",serviceInstance.getHost(),serviceInstance.getPort());
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path,String.class);
    }


    //Instantiate RestTemplate Instance
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}