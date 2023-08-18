package com.example.mockspace.entity;

public enum BillCodeRuleEnum {

    /**
     * 发货安排
     */
    DELIVERY_ASSIGNMENT("DAVCO_DELIVERY_ASSIGNMENT");

    private String code;

    BillCodeRuleEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
