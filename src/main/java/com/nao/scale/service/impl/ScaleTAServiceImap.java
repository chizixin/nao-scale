package com.nao.scale.service.impl;

import com.nao.scale.pojo.ScaleTA;
import com.nao.scale.service.ScaleTAService;
import com.nao.scale.mapper.ScaleTAMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zx
 * @since 2017-09-10
 */
@Service
public class ScaleTAServiceImap extends ServiceImpl<ScaleTAMapper, ScaleTA> implements ScaleTAService {
	
	@Autowired
	private ScaleTAMapper ScaleTAMapper;
	
	@Override
	public int updateTopicAttr(ScaleTA scaleTA) {
			String ta = scaleTA.getTa();
			Integer id = scaleTA.getTid();
			if(scaleTA.getTa() != null){
				String[] split = ta.split(",");
				ScaleTAMapper.delete(id);
				for (int i = 0; i < split.length; i++) {
					   scaleTA.setTid(id);
					   scaleTA.setAid(Integer.valueOf(split[i]));
					   ScaleTAMapper.insert(scaleTA);
					  }
				}else{
					 scaleTA.setTid(id);
					 ScaleTAMapper.insert(scaleTA);
				}
		return 0;
	}

	@Override
	public int insertTopicAttr(ScaleTA scaleTA) {
		String ta = scaleTA.getTa();
		Integer id = scaleTA.getTid();
		 if(scaleTA.getTa() != null){
		 String[] split = ta.split(",");
		 for (int i = 0; i < split.length; i++) {
			   scaleTA.setTid(id);
			   scaleTA.setAid(Integer.valueOf(split[i]));
			   ScaleTAMapper.insert(scaleTA);
			  }
		 }else{
			 scaleTA.setTid(id);
			 ScaleTAMapper.insert(scaleTA);
		 }
		
		return 0;
	}
}
