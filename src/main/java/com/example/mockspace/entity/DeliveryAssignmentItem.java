package com.example.mockspace.entity;

import com.example.mockspace.common.Traceable;
import com.example.mockspace.common.TracingFields;
import com.example.mockspace.common.VersionedEntity;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author lanjzh
 */
@Entity
@Table(name = "delivery_assignment_item")
@Where(clause = "deleted_at is null")
@SQLDelete(sql = "update delivery_assignment_item set deleted_at = now() where id = ? and version <= ?", check =
        ResultCheckStyle.COUNT)
public class DeliveryAssignmentItem implements Traceable, VersionedEntity<String> {

    public DeliveryAssignmentItem(){

    }
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private DeliveryAssignment assignment;

    @Embedded
    private TracingFields tracingFields = new TracingFields();

    @Version
    private Long version;

    private String row;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "goods_id")
    private String goodsId;

    @Column(name = "is_discharge")
    private Integer isDischarge = 0;

    @Column(name = "supplier_id")
    private String supplierId;

    private BigDecimal num;

    @Column(name = "receive_address")
    private String receiveAddress;

    private String receiver;

    /**
     * 销售部门
     */
    @Column(name = "sales_dept_id")
    private String salesDeptId;

    /**
     * 客户经理
     */
    @Column(name = "sales_manager_id")
    private String salesManagerId;

    /**
     * 客户分类
     */
    @Column(name = "customer_category_id")
    private String customerCategoryId;

    /**
     * 重量（毛重）
     */
    @Column(name = "weight")
    private BigDecimal weight;

    /**
     * 重量单位
     */
    @Column(name = "weight_unit")
    private String weightUnit;

    /**
     * 行合计重量（毛重）
     */
    @Column(name = "row_weight")
    private BigDecimal rowWeight;

    /**
     * 收货人电话
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    private String receiveProvince;
    private String receiveCity;
    private String receiveCounty;
    private String receiveTown;

    private Integer isGift;

    private Integer goodsSupplement;

    private BigDecimal price;

    private String discountCode;

    private BigDecimal discountAmount;

    private String normalGoods;

    private BigDecimal actualDelivered;

    private String sourceRowId;

    /**
     * 体积
     */
    @Column(name = "volume")
    private BigDecimal volume;

    /**
     * 行体积合计
     */
    @Column(name = "row_volume")
    private BigDecimal rowVolume;

    /**
     * 体积单位
     */
    @Column(name = "volume_unit")
    private String volumeUnit;

    /**
     * 成交价格
     */
    @Column(name = "deal_price")
    private BigDecimal dealPrice;

    /**
     * 成交金额
     */
    @Column(name = "deal_amount")
    private BigDecimal dealAmount;

    /**
     * 单位
     */
    @Column(name = "unit")
    private String unit;

    /**
     * 规格
     */
    @Column(name = "specification")
    private String specification;

    /**
     * 净重
     */
    @Column(name = "net_weight")
    private BigDecimal netWeight;

    /**
     * 行净重合计
     */
    @Column(name = "row_net_weight")
    private BigDecimal rowNetWeight;

    private String type = "normal";

    private String batchCodeId;
    private String projectId;
    private Integer srcVersion;
    private String baseGoodsOptId;
    private String baseGoodsOptValue;
    private String saleOrderItemId;

    @Column(name = "goods_suite_type")
    private String goodsSuiteType;

    /**
     * 套件商品子件比例
     */
    @Column(name = "GOODS_SUITE_CHILD_QTY")
    private BigDecimal goodsSuiteChildQty;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public TracingFields getTracingFields() {
        return tracingFields;
    }

    @Override
    public void setTracingFields(TracingFields tracingFields) {
        this.tracingFields = tracingFields;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    public DeliveryAssignment getAssignment() {
        return assignment;
    }

    public void setAssignment(DeliveryAssignment assignment) {
        this.assignment = assignment;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSalesDeptId() {
        return salesDeptId;
    }

    public void setSalesDeptId(String salesDeptId) {
        this.salesDeptId = salesDeptId;
    }

    public String getSalesManagerId() {
        return salesManagerId;
    }

    public void setSalesManagerId(String salesManagerId) {
        this.salesManagerId = salesManagerId;
    }

    public String getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(String customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getNormalGoods() {
        return normalGoods;
    }

    public void setNormalGoods(String normalGoods) {
        this.normalGoods = normalGoods;
    }

    public BigDecimal getActualDelivered() {
        return actualDelivered;
    }

    public void setActualDelivered(BigDecimal actualDelivered) {
        this.actualDelivered = actualDelivered;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBatchCodeId() {
        return batchCodeId;
    }

    public void setBatchCodeId(String batchCodeId) {
        this.batchCodeId = batchCodeId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getSrcVersion() {
        return srcVersion;
    }

    public void setSrcVersion(Integer srcVersion) {
        this.srcVersion = srcVersion;
    }

    public String getBaseGoodsOptId() {
        return baseGoodsOptId;
    }

    public void setBaseGoodsOptId(String baseGoodsOptId) {
        this.baseGoodsOptId = baseGoodsOptId;
    }

    public String getBaseGoodsOptValue() {
        return baseGoodsOptValue;
    }

    public void setBaseGoodsOptValue(String baseGoodsOptValue) {
        this.baseGoodsOptValue = baseGoodsOptValue;
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

    public BigDecimal getGoodsSuiteChildQty() {
        return goodsSuiteChildQty;
    }

    public void setGoodsSuiteChildQty(BigDecimal goodsSuiteChildQty) {
        this.goodsSuiteChildQty = goodsSuiteChildQty;
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

    public BigDecimal getRowNetWeight() {
        return rowNetWeight;
    }

    public void setRowNetWeight(BigDecimal rowNetWeight) {
        this.rowNetWeight = rowNetWeight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAssignmentItem that = (DeliveryAssignmentItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(row, that.row) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(goodsId, that.goodsId) &&
                Objects.equals(isDischarge, that.isDischarge) &&
                Objects.equals(supplierId, that.supplierId) &&
                Objects.equals(num, that.num) &&
                Objects.equals(receiveAddress, that.receiveAddress) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(salesDeptId, that.salesDeptId) &&
                Objects.equals(salesManagerId, that.salesManagerId) &&
                Objects.equals(customerCategoryId, that.customerCategoryId) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(rowWeight, that.rowWeight) &&
                Objects.equals(receiverPhone, that.receiverPhone) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(receiveProvince, that.receiveProvince) &&
                Objects.equals(receiveCity, that.receiveCity) &&
                Objects.equals(receiveCounty, that.receiveCounty) &&
                Objects.equals(receiveTown, that.receiveTown) &&
                Objects.equals(isGift, that.isGift) &&
                Objects.equals(goodsSupplement, that.goodsSupplement) &&
                Objects.equals(price, that.price) &&
                Objects.equals(discountCode, that.discountCode) &&
                Objects.equals(discountAmount, that.discountAmount) &&
                Objects.equals(normalGoods, that.normalGoods) &&
                Objects.equals(actualDelivered, that.actualDelivered) &&
                Objects.equals(sourceRowId, that.sourceRowId) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(specification, that.specification) &&
                Objects.equals(netWeight, that.netWeight) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, customerId, goodsId, isDischarge, supplierId, num,
                receiveAddress, receiver, salesDeptId, salesManagerId, customerCategoryId, weight,
                rowWeight, receiverPhone, remark, receiveProvince, receiveCity, receiveCounty, receiveTown, isGift,
                goodsSupplement, price, discountCode, discountAmount, normalGoods, actualDelivered, sourceRowId, unit,
                specification, netWeight, type);
    }

    @Override
    public String toString() {
        return "DeliveryAssignmentItem{" +
                "id='" + id + '\'' +
                ", tracingFields=" + tracingFields +
                ", version=" + version +
                ", row='" + row + '\'' +
                ", customerId='" + customerId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", isDischarge=" + isDischarge +
                ", supplierId='" + supplierId + '\'' +
                ", num=" + num +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", receiver='" + receiver + '\'' +
                ", salesDeptId='" + salesDeptId + '\'' +
                ", salesManagerId='" + salesManagerId + '\'' +
                ", customerCategoryId='" + customerCategoryId + '\'' +
                ", weight='" + weight + '\'' +
                ", rowWeight='" + rowWeight + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
