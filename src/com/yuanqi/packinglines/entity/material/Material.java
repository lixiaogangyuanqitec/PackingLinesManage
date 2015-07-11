package com.yuanqi.packinglines.entity.material;

import java.sql.Timestamp;

/***
 * 产品实体类
 * 
 * @author lixiaogang
 *
 */
public class Material {
	private String materialId;
	private String standards;
	private String volt;
	private String curr;
	private String mName;
	private Integer mKind;
	private Integer mStatus;
	private String modelIn;
	private String pulse;
	private String precision;
	private Timestamp modTime;
	private String oid;
	private Integer mFlowId;
	public Integer getmKind() {
		return mKind;
	}
	public void setmKind(Integer mKind) {
		this.mKind = mKind;
	}
	public Integer getmStatus() {
		return mStatus;
	}
	public void setmStatus(Integer mStatus) {
		this.mStatus = mStatus;
	}
	
	public String getModelIn() {
		return modelIn;
	}
	public void setModelIn(String modelIn) {
		this.modelIn = modelIn;
	}
	public String getPulse() {
		return pulse;
	}
	public void setPulse(String pulse) {
		this.pulse = pulse;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
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
	public Integer getmFlowId() {
		return mFlowId;
	}
	public void setmFlowId(Integer mFlowId) {
		this.mFlowId = mFlowId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getStandards() {
		return standards;
	}
	public void setStandards(String standards) {
		this.standards = standards;
	}
	public String getVolt() {
		return volt;
	}
	public void setVolt(String volt) {
		this.volt = volt;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public Material() {

	}

	

	
}
