package com.yuanqi.packinglines.inter;

import java.util.List;

import com.yuanqi.packinglines.entity.line.Line;

/**
 * 线体数据库操作接口
 * @author lixiaogang
 *
 */
public interface LineOperation {
public List<Line> selectPackLineInfo(String roomId);//按车间ID查询线体信息
}
