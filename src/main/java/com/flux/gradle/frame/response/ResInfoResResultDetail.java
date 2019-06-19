package com.flux.gradle.frame.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResInfoResResultDetail {

    // 响应时长
    private Long duration;
    // 请求时刻
    private Long reqTimestamp;
    // 响应时刻
    private Long resTimestamp;
    // 请求类型
    private String reqType;
    // 请求地址
    private String reqPath;
    // 请求参数
    private String reqParams;
    // 请求IP
    private String reqIp;

}
