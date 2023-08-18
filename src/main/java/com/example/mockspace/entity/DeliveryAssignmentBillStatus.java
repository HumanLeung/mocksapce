package com.example.mockspace.entity;

public enum DeliveryAssignmentBillStatus {

    NORMAL("01", "待处理"),
    COMMITTED("02", "已提交"),
    APPROVING("03", "审批中"),
    APPROVED("04", "审批通过"),
    REJECTED("05", "审批不通过");

    private String code;

    private String name;

    private DeliveryAssignmentBillStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
