package com.yuanqi.packinglines.entity.packflowdetail;

import java.sql.Timestamp;

/***
 * 包装流程明细实体类
 * 
 * @author lixiaogang
 *
 */
public class PackFlowDetail {
	private String meterId;
	private String dataFlag;
	private String orderId;
	private String taskId;
	private Timestamp finish_Date;
	private String threadId;
	private String note;
	private String resultFlag;
	public String getResultFlag() {
		return resultFlag;
	}
	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getDataFlag() {
		return dataFlag;
	}
	public void setDataFlag(String dataFlag) {
		this.dataFlag = dataFlag;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public Timestamp getFinish_Date() {
		return finish_Date;
	}
	public void setFinish_Date(Timestamp finish_Date) {
		this.finish_Date = finish_Date;
	}
	public String getThreadId() {
		return threadId;
	}
	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public PackFlowDetail() {

	}
	
}
