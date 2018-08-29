package com.nao.scale.service.impl;

import com.nao.scale.pojo.Ability;
import com.nao.scale.service.AbilityService;
import com.nao.scale.mapper.AbilityMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@Service
public class AbilityServiceImap extends ServiceImpl<AbilityMapper, Ability> implements AbilityService {
	
	@Autowired
	private AbilityMapper abilityMapper;

	@Override
	public List loadAbility() {
		return abilityMapper.selectList(new EntityWrapper<Ability>());
	}
	
}
