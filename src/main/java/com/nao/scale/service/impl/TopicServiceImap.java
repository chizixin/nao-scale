package com.nao.scale.service.impl;


import com.nao.scale.pojo.Options;
import com.nao.scale.pojo.ScaleTA;
import com.nao.scale.pojo.Topic;
import com.nao.scale.service.TopicService;
import com.nao.scale.utils.JsonUtils;
import com.nao.scale.mapper.OptionsMapper;
import com.nao.scale.mapper.ScaleTAMapper;
import com.nao.scale.mapper.TopicMapper;
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
public class TopicServiceImap extends ServiceImpl<TopicMapper, Topic> implements TopicService {
	
	@Autowired
	private TopicMapper topicMapper;
	@Autowired
	private OptionsMapper optionsMapper;
	@Autowired
	private ScaleTAMapper scaleTAMapper;
	
	
	@Override
	public Integer selectbrak(Integer id) {
		return topicMapper.selectBark(id);
	}
	@Override
	public Integer selectupbrak(Integer bark) {
		return topicMapper.selectupbrak(bark);
	}
	@Override
	public Integer updateMove(Integer bark2,Integer bark) {
		return topicMapper.updateMove(bark2,bark);
	}
	@Override
	public int update(Integer id,Integer bark2) {
		return topicMapper.update(id,bark2);
	}


	@Override
	public Integer selectbrakdown(Integer id) {
		return topicMapper.selectbrakdown(id);
	}
	@Override
	public Integer selectdownbrak(Integer bark) {
		return topicMapper.selectdownbrak(bark);
	}
	@Override
	public Integer updateDown(Integer bark2,Integer bark) {
		return topicMapper.updateDown(bark2,bark);
	}
	@Override
	public int updateD(Integer id,Integer bark2) {
		return topicMapper.updateD(id,bark2);
	}


	@Override
	public int DeleteTopic(Integer id) {
		optionsMapper.deleteoptions(id);
		scaleTAMapper.delete(id);
		return topicMapper.deleteById(id);
	}


	@Override
	public List selectId(Integer id) {
		List<Topic> list = topicMapper.getScale(id);
		for(int i = 0 ; i < list.size() ; i++) {
			Topic topic = list.get(i);
			Integer id1 = topic.getId();
			List<Options> list1 = optionsMapper.getOption(id1);
			topic.setOption(list1);
		}
		return list;
	}
	
	
	@Override
	public int insertTopic(Topic topic) {
		 topicMapper.insertTopic(topic);
		 Integer id = topic.getId();
		 //System.out.println(id);
		 topicMapper.insertbark(id);
		//添加属性
		 String ta = topic.getTa();
		 ScaleTA scaleTA = new ScaleTA();
		 if(topic.getTa() != null && !"".equals(topic.getTa())){
			 String[] split = ta.split(",");
			 for (int i = 0; i < split.length; i++) {
				   scaleTA.setTid(id);
				   scaleTA.setAid(Integer.valueOf(split[i]));
				   scaleTAMapper.insert(scaleTA);
				  }
		 }else{
			 scaleTA.setTid(id);
			 scaleTAMapper.insert(scaleTA);
		 }
		 //添加选项
		 String ttname = topic.getTtname();     
		String text = "text";
		if(ttname.equals(text)){
			 Options options = new Options();
			 options.setTopicId(id);
			 optionsMapper.insert(options);
	  }else{
		 //选项转换list,循环添加
		 List<Options> list = JsonUtils.jsonToList(topic.getOptions(), Options.class);
			 for (Options options : list) {
				 options.setTopicId(id);
				 optionsMapper.insertAllColumn(options);
			 }
	 }
		 return 0;
   }
	
	
	@Override 
	public int updateTopic(Topic topic) {
		 topicMapper.updateById(topic);    
		 //String topicname = topic.getTopicname(); //取出题目id
		 Integer id = topic.getId();      
		//添加属性
		 String ta = topic.getTa();
		 ScaleTA scaleTA = new ScaleTA();
		 if(topic.getTa() != null && !"".equals(topic.getTa())){
			 String[] split = ta.split(",");
			 scaleTAMapper.delete(id);
			 for (int i = 0; i < split.length; i++) {
				   scaleTA.setTid(id);
				   scaleTA.setAid(Integer.valueOf(split[i]));
				   scaleTAMapper.insert(scaleTA);
				 }                                  
		 }else{
			 scaleTA.setTid(id);
			 scaleTAMapper.insert(scaleTA);
		 }
		 //操作选项
		 String ttname = topic.getTtname();
		 String text = "text";
		if(ttname.equals(text)){
			 optionsMapper.delete(id);
			 Options options = new Options();
			 options.setTopicId(id);
			 optionsMapper.insert(options);
		}else{
			optionsMapper.delete(id);
			List<Options> list = JsonUtils.jsonToList(topic.getOptions(), Options.class);
			 for (Options options : list) {
				 options.setTopicId(id);
				 optionsMapper.insert(options);
			 }
	 }	
		return 0;
}
	
	@Override
	public List selectImg(Integer scaleId) {
		List<Integer> list = topicMapper.selectbyScaleID(scaleId);
		List<Integer> list2 = topicMapper.selectID(scaleId);
		for (Integer integer : list2) {
			List list3 = optionsMapper.seleimg(integer);
			list.addAll(list3);
		}
		return list;
	}
	
	
	
}
