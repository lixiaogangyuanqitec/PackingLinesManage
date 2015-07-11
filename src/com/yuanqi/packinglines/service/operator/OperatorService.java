package com.yuanqi.packinglines.service.operator;

import org.apache.ibatis.session.SqlSession;
import com.yuanqi.packinglines.inter.OperatorOperation;
import com.yuanqi.packinglines.mybatis.MyBatisUtil;

/***
 * 用户的业务逻辑类
 * 
 * @author lixiaogang
 *
 */
public class OperatorService {
	/***
	 * 登录验证
	 * @param username
	 * @param password
	 * @return 0失败，否则成功
	 * @throws InterruptedException 
	 */
	public Integer loginValidate(String username, String password){
		SqlSession session = MyBatisUtil.getSqlSession();
		OperatorOperation operatorOperation = session.getMapper(OperatorOperation.class);
		return operatorOperation.selectOperatorLoginInfo(username,password);
	}

}
