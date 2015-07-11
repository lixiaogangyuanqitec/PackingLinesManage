package com.yuanqi.packinglines.service.material;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yuanqi.packinglines.entity.material.Material;
import com.yuanqi.packinglines.mybatis.MyBatisUtil;
/***
 * �����Ʒ��ҵ���߼���
 * @author lixiaogang
 *
 */
public class MaterialService {
	
	private SqlSession session=MyBatisUtil.getSqlSession();
	private com.yuanqi.packinglines.inter.MaterialOperation MaterialOperation = session.getMapper(com.yuanqi.packinglines.inter.MaterialOperation.class);
	
	/**
	 * ��materialID��ѯmaterial��Ϣ
	 * @author lixiaogang
	 * @return materialʵ��
	 * @param orderId
	 */
	public Material getDataTaskByOrderId(String materialId){
		List<Material> material=MaterialOperation.selectMaterialInfoById(materialId);
		return material.get(0);
	}
	
	
}
