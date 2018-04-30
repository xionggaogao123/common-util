package com.common.utils.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author keven
 * @date 2017-12-27 下午10:07
 * @Description
 */
public class Paging<T> implements Serializable{

    private static final long serialVersionUID = 607814331615481378L;

    private Long total;
    private List<T> data;

    public Paging(){}

    public Paging(Long total, List<T> data){
        this.total = total;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return Objects.equals(0L, total) || data == null || data.isEmpty();
    }

    public static <T> Paging<T> empty(Class<T> clazz) {
        List<T> emptyList = Collections.emptyList();
        return new Paging<T>(0L, emptyList);
    }

    public static <T> Paging<T> empty() {
        return new Paging<T>(0L, Collections.<T>emptyList());
    }
}
