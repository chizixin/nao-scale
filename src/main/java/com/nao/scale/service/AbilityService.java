package com.nao.scale.service;

import com.nao.scale.pojo.Ability;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface AbilityService extends IService<Ability> {

	List loadAbility();
	
}
