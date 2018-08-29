package com.nao.scale.mapper;

import com.nao.scale.pojo.Rinformation;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface RinformationMapper extends BaseMapper<Rinformation> {


	Rinformation selectRinformation(Integer scaleId);

	int updateRinformation(Rinformation rinformation);


	int insertrin(int id);


}