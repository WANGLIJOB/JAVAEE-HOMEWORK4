package com.flux.gradle.frame.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 空值校验
 */
public class VE {

    /**
     * 有一个是空则返回true
     *
     * @param objects
     * @return
     * @author Jinxing helloworld2148@me.com 2016年4月30日 下午9:20:48
     */
    public static boolean isEmptyArr(Object... objects) {
        for (Object obj : objects)
            if (isEmpty(obj))
                return true;
        return false;
    }

    /**
     * 空：Integer、Long、Double、Float、Short、String、List、Map、Object、BigDecimal
     */
    public static boolean isEmpty(Object obj) {
        if (obj instanceof Integer || obj instanceof Long || obj instanceof Double || obj instanceof Float || obj instanceof Short || obj instanceof BigDecimal || obj instanceof Date) {
            return obj == null;
        } else if (obj instanceof String)
            return obj == null || obj.toString().length() == 0;
        else if (obj instanceof List<?>)
            return obj == null || ((List<?>) obj).size() == 0;
        else if (obj instanceof Map<?, ?>)
            return obj == null || ((Map<?, ?>) obj).size() == 0;
        else
            return obj == null;
    }

    /**
     * 非空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

}
