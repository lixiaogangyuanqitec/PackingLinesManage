package com.yuanqi.packinglines.service.operator;

import org.apache.ibatis.session.SqlSession;
import com.yuanqi.packinglines.inter.OperatorOperation;
import com.yuanqi.packinglines.mybatis.MyBatisUtil;

/***
 * �û���ҵ���߼���
 * 
 * @author lixiaogang
 *
 */
public class OperatorService {
	/***
	 * ��¼��֤
	 * @param username
	 * @param password
	 * @return 0ʧ�ܣ�����ɹ�
	 * @throws InterruptedException 
	 */
	public Integer loginValidate(String username, String password){
		SqlSession session = MyBatisUtil.getSqlSession();
		OperatorOperation operatorOperation = session.getMapper(OperatorOperation.class);
		return operatorOperation.selectOperatorLoginInfo(username,password);
	}

}
