package com.ccw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static Logger logger = LoggerFactory.getLogger(ConsumerController.class);

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
        logger.info("request path:" +path);
        return restTemplate.getForObject(path,String.class);
    }


}