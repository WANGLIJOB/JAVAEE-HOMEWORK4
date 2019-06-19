package com.flux.gradle.module.user.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author G
 * @Description $end$
 * @Date 2018/10/12 14:29
 **/
@Component
public class UserCache {
    public static StringRedisTemplate redisTemplate;

    @Autowired
    private void setRedisTemplate(StringRedisTemplate redisTemplate){
        UserCache.redisTemplate = redisTemplate;
    }

}
