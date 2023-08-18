package com.example.mockspace.dto;

import com.example.mockspace.common.VersionedResponse;
import com.yonyou.ocm.common.annos.Display;
import com.yonyou.ocm.common.bills.BillOwnerIdFields;
import com.yonyou.ocm.common.entity.FieldDisplay;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author lanjzh
 */
@BillOwnerIdFields(
        ownerBillId = "assignmentId"
)
public class DeliveryAssignmentItemDto extends VersionedResponse {

    public DeliveryAssignmentItemDto(){

    }

    private String id;
    private String assignmentId;
    @FieldDisplay(showName = "出货安排单号")
    private String assignmentCode;

    @FieldDisplay(showName = "行号")
    private String row;

    private String customerId;

    @Display("客户编码")
    @FieldDisplay(showName = "客户编码")
    private String customerCode;
    @Display("客户名称")
    @FieldDisplay(showName = "客户名称")
    private String customerName;

    private String goodsId;

    @FieldDisplay(showName = "商品编码")
    private String goodsCode;

    @FieldDisplay(showName = "商品名称")
    private String goodsName;

    @FieldDisplay(showName = "是否卸货")
    private Integer isDischarge = 0;

    private String supplierId;

    @FieldDisplay(showName = "委托商编码")
    private String supplierCode;
    @FieldDisplay(showName = "委托商名称")
    private String supplierName;

    @FieldDisplay(showName = "本次安排数量")
    private BigDecimal num;

    @FieldDisplay(showName = "收货地址")
    private String receiveAddress;

    @FieldDisplay(showName = "收货人")
    private String receiver;

    /**
     * 销售部门
     */
    private String salesDeptId;

    @FieldDisplay(showName = "销售部门编码")
    private String salesDeptCode;


    @FieldDisplay(showName = "销售部门名称")
    private String salesDeptName;

    /**
     * 客户经理
     */
    private String salesManagerId;
    @FieldDisplay(showName = "客户经理编码")
    private String salesManagerCode;
    @FieldDisplay(showName = "客户经理名称")
    private String salesManagerName;

    /**
     * 客户分类
     */
    private String customerCategoryId;

    @FieldDisplay(showName = "客户分类编码")
    private String customerCategoryCode;
    @FieldDisplay(showName = "客户分类名称")
    private String customerCategoryName;

    /**
     * 实际出库数量
     */
    private BigDecimal actualDelivered;

    /**
     * 重量
     */
    @FieldDisplay(showName = "重量")
    private BigDecimal weight;

    /**
     * 行合计重量
     */

    @FieldDisplay(showName = "行合计重量")
    private BigDecimal rowWeight;

    /**
     * 重量单位
     */

    private String weightUnit;

    /**
     * 重量单位编码
     */
    @FieldDisplay(showName = "重量单位编码")
    private String weightUnitCode;

    /**
     * 重量单位名称
     */

    @FieldDisplay(showName = "重量单位名称")
    private String weightUnitName;

    /**
     * 收货人电话
     */
    @FieldDisplay(showName = "收货人电话")
    private String receiverPhone;

    /**
     * 备注
     */
    @FieldDisplay(showName = "行备注")
    private String remark;

    private String receiveProvince;
    private String receiveCity;
    private String receiveCounty;
    private String receiveTown;

    private String sourceRowId;

    /**
     * 单位
     */
    private String unit;

    /**
     * 规格
     */
    private String specification;

    /**
     * 净重
     */
    @FieldDisplay(showName = "净重")
    private BigDecimal netWeight;

    /**
     * 行净重合计
     */
    private BigDecimal rowNetWeight;

    @FieldDisplay(showName = "体积")
    private BigDecimal volume;

    /**
     * 行体积合计
     */

    @FieldDisplay(showName = "行体积合计")
    private BigDecimal rowVolume;

    /**
     * 体积单位
     */

    private String volumeUnit;

    /**
     * 体积单位编码
     */
    @FieldDisplay(showName = "体积单位编码")
    private String volumeUnitCode;

    /**
     * 体积单位名称
     */
    @FieldDisplay(showName = "体积单位名称")
    private String volumeUnitName;

    /**
     * 成交价格
     */
    @FieldDisplay(showName = "成交价格")
    private BigDecimal dealPrice;

    /**
     * 成交金额
     */
    @FieldDisplay(showName = "成交金额")
    private BigDecimal dealAmount;

    private BigDecimal price;

    private String saleOrderItemId;

    private String goodsSuiteType;
    /**
     * 是否为赠品
     */

    @FieldDisplay(showName = "是否赠品")
    private Integer isGift;

    /**
     * 是否为货补
     */

    @FieldDisplay(showName = "是否货补")
    private Integer goodsSupplement;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getIsDischarge() {
        return isDischarge;
    }

    public void setIsDischarge(Integer isDischarge) {
        this.isDischarge = isDischarge;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSalesDeptId() {
        return salesDeptId;
    }

    public void setSalesDeptId(String salesDeptId) {
        this.salesDeptId = salesDeptId;
    }

    public String getSalesDeptCode() {
        return salesDeptCode;
    }

    public void setSalesDeptCode(String salesDeptCode) {
        this.salesDeptCode = salesDeptCode;
    }

    public String getSalesDeptName() {
        return salesDeptName;
    }

    public void setSalesDeptName(String salesDeptName) {
        this.salesDeptName = salesDeptName;
    }

    public String getSalesManagerId() {
        return salesManagerId;
    }

    public void setSalesManagerId(String salesManagerId) {
        this.salesManagerId = salesManagerId;
    }

    public String getSalesManagerCode() {
        return salesManagerCode;
    }

    public void setSalesManagerCode(String salesManagerCode) {
        this.salesManagerCode = salesManagerCode;
    }

    public String getSalesManagerName() {
        return salesManagerName;
    }

    public void setSalesManagerName(String salesManagerName) {
        this.salesManagerName = salesManagerName;
    }

    public String getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(String customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
    }

    public String getCustomerCategoryCode() {
        return customerCategoryCode;
    }

    public void setCustomerCategoryCode(String customerCategoryCode) {
        this.customerCategoryCode = customerCategoryCode;
    }

    public String getCustomerCategoryName() {
        return customerCategoryName;
    }

    public void setCustomerCategoryName(String customerCategoryName) {
        this.customerCategoryName = customerCategoryName;
    }

    public BigDecimal getActualDelivered() {
        return actualDelivered;
    }

    public void setActualDelivered(BigDecimal actualDelivered) {
        this.actualDelivered = actualDelivered;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getRowWeight() {
        return rowWeight;
    }

    public void setRowWeight(BigDecimal rowWeight) {
        this.rowWeight = rowWeight;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReceiveProvince() {
        return receiveProvince;
    }

    public void setReceiveProvince(String receiveProvince) {
        this.receiveProvince = receiveProvince;
    }

    public String getReceiveCity() {
        return receiveCity;
    }

    public void setReceiveCity(String receiveCity) {
        this.receiveCity = receiveCity;
    }

    public String getReceiveCounty() {
        return receiveCounty;
    }

    public void setReceiveCounty(String receiveCounty) {
        this.receiveCounty = receiveCounty;
    }

    public String getReceiveTown() {
        return receiveTown;
    }

    public void setReceiveTown(String receiveTown) {
        this.receiveTown = receiveTown;
    }

    public String getSourceRowId() {
        return sourceRowId;
    }

    public void setSourceRowId(String sourceRowId) {
        this.sourceRowId = sourceRowId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSaleOrderItemId() {
        return saleOrderItemId;
    }

    public void setSaleOrderItemId(String saleOrderItemId) {
        this.saleOrderItemId = saleOrderItemId;
    }

    public String getGoodsSuiteType() {
        return goodsSuiteType;
    }

    public void setGoodsSuiteType(String goodsSuiteType) {
        this.goodsSuiteType = goodsSuiteType;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public BigDecimal getRowNetWeight() {
        return rowNetWeight;
    }

    public void setRowNetWeight(BigDecimal rowNetWeight) {
        this.rowNetWeight = rowNetWeight;
    }

    public BigDecimal getRowVolume() {
        return rowVolume;
    }

    public void setRowVolume(BigDecimal rowVolume) {
        this.rowVolume = rowVolume;
    }

    public String getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }

    public String getWeightUnitCode() {
        return weightUnitCode;
    }

    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode;
    }

    public String getWeightUnitName() {
        return weightUnitName;
    }

    public void setWeightUnitName(String weightUnitName) {
        this.weightUnitName = weightUnitName;
    }

    public String getVolumeUnitCode() {
        return volumeUnitCode;
    }

    public void setVolumeUnitCode(String volumeUnitCode) {
        this.volumeUnitCode = volumeUnitCode;
    }

    public String getVolumeUnitName() {
        return volumeUnitName;
    }

    public void setVolumeUnitName(String volumeUnitName) {
        this.volumeUnitName = volumeUnitName;
    }

    public Integer getIsGift() {
        return isGift;
    }

    public void setIsGift(Integer isGift) {
        this.isGift = isGift;
    }

    public Integer getGoodsSupplement() {
        return goodsSupplement;
    }

    public void setGoodsSupplement(Integer goodsSupplement) {
        this.goodsSupplement = goodsSupplement;
    }

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAssignmentItemDto that = (DeliveryAssignmentItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(assignmentId, that.assignmentId) && Objects.equals(assignmentCode, that.assignmentCode) && Objects.equals(row, that.row) && Objects.equals(customerId, that.customerId) && Objects.equals(customerCode, that.customerCode) && Objects.equals(customerName, that.customerName) && Objects.equals(goodsId, that.goodsId) && Objects.equals(goodsCode, that.goodsCode) && Objects.equals(goodsName, that.goodsName) && Objects.equals(isDischarge, that.isDischarge) && Objects.equals(supplierId, that.supplierId) && Objects.equals(supplierCode, that.supplierCode) && Objects.equals(supplierName, that.supplierName) && Objects.equals(num, that.num) && Objects.equals(receiveAddress, that.receiveAddress) && Objects.equals(receiver, that.receiver) && Objects.equals(salesDeptId, that.salesDeptId) && Objects.equals(salesDeptCode, that.salesDeptCode) && Objects.equals(salesDeptName, that.salesDeptName) && Objects.equals(salesManagerId, that.salesManagerId) && Objects.equals(salesManagerCode, that.salesManagerCode) && Objects.equals(salesManagerName, that.salesManagerName) && Objects.equals(customerCategoryId, that.customerCategoryId) && Objects.equals(customerCategoryCode, that.customerCategoryCode) && Objects.equals(customerCategoryName, that.customerCategoryName) && Objects.equals(actualDelivered, that.actualDelivered) && Objects.equals(weight, that.weight) && Objects.equals(rowWeight, that.rowWeight) && Objects.equals(weightUnit, that.weightUnit) && Objects.equals(weightUnitCode, that.weightUnitCode) && Objects.equals(weightUnitName, that.weightUnitName) && Objects.equals(receiverPhone, that.receiverPhone) && Objects.equals(remark, that.remark) && Objects.equals(receiveProvince, that.receiveProvince) && Objects.equals(receiveCity, that.receiveCity) && Objects.equals(receiveCounty, that.receiveCounty) && Objects.equals(receiveTown, that.receiveTown) && Objects.equals(sourceRowId, that.sourceRowId) && Objects.equals(unit, that.unit) && Objects.equals(specification, that.specification) && Objects.equals(netWeight, that.netWeight) && Objects.equals(rowNetWeight, that.rowNetWeight) && Objects.equals(volume, that.volume) && Objects.equals(rowVolume, that.rowVolume) && Objects.equals(volumeUnit, that.volumeUnit) && Objects.equals(volumeUnitCode, that.volumeUnitCode) && Objects.equals(volumeUnitName, that.volumeUnitName) && Objects.equals(dealPrice, that.dealPrice) && Objects.equals(dealAmount, that.dealAmount) && Objects.equals(price, that.price) && Objects.equals(saleOrderItemId, that.saleOrderItemId) && Objects.equals(goodsSuiteType, that.goodsSuiteType) && Objects.equals(isGift, that.isGift) && Objects.equals(goodsSupplement, that.goodsSupplement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assignmentId, assignmentCode, row, customerId, customerCode, customerName, goodsId, goodsCode, goodsName, isDischarge, supplierId, supplierCode, supplierName, num, receiveAddress, receiver, salesDeptId, salesDeptCode, salesDeptName, salesManagerId, salesManagerCode, salesManagerName, customerCategoryId, customerCategoryCode, customerCategoryName, actualDelivered, weight, rowWeight, weightUnit, weightUnitCode, weightUnitName, receiverPhone, remark, receiveProvince, receiveCity, receiveCounty, receiveTown, sourceRowId, unit, specification, netWeight, rowNetWeight, volume, rowVolume, volumeUnit, volumeUnitCode, volumeUnitName, dealPrice, dealAmount, price, saleOrderItemId, goodsSuiteType, isGift, goodsSupplement);
    }

    @Override
    public String toString() {
        return "DeliveryAssignmentItemDto{" +
                "id='" + id + '\'' +
                ", assignmentId='" + assignmentId + '\'' +
                ", row='" + row + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", isDischarge=" + isDischarge +
                ", supplierId='" + supplierId + '\'' +
                ", supplierCode='" + supplierCode + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", num=" + num +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", receiver='" + receiver + '\'' +
                ", salesDeptId='" + salesDeptId + '\'' +
                ", salesDeptCode='" + salesDeptCode + '\'' +
                ", salesDeptName='" + salesDeptName + '\'' +
                ", salesManagerId='" + salesManagerId + '\'' +
                ", salesManagerCode='" + salesManagerCode + '\'' +
                ", salesManagerName='" + salesManagerName + '\'' +
                ", customerCategoryId='" + customerCategoryId + '\'' +
                ", customerCategoryCode='" + customerCategoryCode + '\'' +
                ", customerCategoryName='" + customerCategoryName + '\'' +
                ", actualDelivered=" + actualDelivered +
                ", weight=" + weight +
                ", rowWeight=" + rowWeight +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
