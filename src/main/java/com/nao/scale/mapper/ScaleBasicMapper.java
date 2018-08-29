package com.nao.scale.mapper;

import com.nao.scale.pojo.ScaleBasic;
import com.nao.scale.pojo.ScaleTopic;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface ScaleBasicMapper extends BaseMapper<ScaleBasic> {

	List selectListByID(Integer id);

	List selectScale();

	List getScale(Integer id);

	List<ScaleTopic> getList();

	int insertScaleBasic(ScaleBasic scaleBasic);

	ScaleBasic getScaleList(Integer id);

	ScaleBasic selectByXml(Integer scaleId);

	List selectScaleBasicList();

	ScaleBasic getScalename(Integer scaleId);


}