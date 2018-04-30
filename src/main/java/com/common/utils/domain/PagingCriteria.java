package com.common.utils.domain;


import com.common.utils.base.BaseCriteria;

import java.util.Map;

/**
 * @author keven
 * @date 2018-01-26 下午3:20
 * @Description
 */
public class PagingCriteria extends BaseCriteria {

    private static final long serialVersionUID = 7274617154067354808L;

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    private Boolean hasNext = true;

    public PagingCriteria() {

    }

    public void nextPage() {
        if (this.pageNo == null) {
            this.pageNo = 1;
        }
        this.pageNo = this.pageNo + 1;
    }

    public Integer getLimit() {
        PageInfo pageInfo = new PageInfo(this.pageNo, this.pageSize);
        return pageInfo.getLimit();
    }

    public Integer getOffset() {
        PageInfo pageInfo = new PageInfo(this.pageNo, this.pageSize);
        return pageInfo.getOffset();
    }

    @Override
    public Map<String, Object> toMap() {
        this.formatDate();
        return super.toMap();
    }

    protected void formatDate() {

    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

}
