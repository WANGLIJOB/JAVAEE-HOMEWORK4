package com.flux.gradle.frame.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class JsonStrToMap {

    // 转换
    public static Map<String, Object> convert(String data) {
        try {
            Map maps = (Map) JSON.parse(data);
            return maps;
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
