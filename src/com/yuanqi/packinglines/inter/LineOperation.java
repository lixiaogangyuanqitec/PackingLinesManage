package com.yuanqi.packinglines.inter;

import java.util.List;

import com.yuanqi.packinglines.entity.line.Line;

/**
 * �������ݿ�����ӿ�
 * @author lixiaogang
 *
 */
public interface LineOperation {
public List<Line> selectPackLineInfo(String roomId);//������ID��ѯ������Ϣ
}
