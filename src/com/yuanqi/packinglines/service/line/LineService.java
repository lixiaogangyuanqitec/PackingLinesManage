package com.yuanqi.packinglines.service.line;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yuanqi.packinglines.entity.line.Line;
import com.yuanqi.packinglines.inter.LineOperation;
import com.yuanqi.packinglines.mybatis.MyBatisUtil;
/***
 * 处理线体的业务逻辑类
 * @author lixiaogang
 *
 */
public class LineService {
	
	private SqlSession session=MyBatisUtil.getSqlSession();
	private LineOperation lineOperation = session.getMapper(LineOperation.class);
	
	/**
	 * 按车间ID查询线体ID
	 * @author lixiaogang
	 * @return 线体ID的数组
	 */
	public String[] getDataLine(){
		List<Line> list_line=lineOperation.selectPackLineInfo("06");
		String[] line=new String[list_line.size()];
		for(int i=0;i<list_line.size();i++){
			line[i]=list_line.get(i).getThreadId();
		}
		return line;
	}
	
}
