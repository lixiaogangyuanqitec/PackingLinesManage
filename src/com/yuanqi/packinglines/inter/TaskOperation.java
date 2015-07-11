package com.yuanqi.packinglines.inter;

import java.util.List;

import com.yuanqi.packinglines.entity.task.Task;
/**
 * 任务数据库操作接口
 * @author lixiaogang
 *
 */
public interface TaskOperation {
	public List<Task> selectTaskByOrderId(String orderId);// 按订单ID查询对应的任务
}
