package com.example.mockspace.common;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author lanjzh
 */
public interface Validatable<T> {

    /**
     * 实现此方法，以Consumer作为类型添加一個或多個校验器
     * @return 校验器集合
     */
    List<Consumer<T>> validators();

    /**
     * 执行所有校验
     * @param t 校验实体
     */
    default void validate(T t) {
        validators().forEach(e -> e.accept(t));
    }
}
