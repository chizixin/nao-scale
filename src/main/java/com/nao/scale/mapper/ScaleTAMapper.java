package com.nao.scale.mapper;

import com.nao.scale.pojo.ScaleTA;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-09-10
 */
public interface ScaleTAMapper extends BaseMapper<ScaleTA> {

	List<ScaleTA> getScaleTA(Integer id1);

	void delete(Integer id);

	List<ScaleTA> getScaleta(Integer id2);

	List selectAttr(Integer topicId);



}