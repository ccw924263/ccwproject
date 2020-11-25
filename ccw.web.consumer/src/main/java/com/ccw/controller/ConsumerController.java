package com.ccw.controller;

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
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String path = String.format("http://%s:%s/info",serviceInstance.getHost(),serviceInstance.getPort());
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path,String.class);
    }


    //Instantiate RestTemplate Instance
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}