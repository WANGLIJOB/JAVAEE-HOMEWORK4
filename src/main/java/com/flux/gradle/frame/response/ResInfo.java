package com.flux.gradle.frame.response;

import com.flux.gradle.frame.module.Domain;
import com.flux.gradle.frame.paging.Page;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ResInfo {

    // 响应时刻
    private String timestamp;
    // 响应状态 200 400
    private Integer code;
    // 响应编号 success(200) fail(400)
    private String message;
    // 响应主题
    private String theme;
    // 响应描述
    private String description;
    // 响应实体
    private Domain domain;
    // 响应实体集合
    private List<?> list;
    // 响应实体分页集合
    private Page page;
    // 响应详情
    private Map<String, Object> detail;

}
