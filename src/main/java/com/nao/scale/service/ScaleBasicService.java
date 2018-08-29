package com.nao.scale.service;

import com.nao.scale.pojo.ScaleBasic;
import com.nao.scale.pojo.ScaleTopic;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.service.IService;
import com.fasterxml.jackson.core.JsonParser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface ScaleBasicService extends IService<ScaleBasic> {

	List getscaleList(Integer id);

	int insertScaleBasic(ScaleBasic scaleBasic);

	int updateScaleBasic(ScaleBasic scaleBasic);

	List selectScale();

	List<ScaleTopic> getList();

	List getScaleTopicList(Integer id);

	List getScaleTopicL(Integer id);

	Integer uploadPicture(MultipartFile uploadFile);

	ScaleBasic getScaleTopicOptionsList(ScaleBasic scaleBasic);

	String uploadJson(MultipartFile uploadFile);

	List selectScaleBasic(ScaleBasic scaleBasic);

	int delScaleBasic(Integer id);

	int getScale(ScaleBasic scaleBasic);


}
