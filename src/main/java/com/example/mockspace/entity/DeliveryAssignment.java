package com.example.mockspace.entity;

import com.example.mockspace.common.Traceable;
import com.example.mockspace.common.TracingFields;
import com.example.mockspace.common.VersionedEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.mockspace.entity.DeliveryAssignmentBillStatus.NORMAL;


/**
 * @author lanjzh
 */
@Entity
@Table(name = "delivery_assignment")
@Where(clause = "deleted_at is null")
@SQLDelete(sql = "update delivery_assignment set deleted_at = now() where id = ? and version <= ?", check =
        ResultCheckStyle.COUNT)
public class DeliveryAssignment implements Traceable, VersionedEntity<String> {

    public DeliveryAssignment(){

    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Embedded
    private TracingFields tracingFields = new TracingFields();

    private String code;

    @Column(name = "sale_org_id")
    private String saleOrgId;

    /**
     * 市场区域
     */
    @Column(name = "market_area_id")
    private String marketAreaId;

    /**
     * 来源单据号
     */
    @Column(name = "src_bill_code")
    private String srcBillCode;

    /**
     * 销售订单号
     */
    @Column(name = "sale_order_code")
    private String saleOrderCode;

    /**
     * 门户要货单号
     */
    @Column(name = "req_order_code")
    private String reqOrderCode;

    /**
     * 交货日期
     */
    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    /**
     * 委托商
     */
    @Column(name = "consignor_id")
    private String consignorId;

    private String consignorAbbrName;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 单据状态
     */
    @Column(name = "bill_status")
    private String billStatus = NORMAL.getCode();

    /**
     * RDC仓单号
     */
    @Column(name = "rdc_order_code")
    private String rdcOrderCode;

    /**
     * U9发货单号
     */
    @Column(name = "u9_delivery_code")
    private String u9DeliveryCode;

    /**
     * WMS发货单号
     */
    @Column(name = "wms_delivery_code")
    private String wmsDeliveryCode;

    /**
     * TMS系统单号
     */
    @Column(name = "tms_system_code")
    private String tmsSystemCode;

    @Column(name = "is_closed")
    private Integer isClosed = 0;

    @Column(name = "scheduled_for")
    private LocalDateTime scheduledFor;

    @Column(name = "is_redo")
    private Integer isRedo = 0;

    @Column(name = "settlement_type")
    private String settlementTypeId;

    @Column(name = "delivery_type")
    private String deliveryTypeId;

    @Column(name = "province_id")
    private String provinceId;

    @Column(name = "city_id")
    private String cityId;

    @Column(name = "county_id")
    private String countyId;

    @Column(name = "remark_on_pick")
    private String remarkOnPick;

    @Column(name = "is_on_plate")
    private Integer isOnPlate = 0;

    /**
     * 回单即返
     */
    @Column(name = "is_receipt_back")
    private Integer isReceiptBack = 0;

    @Column(name = "freight_settlement_type")
    private String freightSettlementTypeId;

    @Column(name = "freight_collect_amount")
    private BigDecimal freightCollectAmount;

    @Column(name = "collect_amount")
    private BigDecimal collectAmount;

    /**
     * 总安排数量
     */
    @Column(name = "total_num")
    private BigDecimal totalNum;

    /**
     * 总毛重
     */
    @Column(name = "total_weight")
    private BigDecimal totalWeight;

    /**
     * 总净重
     */
    @Column(name = "total_net_weight")
    private BigDecimal totalNetWeight;

    /**
     * 总体积
     */
    @Column(name = "total_volume")
    private BigDecimal totalVolume;

    /**
     * 总成交金额
     */
    @Column(name = "total_deal_amount")
    private BigDecimal totalDealAmount;



    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    @Where(clause="type = 'normal'")
    private List<DeliveryAssignmentItem> items;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    @Where(clause="type = 'discount'")
    private List<DeliveryAssignmentItem> discountItems;

    /**
     * 商品套件拆分的子件
     */
    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    @Where(clause="type = 'goodsSuite'")
    private List<DeliveryAssignmentItem> goodsSuiteChildItems;

    private String warehouseId;

    private String stockOrgId;

    private String shopCustomerCode;

    private String settleFinancialOrgCode;

    private String customerId;

    private String idempotentFactor;

    private String reassignedFrom;

    private String isOrderSupplement;

    /**
     * 项目方
     */
    @Column(name = "PRO_COMPANY")
    private String proCompany;

    /**
     * 项目名称
     */
    @Column(name = "PRO_NAME")
    private String proName;

    /**
     * 项目方平台单号
     */
    @Column(name = "PRO_PLATE_NUMBER")
    private String proPlateNumber;

    /**
     * 物流方式
     * @return 物流方式
     */
    @Column(name = "LOGISTICS_MODE")
    private String logisticsModeId;

    public String getLogisticsModeId() {
        return logisticsModeId;
    }

    public void setLogisticsModeId(String logisticsModeId) {
        this.logisticsModeId = logisticsModeId;
    }

    @Version
    private Long version;

    @Column(name = "ORDER_TYPE_ID")
    private String orderTypeId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    public String getSaleOrgId() {
        return saleOrgId;
    }

    public void setSaleOrgId(String saleOrgId) {
        this.saleOrgId = saleOrgId;
    }

    public LocalDateTime getScheduledFor() {
        return scheduledFor;
    }

    public void setScheduledFor(LocalDateTime scheduledFor) {
        this.scheduledFor = scheduledFor;
    }

    public Integer getIsRedo() {
        return isRedo;
    }

    public void setIsRedo(Integer isRedo) {
        this.isRedo = isRedo;
    }

    public String getSettlementTypeId() {
        return settlementTypeId;
    }

    public void setSettlementTypeId(String settlementTypeId) {
        this.settlementTypeId = settlementTypeId;
    }

    public String getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(String deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getRemarkOnPick() {
        return remarkOnPick;
    }

    public void setRemarkOnPick(String remarkOnPick) {
        this.remarkOnPick = remarkOnPick;
    }

    public Integer getIsOnPlate() {
        return isOnPlate;
    }

    public void setIsOnPlate(Integer isOnPlate) {
        this.isOnPlate = isOnPlate;
    }

    public Integer getIsReceiptBack() {
        return isReceiptBack;
    }

    public void setIsReceiptBack(Integer isReceiptBack) {
        this.isReceiptBack = isReceiptBack;
    }

    public String getFreightSettlementTypeId() {
        return freightSettlementTypeId;
    }

    public void setFreightSettlementTypeId(String freightSettlementTypeId) {
        this.freightSettlementTypeId = freightSettlementTypeId;
    }

    public BigDecimal getFreightCollectAmount() {
        return freightCollectAmount;
    }

    public void setFreightCollectAmount(BigDecimal freightCollectAmount) {
        this.freightCollectAmount = freightCollectAmount;
    }

    public BigDecimal getCollectAmount() {
        return collectAmount;
    }

    public void setCollectAmount(BigDecimal collectAmount) {
        this.collectAmount = collectAmount;
    }

    public List<DeliveryAssignmentItem> getItems() {
        if (null == items) {
            return new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<DeliveryAssignmentItem> items) {
        this.items = items;
    }

    public List<DeliveryAssignmentItem> getDiscountItems() {
        if (null == discountItems) {
            return new ArrayList<>();
        }
        return discountItems;
    }

    public void setDiscountItems(List<DeliveryAssignmentItem> discountItems) {
        this.discountItems = discountItems;
    }

    public List<DeliveryAssignmentItem> getGoodsSuiteChildItems() {
        return goodsSuiteChildItems;
    }

    public void setGoodsSuiteChildItems(List<DeliveryAssignmentItem> goodsSuiteChildItems) {
        this.goodsSuiteChildItems = goodsSuiteChildItems;
    }

    public DeliveryAssignment withoutItems() {
        setItems(new ArrayList<>());
        setDiscountItems(new ArrayList<>());
        return this;
    }

    public String getMarketAreaId() {
        return marketAreaId;
    }

    public void setMarketAreaId(String marketAreaId) {
        this.marketAreaId = marketAreaId;
    }

    public String getSrcBillCode() {
        return srcBillCode;
    }

    public void setSrcBillCode(String srcBillCode) {
        this.srcBillCode = srcBillCode;
    }

    public String getSaleOrderCode() {
        return saleOrderCode;
    }

    public void setSaleOrderCode(String saleOrderCode) {
        this.saleOrderCode = saleOrderCode;
    }

    public String getReqOrderCode() {
        return reqOrderCode;
    }

    public void setReqOrderCode(String reqOrderCode) {
        this.reqOrderCode = reqOrderCode;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getConsignorId() {
        return consignorId;
    }

    public void setConsignorId(String consignorId) {
        this.consignorId = consignorId;
    }

    public String getConsignorAbbrName() {
        return consignorAbbrName;
    }

    public void setConsignorAbbrName(String consignorAbbrName) {
        this.consignorAbbrName = consignorAbbrName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getRdcOrderCode() {
        return rdcOrderCode;
    }

    public void setRdcOrderCode(String rdcOrderCode) {
        this.rdcOrderCode = rdcOrderCode;
    }

    public String getU9DeliveryCode() {
        return u9DeliveryCode;
    }

    public void setU9DeliveryCode(String u9DeliveryCode) {
        this.u9DeliveryCode = u9DeliveryCode;
    }

    public String getWmsDeliveryCode() {
        return wmsDeliveryCode;
    }

    public void setWmsDeliveryCode(String wmsDeliveryCode) {
        this.wmsDeliveryCode = wmsDeliveryCode;
    }

    public String getTmsSystemCode() {
        return tmsSystemCode;
    }

    public void setTmsSystemCode(String tmsSystemCode) {
        this.tmsSystemCode = tmsSystemCode;
    }

    public Integer getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStockOrgId() {
        return stockOrgId;
    }

    public void setStockOrgId(String stockOrgId) {
        this.stockOrgId = stockOrgId;
    }

    public String getShopCustomerCode() {
        return shopCustomerCode;
    }

    public void setShopCustomerCode(String shopCustomerCode) {
        this.shopCustomerCode = shopCustomerCode;
    }

    public String getSettleFinancialOrgCode() {
        return settleFinancialOrgCode;
    }

    public void setSettleFinancialOrgCode(String settleFinancialOrgCode) {
        this.settleFinancialOrgCode = settleFinancialOrgCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIdempotentFactor() {
        return idempotentFactor;
    }

    public void setIdempotentFactor(String idempotentFactor) {
        this.idempotentFactor = idempotentFactor;
    }

    public String getReassignedFrom() {
        return reassignedFrom;
    }

    public void setReassignedFrom(String reassignedFrom) {
        this.reassignedFrom = reassignedFrom;
    }

    public String getIsOrderSupplement() {
        return isOrderSupplement;
    }

    public void setIsOrderSupplement(String isOrderSupplement) {
        this.isOrderSupplement = isOrderSupplement;
    }

    public BigDecimal getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(BigDecimal totalNum) {
        this.totalNum = totalNum;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public BigDecimal getTotalNetWeight() {
        return totalNetWeight;
    }

    public void setTotalNetWeight(BigDecimal totalNetWeight) {
        this.totalNetWeight = totalNetWeight;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(BigDecimal totalVolume) {
        this.totalVolume = totalVolume;
    }

    public BigDecimal getTotalDealAmount() {
        return totalDealAmount;
    }

    public void setTotalDealAmount(BigDecimal totalDealAmount) {
        this.totalDealAmount = totalDealAmount;
    }

    public String getProCompany() {
        return proCompany;
    }

    public void setProCompany(String proCompany) {
        this.proCompany = proCompany;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPlateNumber() {
        return proPlateNumber;
    }

    public void setProPlateNumber(String proPlateNumber) {
        this.proPlateNumber = proPlateNumber;
    }

    public String getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public DeliveryAssignment reassignAssignment() {
        DeliveryAssignment reassign = new DeliveryAssignment();
        reassign.setBillStatus(NORMAL.getCode());
        reassign.setCityId(this.cityId);
        reassign.setConsignorId(this.consignorId);
        reassign.setCountyId(this.countyId);
        reassign.setDeliveryDate(this.deliveryDate);
        reassign.setDeliveryTypeId(this.deliveryTypeId);
        reassign.setFreightSettlementTypeId(this.freightSettlementTypeId);
        reassign.setIsClosed(0);
        reassign.setIsOnPlate(this.isOnPlate);
        reassign.setIsReceiptBack(this.isReceiptBack);
        reassign.setIsRedo(1);
        reassign.setTotalNum(this.totalNum);
        reassign.setTotalWeight(this.totalWeight);
        reassign.setTotalNetWeight(this.totalNetWeight);
        reassign.setTotalVolume(this.totalVolume);
        reassign.setTotalDealAmount(this.totalDealAmount);
        reassign.setMarketAreaId(this.marketAreaId);
        reassign.setProvinceId(this.provinceId);
        reassign.setRemark(this.remark);
        reassign.setRemarkOnPick(this.remarkOnPick);
        reassign.setReqOrderCode(this.reqOrderCode);
        reassign.setSaleOrderCode(this.saleOrderCode);
        reassign.setSaleOrgId(this.saleOrgId);
        reassign.setScheduledFor(this.scheduledFor);
        reassign.setSrcBillCode(this.srcBillCode);
        reassign.setSettlementTypeId(this.settlementTypeId);
        reassign.setReassignedFrom(this.id);
        reassign.setWarehouseId(this.warehouseId);
        reassign.setStockOrgId(this.stockOrgId);
        reassign.setShopCustomerCode(this.shopCustomerCode);
        reassign.setSettleFinancialOrgCode(this.settleFinancialOrgCode);
        reassign.setCustomerId(this.customerId);
        reassign.setFreightCollectAmount(this.freightCollectAmount);
        reassign.setCollectAmount(this.collectAmount);
        TracingFields tracingFields = new TracingFields();
        tracingFields.setCreatedBy(this.getTracingFields().getCreatedBy());
        reassign.setTracingFields(tracingFields);
        return reassign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAssignment that = (DeliveryAssignment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(saleOrgId, that.saleOrgId) &&
                Objects.equals(marketAreaId, that.marketAreaId) &&
                Objects.equals(srcBillCode, that.srcBillCode) &&
                Objects.equals(saleOrderCode, that.saleOrderCode) &&
                Objects.equals(reqOrderCode, that.reqOrderCode) &&
                Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(consignorId, that.consignorId) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(billStatus, that.billStatus) &&
                Objects.equals(rdcOrderCode, that.rdcOrderCode) &&
                Objects.equals(u9DeliveryCode, that.u9DeliveryCode) &&
                Objects.equals(wmsDeliveryCode, that.wmsDeliveryCode) &&
                Objects.equals(tmsSystemCode, that.tmsSystemCode) &&
                Objects.equals(isClosed, that.isClosed) &&
                Objects.equals(scheduledFor, that.scheduledFor) &&
                Objects.equals(isRedo, that.isRedo) &&
                Objects.equals(settlementTypeId, that.settlementTypeId) &&
                Objects.equals(deliveryTypeId, that.deliveryTypeId) &&
                Objects.equals(provinceId, that.provinceId) &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(countyId, that.countyId) &&
                Objects.equals(remarkOnPick, that.remarkOnPick) &&
                Objects.equals(isOnPlate, that.isOnPlate) &&
                Objects.equals(isReceiptBack, that.isReceiptBack) &&
                Objects.equals(freightSettlementTypeId, that.freightSettlementTypeId) &&
                Objects.equals(freightCollectAmount, that.freightCollectAmount) &&
                Objects.equals(collectAmount, that.collectAmount) &&
                Objects.equals(warehouseId, that.warehouseId) &&
                Objects.equals(stockOrgId, that.stockOrgId) &&
                Objects.equals(shopCustomerCode, that.shopCustomerCode) &&
                Objects.equals(settleFinancialOrgCode, that.settleFinancialOrgCode) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(reassignedFrom, that.reassignedFrom) &&
                Objects.equals(isOrderSupplement, that.isOrderSupplement) &&
                Objects.equals(logisticsModeId, that.logisticsModeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, saleOrgId, marketAreaId, srcBillCode, saleOrderCode, reqOrderCode, deliveryDate, consignorId, remark, billStatus, rdcOrderCode, u9DeliveryCode, wmsDeliveryCode, tmsSystemCode, isClosed, scheduledFor, isRedo, settlementTypeId, deliveryTypeId, provinceId, cityId, countyId, remarkOnPick, isOnPlate, isReceiptBack, freightSettlementTypeId, freightCollectAmount, collectAmount, warehouseId, stockOrgId, shopCustomerCode, settleFinancialOrgCode, customerId, reassignedFrom, isOrderSupplement, logisticsModeId);
    }

    @Override
    public String toString() {
        return "DeliveryAssignment{" +
                "id='" + id + '\'' +
                ", tracingFields=" + tracingFields +
                ", code='" + code + '\'' +
                ", saleOrgId='" + saleOrgId + '\'' +
                ", marketAreaId='" + marketAreaId + '\'' +
                ", srcBillCode='" + srcBillCode + '\'' +
                ", saleOrderCode='" + saleOrderCode + '\'' +
                ", reqOrderCode='" + reqOrderCode + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", consignorId='" + consignorId + '\'' +
                ", remark='" + remark + '\'' +
                ", billStatus='" + billStatus + '\'' +
                ", rdcOrderCode='" + rdcOrderCode + '\'' +
                ", u9DeliveryCode='" + u9DeliveryCode + '\'' +
                ", wmsDeliveryCode='" + wmsDeliveryCode + '\'' +
                ", tmsSystemCode='" + tmsSystemCode + '\'' +
                ", isClosed=" + isClosed +
                ", scheduledFor=" + scheduledFor +
                ", isRedo=" + isRedo +
                ", settlementTypeId='" + settlementTypeId + '\'' +
                ", deliveryTypeId='" + deliveryTypeId + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", cityId='" + cityId + '\'' +
                ", countyId='" + countyId + '\'' +
                ", remarkOnPick='" + remarkOnPick + '\'' +
                ", isOnPlate=" + isOnPlate +
                ", isReceiptBack=" + isReceiptBack +
                ", freightSettlementType='" + freightSettlementTypeId + '\'' +
                ", freightCollectAmount=" + freightCollectAmount +
                ", collectAmount=" + collectAmount +
                ", warehouseId=" + warehouseId +
                ", stockOrgId=" + stockOrgId +
                ", version=" + version +
                ", isOrderSupplement=" + isOrderSupplement +
                '}';
    }
}
