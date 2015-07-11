package com.yuanqi.packinglines.entity.task;

import java.sql.Timestamp;

/***
 * 任务实体类
 * 
 * @author lixiaogang
 *
 */
public class Task {
	private String taskId;
	private String orderId;
	private String taskName;
	private Integer num;
	private String taskStatus;
	private String materialId;
	private String semiMaterialId;
	private String scehmaId;
	private String noBegin;
	private String noEnd;
	private String addrBegin;
	private String addrEnd;
	private Integer boxIdBegin;
	private Integer boxCapacity;
	private String modelOut;
	private String barcode;
	private String meterSchemaId;
	private Integer isNeedCheck;
	private Timestamp modTime;
	private String oid;
	private String checkSchemaId;
	public String getSemiMaterialId() {
		return semiMaterialId;
	}
	public void setSemiMaterialId(String semiMaterialId) {
		this.semiMaterialId = semiMaterialId;
	}
	public String getScehmaId() {
		return scehmaId;
	}
	public void setScehmaId(String scehmaId) {
		this.scehmaId = scehmaId;
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
	public Integer getBoxIdBegin() {
		return boxIdBegin;
	}
	public void setBoxIdBegin(Integer boxIdBegin) {
		this.boxIdBegin = boxIdBegin;
	}
	public Integer getBoxCapacity() {
		return boxCapacity;
	}
	public void setBoxCapacity(Integer boxCapacity) {
		this.boxCapacity = boxCapacity;
	}
	public String getModelOut() {
		return modelOut;
	}
	public void setModelOut(String modelOut) {
		this.modelOut = modelOut;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getMeterSchemaId() {
		return meterSchemaId;
	}
	public void setMeterSchemaId(String meterSchemaId) {
		this.meterSchemaId = meterSchemaId;
	}
	public Integer getIsNeedCheck() {
		return isNeedCheck;
	}
	public void setIsNeedCheck(Integer isNeedCheck) {
		this.isNeedCheck = isNeedCheck;
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
	public String getCheckSchemaId() {
		return checkSchemaId;
	}
	public void setCheckSchemaId(String checkSchemaId) {
		this.checkSchemaId = checkSchemaId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public Task() {

	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
	
	
	

	
}
