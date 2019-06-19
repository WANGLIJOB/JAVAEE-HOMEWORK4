package com.flux.gradle.frame.request;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ReqInfo {

    private String method;
    private String userid;
    private String memberId;
    private String token;
    private Map<String, Object> params;

}
