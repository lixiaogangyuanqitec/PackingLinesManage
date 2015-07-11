package com.yuanqi.packinglines.inter;

import java.util.List;

import com.yuanqi.packinglines.entity.order.Order;
/**
 * 订单数据库操作接口
 * @author lixiaogang
 *
 */
public interface OrderOperation {
	public List<Order> selectAllOrderInfo();// 查询全部订单信息

	public List<Order> selectOrderInfoByOrderId(String orderId);// 按订单ID查询订单信息
}
