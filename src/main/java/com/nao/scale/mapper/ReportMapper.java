package com.nao.scale.mapper;

import com.nao.scale.pojo.Report;

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
public interface ReportMapper extends BaseMapper<Report> {

	int selectZong(@Param("scaleId")Integer scaleId, @Param("userId")Integer userId);
}