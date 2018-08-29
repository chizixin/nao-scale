package com.nao.scale.service;

import com.nao.scale.pojo.ScaleAttribute;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface ScaleAttributeService extends IService<ScaleAttribute> {

	int DeleteAttr(Integer id);

	List loadScaleAttr(Integer scaleId);

	//查询属性列表
	List<ScaleAttribute> getAttrbuteList(Integer scaleId);

	List loadAttr(Integer scaleId);

	int insertAttr(ScaleAttribute scaleAttribute);

	List loadscore(Integer id);

	int UpdateAttr(String score);

	List getxmlList(Integer id);

	


}
