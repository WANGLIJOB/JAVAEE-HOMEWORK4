package com.flux.gradle.frame.request;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class ReqSteward {

    public static ReqInfo reqInfo(String data) {

        Map<String, Object> dataMap = ReqUtil.dataMap(data);

        Object method = dataMap.get(ReqUtil.METHOD);
        Object token = dataMap.get(ReqUtil.TOKEN);
        Object userid = dataMap.get(ReqUtil.USERID);
        Object memberId = dataMap.get(ReqUtil.MEMBER_ID);
        Object params = dataMap.get(ReqUtil.PARAMS);

        ReqInfo reqInfo = ReqInfo.builder()
                .method(method.toString()) // required
                .token(token == null ? null : token.toString())
                .userid(userid == null ? null : userid.toString())
                .memberId(memberId == null ? null : memberId.toString())
                .params(params == null ? null : (Map) dataMap.get(ReqUtil.PARAMS))
                .build();

        return reqInfo;

    }

}
