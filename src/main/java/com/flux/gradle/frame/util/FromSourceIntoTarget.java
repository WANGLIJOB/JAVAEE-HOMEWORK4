package com.flux.gradle.frame.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.ReflectUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@Slf4j
public class FromSourceIntoTarget {

    private static final String ERR_CANNOT_MERGED = "The two types cannot be merged. (source, target)";

    /**
     * 将 source 合并到 target 中
     * —— 用源实体类中的非空属性的值，把目标实体类中对应的属性值替换掉。
     *
     * @param source 源实体类
     * @param target 目标实体类
     */
    public static void merge(Object source, Object target) {
        if (source.getClass().getTypeName().equals(target.getClass().getTypeName())) {
            mergeSameType(source, target);
        } else {
            log.error(ERR_CANNOT_MERGED);
        }
    }

    private static void mergeSameType(Object source, Object target) {
        Arrays.stream(ReflectUtils.getBeanProperties(source.getClass())).forEach(propertyDescriptor -> {
            try {
                Object value = propertyDescriptor.getReadMethod().invoke(source);
                if (value != null) {
                    propertyDescriptor.getWriteMethod().invoke(target, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

}
