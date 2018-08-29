package com.nao.scale.mapper;

import com.nao.scale.pojo.Computations;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-10-12
 */
public interface ComputationsMapper extends BaseMapper<Computations> {

	List<Computations> selectList();

}