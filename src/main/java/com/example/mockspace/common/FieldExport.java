package com.example.mockspace.common;

import java.lang.annotation.*;

/**
 * 用于定义导出的字段标题及排序
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldExport {
    /**
     * 字段表头显示名称
     */
    String name();

    /**
     * 字段排序, 数字越小排越前
     */
    int sort() default 0;

    /**
     * 字段列宽(字符数), 最大值为255字符
     */
    int width() default 10;
}
