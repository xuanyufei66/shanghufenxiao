package com.payease.scfordermis.bean;

import org.springframework.data.domain.Sort;

/**
 * Created by ljp on 2018/1/4.
 */
public class PageRequest {

    /**
     *
     * @param page
     * @param size
     * @return
     */
    public static org.springframework.data.domain.PageRequest of(int page, int size) {
        return of(page, size, null);
    }


    /**
     *
     * @param page 当前页
     * @param size 每页条数
     * @param sort 排序对象
     * @return
     */
    public static org.springframework.data.domain.PageRequest of(int page, int size, Sort sort) {
        return new org.springframework.data.domain.PageRequest(page - 1, size, sort);
    }
}
