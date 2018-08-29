package com.nao.scale.mapper;

import com.nao.scale.pojo.Scoring;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-10-10
 */
public interface ScoringMapper extends BaseMapper<Scoring> {

	int deleteScoring(@Param("userId")Integer userId, @Param("scaleId")Integer scaleId, @Param("topicId")Integer topicId);

	//List Submitcount(@Param("userID")Integer userID, @Param("scaleID")Integer scaleID);

	List Submitcount(Scoring scoring);

	List<Scoring> selectByTopicID(@Param("id")Integer id,@Param("userId")Integer userId);

	List selectOption(Integer integer);

	List selectScore(Integer integer2);

	List selectOptionsID(Scoring scoring);

	List selectS(Integer integer2);

	List selectScoring(@Param("userId")Integer userId, @Param("scaleId")Integer scaleId, @Param("topicId")Integer topicId);

	List<Integer> selectScoringList(@Param("userId")Integer userId, @Param("scaleId")Integer scaleId,@Param("id")Integer id);

	List selectOptList(@Param("id")Integer id, @Param("userId")Integer userId, @Param("scaleId")Integer scaleId);

	List selectText(Integer id);

	List<Scoring> selectScoList(@Param("userId")Integer userId, @Param("scaleId")Integer scaleId,@Param("id")Integer id);

	


	


	


}