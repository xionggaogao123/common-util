package com.common.utils.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @author keven
 * @date 2018-04-30 下午9:58
 * @Description
 */
@Slf4j
public abstract class BaseService<T> {

    protected abstract BaseMyBatisDao<T> getEntityDao();




}
