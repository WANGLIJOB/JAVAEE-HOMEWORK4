package com.flux.gradle.frame.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author G
 * @Description redis工具
 * @Date 2018/10/12 13:26
 **/
@Component
public class RedisClient {

    public static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisClient.redisTemplate = redisTemplate;
    }

    /**
     * 向redis中保存数据
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key , Object value){
        boolean result = false;
        try{
            if(value instanceof String){
                //字符串
                redisTemplate.opsForValue().set(key,value);
            }
            if(value instanceof Set){
                //Set集合
                redisTemplate.opsForSet().add(key,value);
            }
            if(value instanceof List){
                //List集合
                redisTemplate.opsForList().rightPush(key,value);
            }
            if(value instanceof Map){
                //Map集合
                redisTemplate.opsForHash().putAll(key,(Map) value);
            }
            if(value instanceof Set){
                //其他
                redisTemplate.opsForValue().set(key,value);
            }
            result = true;
        }catch(Exception e){
            e.printStackTrace();
        }
      return result;
    }

    /**
     * 增加或减少key
     * @param increment
     * @param key
     */
    public Long incrAndDecr(Object key,long increment) {
        return redisTemplate.opsForValue().increment(key,increment);
    }

    /**
     * 增加或减少key
     * @param increment
     * @param key
     */
    public Double incrAndDecr(Object key,double increment) {
        return redisTemplate.opsForValue().increment(key,increment);
    }
}
