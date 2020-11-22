package com.ccw.controller;

import com.ccw.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private IRedisService redisService;

    @RequestMapping(value = "/putToRedis", method = RequestMethod.GET)
    @ResponseBody
    public String putToRedis(String key, String value) {
        redisService.putToRedis(key, value);
        return "putToRedis success";
    }

    @ResponseBody
    @RequestMapping(value = "/getByKey", method = RequestMethod.GET)
    public String getByKey(String key) {
        return redisService.getByKey(key);
    }

}
