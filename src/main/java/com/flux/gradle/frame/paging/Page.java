package com.flux.gradle.frame.paging;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    /**
     * 总页数
     */
    private Integer totalPages;
    /**
     * 总记录数
     */
    private Integer totalElements;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 第几页
     */
    private Integer pageNumber;
    /**
     * 从第几个元素
     */
    private Integer elemStart;
    /**
     * 到第几个元素
     */
    private Integer elemEnd;
    /**
     * 实体集合
     */
    private List<T> domainList;
}
