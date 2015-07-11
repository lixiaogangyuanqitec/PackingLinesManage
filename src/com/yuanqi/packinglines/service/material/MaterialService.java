package com.yuanqi.packinglines.service.material;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yuanqi.packinglines.entity.material.Material;
import com.yuanqi.packinglines.mybatis.MyBatisUtil;
/***
 * 处理产品的业务逻辑类
 * @author lixiaogang
 *
 */
public class MaterialService {
	
	private SqlSession session=MyBatisUtil.getSqlSession();
	private com.yuanqi.packinglines.inter.MaterialOperation MaterialOperation = session.getMapper(com.yuanqi.packinglines.inter.MaterialOperation.class);
	
	/**
	 * 按materialID查询material信息
	 * @author lixiaogang
	 * @return material实例
	 * @param orderId
	 */
	public Material getDataTaskByOrderId(String materialId){
		List<Material> material=MaterialOperation.selectMaterialInfoById(materialId);
		return material.get(0);
	}
	
	
}
