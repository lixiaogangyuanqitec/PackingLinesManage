package com.yuanqi.packinglines.service.task;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import com.yuanqi.packinglines.entity.task.Task;
import com.yuanqi.packinglines.inter.TaskOperation;
import com.yuanqi.packinglines.mybatis.MyBatisUtil;
/***
 * ���������ҵ���߼���
 * @author lixiaogang
 *
 */
public class TaskService {
	
	private SqlSession session=MyBatisUtil.getSqlSession();
	private TaskOperation taskOperation = session.getMapper(TaskOperation.class);
	
	/**
	 * ������ID��ѯ������Ϣ
	 * @author lixiaogang
	 * @param table
	 * @param orderId
	 */
	public void getDataTaskByOrderId(Table table,String orderId){
		List<Task> task=taskOperation.selectTaskByOrderId(orderId);
		for(int i=0;i<task.size();i++){
			TableItem item1_1 = new TableItem(table, SWT.NONE);
			String taskStatus="δ���";
			if(task.get(i).getTaskStatus().equals("1")){
				taskStatus="�����";
			}
			item1_1.setText(new String[] { ""+task.get(i).getTaskId()+"",""+task.get(i).getTaskName()+"",""+task.get(i).getNum()+"",""+taskStatus+"",""+task.get(i).getMaterialId()+""});
		}
	}
	
	
}
