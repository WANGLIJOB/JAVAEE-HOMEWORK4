package com.flux.gradle.frame.steward;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flux.gradle.frame.redis.Jedis;
import com.flux.gradle.frame.redis.RedisKey;
import com.flux.gradle.frame.request.ReqInfo;
import com.flux.gradle.frame.request.ReqSteward;
import com.flux.gradle.frame.util.FromSourceIntoTarget;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 所有现成安全的缓存应该放在这里集中统一管理
 */
public class Steward {

    // #####                                        #####
    // #####                    Json                #####
    // #####                                        #####

    private static final ObjectMapper mapper = new ObjectMapper();

    public static byte[] writeValueAsBytes(Object object) throws JsonProcessingException {
        return mapper.writeValueAsBytes(object);
    }

    // #####                                        #####
    // #####             HibernateValidator         #####
    // #####                                        #####

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
        return validator.validate(object, groups);
    }

    // #####                                        #####
    // #####               tzw  req info            #####
    // #####                                        #####

    public static ReqInfo reqInfo(String data) {
        return ReqSteward.reqInfo(data);
    }

    /**
     * 合并
     * @param source
     * @param target
     */
    public static void merge(Object source, Object target) {
        FromSourceIntoTarget.merge(source, target);
    }

    public static long getIncrementId(){
        return Jedis.db0.incrAndDecr(RedisKey.MISHANG_OLD_FRAME_SEQ,1L);
    }
}