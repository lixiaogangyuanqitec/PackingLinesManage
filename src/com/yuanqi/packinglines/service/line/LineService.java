package com.yuanqi.packinglines.service.line;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yuanqi.packinglines.entity.line.Line;
import com.yuanqi.packinglines.inter.LineOperation;
import com.yuanqi.packinglines.mybatis.MyBatisUtil;
/***
 * ���������ҵ���߼���
 * @author lixiaogang
 *
 */
public class LineService {
	
	private SqlSession session=MyBatisUtil.getSqlSession();
	private LineOperation lineOperation = session.getMapper(LineOperation.class);
	
	/**
	 * ������ID��ѯ����ID
	 * @author lixiaogang
	 * @return ����ID������
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
