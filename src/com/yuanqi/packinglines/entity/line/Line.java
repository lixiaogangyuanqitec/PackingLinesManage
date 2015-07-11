package com.yuanqi.packinglines.entity.line;

/***
 * 线体实体类
 * 
 * @author lixiaogang
 *
 */
public class Line {
	private String roomId;
	private String threadId;
	private String threadName;

	public Line() {

	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	
}
