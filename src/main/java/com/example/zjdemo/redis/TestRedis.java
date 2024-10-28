package com.example.zjdemo.redis;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class TestRedis {

    @Autowired
    public RedisTemplate redisTemplate;
    @Autowired
    public RedissonClient redissonClient;

    @PostConstruct
    public void init(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.boundValueOps("123").set(223);


        Set keys = redisTemplate.keys("*");
        for (Object key : keys) {
            System.out.println(key);
        }
        System.out.println("2233333");

        long count = redissonClient.getKeys().count();
        System.out.println();
        System.out.println(count);

    }
}
