package com.yuanqi.packinglines.inter;

import java.util.List;

import com.yuanqi.packinglines.entity.material.Material;

/***
 * ��Ʒ���ݿ�����ӿ�
 * 
 * @author lixiaogang
 *
 */
public interface MaterialOperation {
	public List<Material> selectMaterialInfoById(String materialId);// ��materialid��ѯmaterial��Ϣ
}
