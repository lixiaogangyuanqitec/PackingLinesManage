package com.yuanqi.packinglines.inter;

import java.util.List;

import com.yuanqi.packinglines.entity.material.Material;

/***
 * 产品数据库操作接口
 * 
 * @author lixiaogang
 *
 */
public interface MaterialOperation {
	public List<Material> selectMaterialInfoById(String materialId);// 按materialid查询material信息
}
