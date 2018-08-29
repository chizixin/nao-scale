package com.nao.scale.service;

import com.nao.scale.pojo.Rinformation;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface RinformationService extends IService<Rinformation> {

	int insertRinformation(int id);

	Rinformation selectByscale(Integer id);

	int updateRinformation(Rinformation rinformation);
	
}
