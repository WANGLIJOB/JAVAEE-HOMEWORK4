package com.flux.gradle.frame.request;


import com.flux.gradle.frame.util.JsonStrToMap;

import java.util.HashMap;
import java.util.Map;

public class ReqUtil {

    public static final String METHOD = "method";
    public static final String USERID = "userid";
    public static final String MEMBER_ID = "memberId";
    public static final String TOKEN = "token";
    public static final String PARAMS = "params";

    public static Map<String, Object> dataMap(String data) {

        data = data.replaceAll("\'", "\"");

        Map<String, Object> dataMap = JsonStrToMap.convert(data);

        if (dataMap.get(METHOD) == null) throw new RuntimeException("data method is null.");
//        if (dataMap.get(USERID) == null) throw new RuntimeException("data userid is null.");
//        if (dataMap.get(TOKEN) == null) throw new RuntimeException("data token is null.");
        if (dataMap.get(PARAMS) == null) dataMap.put(PARAMS, new HashMap<>());

//        System.err.println(dataMap.get(PARAMS).getClass().getTypeName()); // com.alibaba.fastjson.JSONObject

        return dataMap;

    }

}
