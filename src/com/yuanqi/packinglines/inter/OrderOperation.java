package com.yuanqi.packinglines.inter;

import java.util.List;

import com.yuanqi.packinglines.entity.order.Order;
/**
 * �������ݿ�����ӿ�
 * @author lixiaogang
 *
 */
public interface OrderOperation {
	public List<Order> selectAllOrderInfo();// ��ѯȫ��������Ϣ

	public List<Order> selectOrderInfoByOrderId(String orderId);// ������ID��ѯ������Ϣ
}
