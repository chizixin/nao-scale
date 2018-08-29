package com.nao.scale.service;

import com.nao.scale.pojo.Topic;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface TopicService extends IService<Topic> {

	Integer selectbrak(Integer id);

	Integer selectupbrak(Integer bark);

	Integer updateMove(Integer bark2, Integer bark);

	int update(Integer id, Integer bark2);

	Integer selectbrakdown(Integer id);

	Integer selectdownbrak(Integer bark);

	Integer updateDown(Integer bark2, Integer bark);

	int updateD(Integer id, Integer bark2);

	int DeleteTopic(Integer id);

	List selectId(Integer id);

	int insertTopic(Topic topic);

	int updateTopic(Topic topic);

	List selectImg(Integer scaleId);

	
}
