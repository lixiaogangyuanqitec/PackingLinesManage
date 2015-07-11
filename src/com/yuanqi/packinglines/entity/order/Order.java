package com.yuanqi.packinglines.entity.order;

import java.sql.Timestamp;

/***
 * 订单实体类
 * 
 * @author lixiaogang
 *
 */
public class Order {
	private String orderId;
	private String orderName;
	private String customId;
	private String modelIn;
	private String modelOut;
	private Integer num;
	private Integer boxNum;
	private String noBegin;
	private String noEnd;
	private String addrBegin;
	private String addrEnd;
	private String meterBegin;
	private String meterEnd;
	private Timestamp dateBalance;
	private String seal;
	private float meter;
	private String barcode;
	private String ultrasonic;
	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getModelIn() {
		return modelIn;
	}

	public void setModelIn(String modelIn) {
		this.modelIn = modelIn;
	}

	public String getModelOut() {
		return modelOut;
	}

	public void setModelOut(String modelOut) {
		this.modelOut = modelOut;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getBoxNum() {
		return boxNum;
	}

	public void setBoxNum(Integer boxNum) {
		this.boxNum = boxNum;
	}

	public String getNoBegin() {
		return noBegin;
	}

	public void setNoBegin(String noBegin) {
		this.noBegin = noBegin;
	}

	public String getNoEnd() {
		return noEnd;
	}

	public void setNoEnd(String noEnd) {
		this.noEnd = noEnd;
	}

	public String getAddrBegin() {
		return addrBegin;
	}

	public void setAddrBegin(String addrBegin) {
		this.addrBegin = addrBegin;
	}

	public String getAddrEnd() {
		return addrEnd;
	}

	public void setAddrEnd(String addrEnd) {
		this.addrEnd = addrEnd;
	}

	public String getMeterBegin() {
		return meterBegin;
	}

	public void setMeterBegin(String meterBegin) {
		this.meterBegin = meterBegin;
	}

	public String getMeterEnd() {
		return meterEnd;
	}

	public void setMeterEnd(String meterEnd) {
		this.meterEnd = meterEnd;
	}

	public Timestamp getDateBalance() {
		return dateBalance;
	}

	public void setDateBalance(Timestamp dateBalance) {
		this.dateBalance = dateBalance;
	}

	public String getSeal() {
		return seal;
	}

	public void setSeal(String seal) {
		this.seal = seal;
	}

	public float getMeter() {
		return meter;
	}

	public void setMeter(float meter) {
		this.meter = meter;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getUltrasonic() {
		return ultrasonic;
	}

	public void setUltrasonic(String ultrasonic) {
		this.ultrasonic = ultrasonic;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getProgramPwd() {
		return programPwd;
	}

	public void setProgramPwd(String programPwd) {
		this.programPwd = programPwd;
	}

	public String getControlPwd() {
		return controlPwd;
	}

	public void setControlPwd(String controlPwd) {
		this.controlPwd = controlPwd;
	}

	public String getMeterSchemaId() {
		return meterSchemaId;
	}

	public void setMeterSchemaId(String meterSchemaId) {
		this.meterSchemaId = meterSchemaId;
	}

	public String getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(String offerDate) {
		this.offerDate = offerDate;
	}

	public String getFromDept() {
		return fromDept;
	}

	public void setFromDept(String fromDept) {
		this.fromDept = fromDept;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getModTime() {
		return modTime;
	}

	public void setModTime(Timestamp modTime) {
		this.modTime = modTime;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	private Integer pulse;
	private String accuracy;
	private String programPwd;
	private String controlPwd;
	private String meterSchemaId;
	private String schemaId;
	private String remark;
	private String marketId;
	private String orderDate;
	private String offerDate;
	private String fromDept;
	private Integer orderStatus;
	private Timestamp modTime;
	private String oid;
	public Order() {

	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
}
