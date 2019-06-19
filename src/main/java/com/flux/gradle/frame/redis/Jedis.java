package com.flux.gradle.frame.redis;

import com.flux.gradle.frame.util.RedisClient;
import com.flux.gradle.module.user.cache.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author G
 * @Description $end$
 * @Date 2018/10/12 11:24
 **/
@Component
public class Jedis {

    public static RedisClient db0;

    public static UserCache userCache;

    @Autowired
    private void setDb0(RedisClient db0,UserCache userCache){
        Jedis.db0 = db0;
        Jedis.userCache = userCache;
    }
}
