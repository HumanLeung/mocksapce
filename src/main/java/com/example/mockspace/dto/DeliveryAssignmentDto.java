package com.example.mockspace.dto;

import com.example.mockspace.common.LocalDateTimeDeserializer;
import com.example.mockspace.common.VersionedResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.yonyou.ocm.common.annos.Display;
import com.yonyou.ocm.common.entity.ChildClass;
import com.yonyou.ocm.common.entity.FieldDisplay;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author lanjzh
 */
@Display("出货安排单")
public class DeliveryAssignmentDto extends VersionedResponse {

    public DeliveryAssignmentDto(){

    }

    private String id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @FieldDisplay(showName = "创建时间")
    private LocalDateTime createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @FieldDisplay(showName = "修改时间")
    private LocalDateTime updatedAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime deletedAt;

    private String createdBy;

    private String updatedBy;

    private String deletedBy;

    @Display("出货安排单号")
    @FieldDisplay(showName = "出货安排单号")
    private String code;
    @Display("销售组织主键")
    private String saleOrgId;
    @Display("销售组织编码")
    @FieldDisplay(showName = "销售组织编码")
    private String saleOrgCode;
    @Display("销售组织名称")
    @FieldDisplay(
            showName = "销售组织名称"
    )
    private String saleOrgName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @FieldDisplay(showName = "交货日期")
    @Display("交货日期")
    private LocalDateTime scheduledFor;

    @FieldDisplay(showName = "短发补发")
    private Integer isRedo = 0;

    @Display("结算方式主键")
    private String settlementTypeId;

    @Display("结算方式编码")
    @FieldDisplay(showName = "结算方式编码")
    private String settlementTypeCode;

    @Display("结算方式名称")
    @FieldDisplay(showName = "结算方式名称")
    private String settlementTypeName;

    @Display("运输方式主键")
    private String deliveryTypeId;

    @Display("运输方式编码")
    @FieldDisplay(showName = "运输方式编码")
    private String deliveryTypeCode;

    @Display("运输方式名称")
    @FieldDisplay(showName = "运输方式名称")
    private String deliveryTypeName;

    @FieldDisplay(showName = "配送省")
    private String provinceId;
    @FieldDisplay(showName = "配送省名称")
    private String provinceName;

    @FieldDisplay(showName = "配送市")
    private String cityId;

    @FieldDisplay(showName = "配送市编码")
    private String cityCode;

    @FieldDisplay(showName = "配送市名称")
    private String cityName;

    @FieldDisplay(showName = "配送区县")
    private String countyId;

    @FieldDisplay(showName = "配送区县名称")
    private String countyName;


    @FieldDisplay(showName = "提货信息")
    private String remarkOnPick;


    @FieldDisplay(showName = "是否板装")
    private Integer isOnPlate = 0;

    /**
     * 回单即返
     */

    @FieldDisplay(showName = "回单即返")
    private Integer isReceiptBack = 0;

    @Display("运费结算方式主键")
    private String freightSettlementTypeId;

    @FieldDisplay(showName = "运费结算方式编码")
    private String freightSettlementTypeCode;

    @FieldDisplay(showName = "运费结算方式名称")
    private String freightSettlementTypeName;

    @FieldDisplay(showName = "运费到付金额")
    private BigDecimal freightCollectAmount;

    @FieldDisplay(showName = "到付金额")
    private BigDecimal collectAmount;

    @FieldDisplay(showName = "出货安排单子表")
    @ChildClass(classType = DeliveryAssignmentItemDto.class)
    private List<DeliveryAssignmentItemDto> items;

    private List<DeliveryAssignmentItemDto> goodsSuiteChildItems;

    /**
     * 市场区域
     */
    @Display("市场区域主键")
    private String marketAreaId;
    @Display("市场区域编码")
    @FieldDisplay(
            showName = "市场区域编码"
    )
    private String marketAreaCode;
    @Display("市场区域名称")
    @FieldDisplay(
            showName = "市场区域名称"
    )
    private String marketAreaName;

    /**
     * 来源单据号
     */
    @FieldDisplay(showName = "发货单号")
    private String srcBillCode;

    /**
     * 销售订单号
     */
    @FieldDisplay(showName = "销售订单号")
    private String saleOrderCode;

    /**
     * 门户要货单号
     */
    @FieldDisplay(showName = "要货单号")
    private String reqOrderCode;

    /**
     * 交货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @FieldDisplay(showName = "出货安排日期")
    private LocalDateTime deliveryDate;

    /**
     * 委托商
     */
    private String consignorId;
    @Display("承运商编码")
    @FieldDisplay(showName = "承运商编码")
    private String consignorCode;
    @Display("承运商名称")
    @FieldDisplay(showName = "承运商名称")
    private String consignorName;
    private String consignorAbbrName;

    /**
     * 备注
     */

    @FieldDisplay(showName = "备注")
    private String remark;

    /**
     * 单据状态
     */
    private String billStatus = null;

    /**
     * RDC仓单号
     */
    private String rdcOrderCode;

    /**
     * U9发货单号
     */

    @FieldDisplay(showName = "U9发货单号")
    private String u9DeliveryCode;

    /**
     * WMS发货单号
     */
    private String wmsDeliveryCode;

    /**
     * TMS系统单号
     */
    private String tmsSystemCode;

    @FieldDisplay(showName = "是否关闭")
    private Integer isClosed = 0;

    private String warehouseId;

    @FieldDisplay(showName = "发货仓库编码")
    private String warehouseCode;
    @FieldDisplay(showName = "发货仓库")
    private String warehouseName;

    private String wmsWarehouseCode;

    @Display("发货库存组织主键")
    private String stockOrgId;

    @Display("发货库存组织编码")
    @FieldDisplay(showName = "发货库存组织编码")
    private String stockOrgCode;

    @Display("发货库存组织名称")
    @FieldDisplay(showName = "发货库存组织名称")
    private String stockOrgName;

    @FieldDisplay(showName = "创建人")
    private String creator;

    @Display("客户主键")
    private String customerId;
    @Display("客户编码")
    @FieldDisplay(showName = "客户编码")
    private String customerCode;
    @Display("客户名称")
    @FieldDisplay(showName = "客户名称")
    private String customerName;

    /**
     * 总安排数量
     */
    
    @FieldDisplay(showName = "总安排数量")
    private BigDecimal totalNum;

    /**
     * 总毛重
     */

    @FieldDisplay(showName = "总毛重")
    private BigDecimal totalWeight;

    /**
     * 总净重
     */
    @FieldDisplay(showName = "总净重")
    private BigDecimal totalNetWeight;

    /**
     * 总体积
     */
    @FieldDisplay(showName = "总体积")
    private BigDecimal totalVolume;

    /**
     * 总成交金额
     */
    @FieldDisplay(showName = "总成交金额")
    private BigDecimal totalDealAmount;

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
     * 物流方式Id
     */
    private String logisticsModeId;

    /**
     * 物流方式名称
     */
    private String logisticsModeName;

    /**
     * 物流方式编码
     */
    private String logisticsModeCode;

    /**
     * 订单类型
     */
    private String orderTypeId;

    private String orderTypeCode;

    private String orderTypeName;

    public String getLogisticsModeId() {
        return logisticsModeId;
    }

    public void setLogisticsModeId(String logisticsModeId) {
        this.logisticsModeId = logisticsModeId;
    }

    public String getLogisticsModeName() {
        return logisticsModeName;
    }

    public void setLogisticsModeName(String logisticsModeName) {
        this.logisticsModeName = logisticsModeName;
    }

    public String getLogisticsModeCode() {
        return logisticsModeCode;
    }

    public void setLogisticsModeCode(String logisticsModeCode) {
        this.logisticsModeCode = logisticsModeCode;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSaleOrgId() {
        return saleOrgId;
    }

    public void setSaleOrgId(String saleOrgId) {
        this.saleOrgId = saleOrgId;
    }

    public String getSaleOrgCode() {
        return saleOrgCode;
    }

    public void setSaleOrgCode(String saleOrgCode) {
        this.saleOrgCode = saleOrgCode;
    }

    public String getSaleOrgName() {
        return saleOrgName;
    }

    public void setSaleOrgName(String saleOrgName) {
        this.saleOrgName = saleOrgName;
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

    public String getSettlementTypeCode() {
        return settlementTypeCode;
    }

    public void setSettlementTypeCode(String settlementTypeCode) {
        this.settlementTypeCode = settlementTypeCode;
    }

    public String getSettlementTypeName() {
        return settlementTypeName;
    }

    public void setSettlementTypeName(String settlementTypeName) {
        this.settlementTypeName = settlementTypeName;
    }

    public String getDeliveryTypeId() {
        return deliveryTypeId;
    }

    public void setDeliveryTypeId(String deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
    }

    public String getDeliveryTypeCode() {
        return deliveryTypeCode;
    }

    public void setDeliveryTypeCode(String deliveryTypeCode) {
        this.deliveryTypeCode = deliveryTypeCode;
    }

    public String getDeliveryTypeName() {
        return deliveryTypeName;
    }

    public void setDeliveryTypeName(String deliveryTypeName) {
        this.deliveryTypeName = deliveryTypeName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
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

    public String getFreightSettlementTypeCode() {
        return freightSettlementTypeCode;
    }

    public void setFreightSettlementTypeCode(String freightSettlementTypeCode) {
        this.freightSettlementTypeCode = freightSettlementTypeCode;
    }

    public String getFreightSettlementTypeName() {
        return freightSettlementTypeName;
    }

    public void setFreightSettlementTypeName(String freightSettlementTypeName) {
        this.freightSettlementTypeName = freightSettlementTypeName;
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

    public List<DeliveryAssignmentItemDto> getItems() {
        return items;
    }

    public void setItems(List<DeliveryAssignmentItemDto> items) {
        this.items = items;
    }

    public List<DeliveryAssignmentItemDto> getGoodsSuiteChildItems() {
        return goodsSuiteChildItems;
    }

    public void setGoodsSuiteChildItems(List<DeliveryAssignmentItemDto> goodsSuiteChildItems) {
        this.goodsSuiteChildItems = goodsSuiteChildItems;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getMarketAreaId() {
        return marketAreaId;
    }

    public void setMarketAreaId(String marketAreaId) {
        this.marketAreaId = marketAreaId;
    }

    public String getMarketAreaCode() {
        return marketAreaCode;
    }

    public void setMarketAreaCode(String marketAreaCode) {
        this.marketAreaCode = marketAreaCode;
    }

    public String getMarketAreaName() {
        return marketAreaName;
    }

    public void setMarketAreaName(String marketAreaName) {
        this.marketAreaName = marketAreaName;
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

    public String getConsignorCode() {
        return consignorCode;
    }

    public void setConsignorCode(String consignorCode) {
        this.consignorCode = consignorCode;
    }

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
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

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWmsWarehouseCode() {
        return wmsWarehouseCode;
    }

    public void setWmsWarehouseCode(String wmsWarehouseCode) {
        this.wmsWarehouseCode = wmsWarehouseCode;
    }

    public String getStockOrgId() {
        return stockOrgId;
    }

    public void setStockOrgId(String stockOrgId) {
        this.stockOrgId = stockOrgId;
    }

    public String getStockOrgCode() {
        return stockOrgCode;
    }

    public void setStockOrgCode(String stockOrgCode) {
        this.stockOrgCode = stockOrgCode;
    }

    public String getStockOrgName() {
        return stockOrgName;
    }

    public void setStockOrgName(String stockOrgName) {
        this.stockOrgName = stockOrgName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryAssignmentDto that = (DeliveryAssignmentDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(saleOrgId, that.saleOrgId) &&
                Objects.equals(saleOrgCode, that.saleOrgCode) &&
                Objects.equals(saleOrgName, that.saleOrgName) &&
                Objects.equals(scheduledFor, that.scheduledFor) &&
                Objects.equals(isRedo, that.isRedo) &&
                Objects.equals(settlementTypeCode, that.settlementTypeCode) &&
                Objects.equals(deliveryTypeCode, that.deliveryTypeCode) &&
                Objects.equals(provinceId, that.provinceId) &&
                Objects.equals(provinceName, that.provinceName) &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(cityCode, that.cityCode) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(countyId, that.countyId) &&
                Objects.equals(countyName, that.countyName) &&
                Objects.equals(remarkOnPick, that.remarkOnPick) &&
                Objects.equals(isOnPlate, that.isOnPlate) &&
                Objects.equals(isReceiptBack, that.isReceiptBack) &&
                Objects.equals(freightSettlementTypeCode, that.freightSettlementTypeCode) &&
                Objects.equals(freightCollectAmount, that.freightCollectAmount) &&
                Objects.equals(collectAmount, that.collectAmount) &&
                Objects.equals(items, that.items) &&
                Objects.equals(marketAreaId, that.marketAreaId) &&
                Objects.equals(marketAreaCode, that.marketAreaCode) &&
                Objects.equals(marketAreaName, that.marketAreaName) &&
                Objects.equals(srcBillCode, that.srcBillCode) &&
                Objects.equals(saleOrderCode, that.saleOrderCode) &&
                Objects.equals(reqOrderCode, that.reqOrderCode) &&
                Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(consignorId, that.consignorId) &&
                Objects.equals(consignorCode, that.consignorCode) &&
                Objects.equals(consignorName, that.consignorName) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(billStatus, that.billStatus) &&
                Objects.equals(rdcOrderCode, that.rdcOrderCode) &&
                Objects.equals(u9DeliveryCode, that.u9DeliveryCode) &&
                Objects.equals(wmsDeliveryCode, that.wmsDeliveryCode) &&
                Objects.equals(tmsSystemCode, that.tmsSystemCode) &&
                Objects.equals(warehouseCode, that.warehouseCode) &&
                Objects.equals(stockOrgCode, that.stockOrgCode) &&
                Objects.equals(isClosed, that.isClosed) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(customerCode, that.customerCode) &&
                Objects.equals(customerName, that.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, saleOrgId, saleOrgCode, saleOrgName, scheduledFor, isRedo, settlementTypeCode, deliveryTypeCode, provinceId, provinceName, cityId, cityCode, cityName, countyId, countyName, remarkOnPick, isOnPlate, isReceiptBack, freightSettlementTypeCode, freightCollectAmount, collectAmount, items, marketAreaId, marketAreaCode, marketAreaName, srcBillCode, saleOrderCode, reqOrderCode, deliveryDate, consignorId, consignorCode, consignorName, remark, billStatus, rdcOrderCode, u9DeliveryCode, wmsDeliveryCode, tmsSystemCode, warehouseCode, stockOrgCode, isClosed,customerId,customerCode,customerName);
    }

    @Override
    public String toString() {
        return "DeliveryAssignmentDto{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", saleOrgId='" + saleOrgId + '\'' +
                ", saleOrgCode='" + saleOrgCode + '\'' +
                ", saleOrgName='" + saleOrgName + '\'' +
                ", scheduledFor=" + scheduledFor +
                ", isRedo=" + isRedo +
                ", settlementType='" + settlementTypeCode + '\'' +
                ", deliveryType='" + deliveryTypeCode + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityId='" + cityId + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countyId='" + countyId + '\'' +
                ", countyName='" + countyName + '\'' +
                ", remarkOnPick='" + remarkOnPick + '\'' +
                ", isOnPlate=" + isOnPlate +
                ", isReceiptBack=" + isReceiptBack +
                ", freightSettlementTypeCode='" + freightSettlementTypeCode + '\'' +
                ", freightCollectAmount=" + freightCollectAmount +
                ", collectAmount=" + collectAmount +
                ", items=" + items +
                ", marketAreaId='" + marketAreaId + '\'' +
                ", marketAreaCode='" + marketAreaCode + '\'' +
                ", marketAreaName='" + marketAreaName + '\'' +
                ", srcBillCode='" + srcBillCode + '\'' +
                ", saleOrderCode='" + saleOrderCode + '\'' +
                ", reqOrderCode='" + reqOrderCode + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", consignorId='" + consignorId + '\'' +
                ", consignorCode='" + consignorCode + '\'' +
                ", consignorName='" + consignorName + '\'' +
                ", remark='" + remark + '\'' +
                ", billStatus=" + billStatus +
                ", rdcOrderCode='" + rdcOrderCode + '\'' +
                ", u9DeliveryCode='" + u9DeliveryCode + '\'' +
                ", wmsDeliveryCode='" + wmsDeliveryCode + '\'' +
                ", tmsSystemCode='" + tmsSystemCode + '\'' +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", stockOrgCode='" + stockOrgCode + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}
