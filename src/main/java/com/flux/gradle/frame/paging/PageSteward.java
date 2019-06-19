package com.flux.gradle.frame.paging;

import com.flux.gradle.frame.util.VE;

public class PageSteward {

    /**
     * @param pageSize   页大小
     * @param pageNumber 第几页
     * @return 本页第一条记录是总记录数中的第几个元素（从0开始）：页大小 * （第几页 - 1）
     */
    public static Integer start(Integer pageSize, Integer pageNumber) {
        if (VE.isEmptyArr(pageSize, pageNumber) || pageNumber < 1 || pageSize <= 0) {
            return 0;
        }
        return pageSize * (pageNumber - 1);
    }

    /**
     * @param start    所有元素中的第几个元素（从0开始）
     * @param pageSize 页大小
     * @return 本页最后一个元素在总记录中的第几个元素：start + pageSize
     */
    public static Integer end(Integer start, Integer pageSize) {
        if (VE.isEmptyArr(start, pageSize) || start < 0 || pageSize <= 0) {
            return 0;
        }
        return start + pageSize;
    }

    public static Integer getTotalPages(Integer totalElements, Integer pageSize) {
        if (VE.isEmptyArr(totalElements, pageSize) || totalElements < 0 || pageSize <= 0) {
            return 0;
        }
        return totalElements % pageSize == 0 ? totalElements / pageSize : totalElements / pageSize + 1;
    }
}
