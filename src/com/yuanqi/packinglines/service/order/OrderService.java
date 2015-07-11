package com.yuanqi.packinglines.service.order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.yuanqi.packinglines.entity.order.Order;
import com.yuanqi.packinglines.inter.OrderOperation;
import com.yuanqi.packinglines.mybatis.MyBatisUtil;
/***
 * ��������ҵ���߼���
 * @author lixiaogang
 *
 */
public class OrderService {
	
	private SqlSession session=MyBatisUtil.getSqlSession();
	private OrderOperation orderOperation = session.getMapper(OrderOperation.class);
	
	/**
	 * ѡ������Ĵ������ʱ����ʼ�������������
	 * @author lixiaogang
	 * @param table
	 */
	public void getDataOrder(Table table){
		List<Order> list_order=orderOperation.selectAllOrderInfo();
		for(int i=0;i<list_order.size();i++){
			TableItem item1_1 = new TableItem(table, SWT.NONE);
			item1_1.setText(new String[] { ""+list_order.get(i).getOrderId()+"",""+list_order.get(i).getOrderName()+""});
		}
	}
	
	/**
	 * ������ID��ѯ������Ϣ
	 * @author lixiaogang
	 * @param table
	 * @param orderId
	 */
	public void getDataOrderByOrderId(Table table,String orderId){
		List<Order> order=orderOperation.selectOrderInfoByOrderId(orderId);
		for(int i=0;i<order.size();i++){
			TableItem item1_1 = new TableItem(table, SWT.NONE);
			item1_1.setText(new String[] { ""+order.get(i).getOrderId()+"",""+order.get(i).getOrderName()+""});
		}
	}
}
