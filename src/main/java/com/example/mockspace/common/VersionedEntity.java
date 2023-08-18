package com.example.mockspace.common;

/**
 * 乐观锁实体类型
 * @param <T> 主键类型
 *
 * @author lanjzh
 */
public interface VersionedEntity<T> extends Entity<T> {

    /**
     * 乐观锁版本
     * @return 乐观锁版本
     */
    Long getVersion();

    /**
     * 设置乐观锁版本
     * @param version 乐观锁版本
     */
    void setVersion(Long version);
}
