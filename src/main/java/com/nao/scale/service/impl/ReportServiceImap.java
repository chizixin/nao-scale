package com.nao.scale.service.impl;

import com.nao.scale.pojo.Instructions;
import com.nao.scale.pojo.Report;
import com.nao.scale.pojo.Rinformation;
import com.nao.scale.pojo.ScaleAttribute;
import com.nao.scale.pojo.Scoring;
import com.nao.scale.pojo.Topic;
import com.nao.scale.pojo.User;
import com.nao.scale.service.ReportService;
import com.nao.scale.mapper.ReportMapper;
import com.nao.scale.mapper.RinformationMapper;
import com.nao.scale.mapper.ScaleAttributeMapper;
import com.nao.scale.mapper.ScoringMapper;
import com.nao.scale.mapper.TopicMapper;
import com.nao.scale.mapper.UserMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zx
 * @since 2017-10-10
 */
@Service
public class ReportServiceImap extends ServiceImpl<ReportMapper, Report> implements ReportService {
	@Autowired
	private  TopicMapper topicMapper;
	@Autowired
	private  ScoringMapper scoringMapper;
	@Autowired
	private  UserMapper userMapper;
	@Autowired
	private ScaleAttributeMapper scaleAttributeMapper;
	@Autowired
	private RinformationMapper rinformationMapper;
	@Autowired
	private ReportMapper reportMapper;
	
	//用户
	@Override
	public User SelectReport(Instructions instructions) {
		Integer userId = instructions.getUserId(); 
		User user = userMapper.selectUser(userId);
		return user;
	}
	
	//属性
	@Override
	public List getAttrbuteList(Instructions instructions) {
		//quchu	
		Integer scaleId = instructions.getScaleId();
		Integer userId = instructions.getUserId();
		
		List<ScaleAttribute> list = scaleAttributeMapper.selectListScore(scaleId,userId);//查询出所有的父级元素，这是第一级别  
		for(int x = 0 ; x < list.size() ; x++) {
			 ScaleAttribute scaleAttribute = list.get(x);
			}
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				ScaleAttribute attribute = list.get(i);
				Integer id = attribute.getId();
				List<ScaleAttribute> list2 = scaleAttributeMapper.selectListSc(scaleId,id,userId);//查询出所有的父级元素，这是第二级别
				for(int q = 0 ; q < list2.size() ; q++) {
					 ScaleAttribute scaleAttribute = list2.get(q);
					}  
				attribute.setScaleAttribute(list2);//赋值第二级
				if(list2!=null && list2.size()>0){
					for(int j=0;j<list2.size();j++){
						ScaleAttribute attr = list2.get(j);
						Integer id2 = attr.getId();
						 
						List<ScaleAttribute> list3 = scaleAttributeMapper.selectListS(scaleId,id2,userId);//查询出所有的父级元素，这是第三级别
						for(int w = 0 ; w < list3.size() ; w++) {
							 ScaleAttribute scaleAttribute = list3.get(w);
								
							}	
						attr.setScaleAttribute(list3);//赋值第三级 
						if(list3!=null && list3.size()>0){
							for(int m=0;m<list3.size();m++){ 
								ScaleAttribute salaatt = list3.get(m);
								Integer id3 = salaatt.getId();
								List<ScaleAttribute> list4 = scaleAttributeMapper.selectList(scaleId,id3,userId);//查询出所有的父级元素，这是第四级别
								for(int z = 0 ; z < list4.size() ; z++) {
									 ScaleAttribute scaleAttribute = list4.get(z);
									}
								salaatt.setScaleAttribute(list4);
							}
						}
					}
				}
			}
		}
		return list;
	}
	//得分报告
	@Override
	public Rinformation getRinformation(Instructions instructions) {
		Integer scaleId = instructions.getScaleId();
		return rinformationMapper.selectRinformation(scaleId);
	}
	//
	@Override
	public List getRecordList(Instructions instructions) {
		Integer scaleId = instructions.getScaleId();
		Integer userId = instructions.getUserId();
		List<Topic> record = topicMapper.selectCount(scaleId);
		for (Topic topic : record) {
			 Integer id = topic.getId();
			 List<Scoring> list = scoringMapper.selectByTopicID(id,userId);
			 Set<Scoring> set = new LinkedHashSet<Scoring>();
			 set.addAll(list); 
			 ArrayList<Scoring> list2 = new ArrayList<Scoring>();
			 list2.addAll(set); 
			 topic.setOptions(String.valueOf(list2));
		}
		return record;
	}
	//分数
	@Override
	public int SelectRep(Instructions instructions) {
		Integer scaleId = instructions.getScaleId();
		Integer userId = instructions.getUserId();
		int report = reportMapper.selectZong(scaleId,userId);
		
		return report;
	}

}
