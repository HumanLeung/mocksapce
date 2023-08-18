package com.example.mockspace.common;

/**
 * 可追溯接口，需要实现跟踪字段CommonFields的getter/setter
 * @author lanjzh
 */
public interface Traceable {

    /**
     * 跟踪字段getter
     * @return 跟踪字段对象
     */
    TracingFields getTracingFields();

    /**
     * 跟踪字段setter
     * @param tracingFields 跟踪字段对象
     */
    void setTracingFields(TracingFields tracingFields);
}
