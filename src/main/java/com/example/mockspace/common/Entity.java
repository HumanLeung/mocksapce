package com.example.mockspace.common;

import java.io.Serializable;

/**
 * 实体类型
 * @param <T> 主键类型
 *
 * @author lanjzh
 */
public interface Entity<T> extends Serializable {

    /**
     * 获取主键
     * @return 主键
     */
    T getId();

    /**
     * 设置主键
     * @param id 主键
     */
    void setId(T id);
}
