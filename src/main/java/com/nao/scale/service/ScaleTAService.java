package com.nao.scale.service;

import com.nao.scale.pojo.ScaleTA;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2017-09-10
 */
public interface ScaleTAService extends IService<ScaleTA> {

	int updateTopicAttr(ScaleTA scaleTA);

	int insertTopicAttr(ScaleTA scaleTA);
	
}
