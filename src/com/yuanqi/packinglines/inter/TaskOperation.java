package com.yuanqi.packinglines.inter;

import java.util.List;

import com.yuanqi.packinglines.entity.task.Task;
/**
 * �������ݿ�����ӿ�
 * @author lixiaogang
 *
 */
public interface TaskOperation {
	public List<Task> selectTaskByOrderId(String orderId);// ������ID��ѯ��Ӧ������
}
