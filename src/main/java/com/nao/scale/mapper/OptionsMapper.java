package com.nao.scale.mapper;

import com.nao.scale.pojo.Options;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface OptionsMapper extends BaseMapper<Options> {

	List<Options> getOptions(Integer id2);

	void deleteoptions(Integer id);

	List<Options> getOption(Integer id1);


	Integer updatebyTopicID(Options options);

	Integer updateByTopicID(Options options);
 
	void delete(Integer id);

	List<Options> getOptionsList(Integer id2);

	List seleimg(Integer integer);   

	void insertOptions(Options options);

	Options selectByPro(String[] split);

	List<Options> getOptionsLi(Integer id3);

	String selectOptList(@Param("id")Integer id, @Param("integer")Integer integer);
	


	


}