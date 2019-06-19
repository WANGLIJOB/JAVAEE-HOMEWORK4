package com.flux.gradle.frame.util;

/**
 * @Author G
 * @Description $end$
 * @Date 2018/10/12 14:41
 **/
public class ConverterUtils {

    /**
     * obj转换成string类型 如果值为空就返回“”
     * @param obj
     * @param defaultVal
     * @return
     */
    public static String toString(Object obj,String defaultVal){
        return (obj != null) ? obj.toString() : defaultVal;
    }

    /**
     * obj转换string类型
     * @param obj
     * @return
     */
    public static String toString(Object obj){
        return toString(obj,"");
    }
}
