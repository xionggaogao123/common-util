package com.common.utils.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author keven
 * @date 2018-04-30 下午9:49
 * @Description 其他的domain 可以依赖这个baseDomain ，其他的任何实体都会包含这三个字段
 */
@Data
public class BaseDomain implements Serializable{

    private static final long serialVersionUID = -7402918977578342546L;

    private Long id;

    private Date createTime;

    private Date updateTime;
}
