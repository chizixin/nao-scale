package com.nao.scale.service.impl;

import com.nao.scale.pojo.Rinformation;
import com.nao.scale.service.RinformationService;
import com.nao.scale.mapper.RinformationMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


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
public class RinformationServiceImap extends ServiceImpl<RinformationMapper, Rinformation> implements RinformationService {
	
	@Autowired
	private RinformationMapper RinformationMapper;

	@Override
	public int insertRinformation(int id) {
		return RinformationMapper.insertrin(id);
	}

	@Override
	public Rinformation selectByscale(Integer scaleId) {
		return RinformationMapper.selectRinformation(scaleId);
	}

	@Override
	public int updateRinformation(Rinformation rinformation) {
		return RinformationMapper.updateRinformation(rinformation);
	}
	
}
