package com.nao.scale.mapper;

import com.nao.scale.param.TopicOptions;
import com.nao.scale.pojo.Topic;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface TopicMapper extends BaseMapper<Topic> {

	

	Integer selectBark(Integer id);

	Integer selectupbrak(Integer bark);

	
	Integer updateMove(@Param("bark2")Integer bark2, @Param("bark")Integer bark);

	int update(@Param("id")Integer id, @Param("bark2")Integer bark2);

	Integer selectbrakdown(Integer id);

	Integer selectdownbrak(Integer bark);

	Integer updateDown(@Param("bark2")Integer bark2, @Param("bark")Integer bark);

	int updateD(@Param("id")Integer id,@Param("bark2") Integer bark2);

	List<Topic> getTopic(Integer id1);

	int DeleteTopic(Integer id);

	List<Topic> getScale(Integer id);

	int insertTopic(Topic topic);

	Integer loadTopicID(String topicname);

	void insertbark(Integer id);

	List<Topic> getTopicPro(Pagination page, @Param("ew") Wrapper<Topic> wrapper);

	List<Topic> getTopicList(Integer id);

	List selectCount(Integer scaleId);

	List selectbyScaleID(Integer scaleId);

	List selectID(Integer scaleId);

	void updateById(TopicOptions topic);

	Topic getTopList(Integer id);

	Topic selectTop(Integer id3);

	List<Topic> getTopicBark(Integer id);

	List setectTopicName(Integer scaleId);

	List getattr(Integer id2);


	


}