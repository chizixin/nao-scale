package com.nao.scale.service.impl;

import com.nao.scale.pojo.Options;
import com.nao.scale.pojo.Report;
import com.nao.scale.pojo.ScaleAttribute;
import com.nao.scale.pojo.ScaleBasic;
import com.nao.scale.pojo.Scoring;
import com.nao.scale.pojo.Topic;
import com.nao.scale.service.ScoringService;
import com.nao.scale.vo.Question;
import com.nao.scale.vo.Questionnaire;
import com.nao.scale.vo.Xml;
import com.nao.scale.mapper.OptionsMapper;
import com.nao.scale.mapper.ReportMapper;
import com.nao.scale.mapper.ScaleAttributeMapper;
import com.nao.scale.mapper.ScaleBasicMapper;
import com.nao.scale.mapper.ScaleTAMapper;
import com.nao.scale.mapper.ScoringMapper;
import com.nao.scale.mapper.TopicMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.text.DecimalFormat;
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
public class ScoringServiceImap extends ServiceImpl<ScoringMapper, Scoring> implements ScoringService {
	
	@Autowired
	private ScoringMapper scoringMapper;
	@Autowired
	private OptionsMapper optionsMapper;
	@Autowired
	private TopicMapper topicMapper;
	@Autowired
	private ScaleAttributeMapper scaleAttributeMapper;
	@Autowired
	private ScaleBasicMapper scaleBasicMapper;
	@Autowired
	private ReportMapper reportMapper;
	@Autowired
	private ScaleTAMapper scaleTAMapper;

	@Override
	public Scoring insertScoring(Scoring scoring) {
		String attrId = scoring.getAttrId();
		String optionsId = scoring.getOptionsId();
		Scoring sco = new Scoring();
			//判断attrID属性是否为空
  			if(attrId!= null && !"".equals(attrId)){
				String[] split = attrId.split(",");
					//循环数组
					for (String string : split) {
						scoring.setAttrId(string);
							//判断optionsID得分是否为空
						    if(optionsId!= null && !"".equals(optionsId)){
						        String[] split2 = optionsId.split(",");
						        	//循环optionsID
						          for (String string2 : split2) {
						        	  if(string2!=null && !"".equals(string2)){
						        	  Options score = optionsMapper.selectById(string2);
							          scoring.setOptionsId(string2);
							          scoring.setScore(score.getScore());
							          scoringMapper.insert(scoring);
							          String problem = score.getProblem();
							          Integer topicid = score.getTopicId();
							          sco.setProblem(problem);
							          sco.setTopicid(topicid);
						          }
						        }
						          //fid 
						       String fid =  scaleAttributeMapper.selectFid(string);
						       String z = "0";
						       if(fid!=z){
						    	  scoring.setAttrId(fid);
						    	  if(optionsId!= null && !"".equals(optionsId)){
								        String[] split3 = optionsId.split(",");
								        	//循环optionsID
								          for (String string3 : split3) {
								        	  if(string3!=null && !"".equals(string3)){
								        	  Options score = optionsMapper.selectById(string3);
									          scoring.setOptionsId(string3);
									          scoring.setScore(score.getScore());
									          scoringMapper.insert(scoring);
									          String problem = score.getProblem();
									          Integer topicid = score.getTopicId();
									          sco.setProblem(problem);
									          sco.setTopicid(topicid);
								          }
								        }
						    	  }
						    	  String fid2 =  scaleAttributeMapper.selectFi(fid);
						    	  if(fid!=z){
						    		  scoring.setAttrId(fid2);
							    	  if(optionsId!= null && !"".equals(optionsId)){
									        String[] split3 = optionsId.split(",");
									        	//循环optionsID
									          for (String string3 : split3) {
									        	  if(string3!=null && !"".equals(string3)){
									        	  Options score = optionsMapper.selectById(string3);
										          scoring.setOptionsId(string3);
										          scoring.setScore(score.getScore());
										          scoringMapper.insert(scoring);
										          String problem = score.getProblem();
										          Integer topicid = score.getTopicId();
										          sco.setProblem(problem);
										          sco.setTopicid(topicid);
									          }
									        }
							    	  }
						    	  }
						    	  String fid3 =  scaleAttributeMapper.selectFi(fid2);
						    	  if(fid!=z){
						    		  scoring.setAttrId(fid3);
							    	  if(optionsId!= null && !"".equals(optionsId)){
									        String[] split3 = optionsId.split(",");
									        	//循环optionsID
									          for (String string3 : split3) {
									        	  if(string3!=null && !"".equals(string3)){
									        	  Options score = optionsMapper.selectById(string3);
										          scoring.setOptionsId(string3);
										          scoring.setScore(score.getScore());
										          scoringMapper.insert(scoring);
										          String problem = score.getProblem();
										          Integer topicid = score.getTopicId();
										          sco.setProblem(problem);
										          sco.setTopicid(topicid);
									          }
									        }
							    	  }
						    	  }
						       }   
						    }else{
						    	     scoring.setOptionsId(null);
						    		 scoringMapper.insert(scoring);
						    		 Integer topicId = scoring.getTopicId();
								     sco.setTopicid(topicId);
						    	 }
					}
			}else{
					//判断optionsID得分是否为空
					if(optionsId!= null && !"".equals(optionsId)){
						String[] split2 = optionsId.split(",");
						//循环optionsID
						for (String string2 : split2) {
							  if(string2!=null && !"".equals(string2)){
								  Options score = optionsMapper.selectById(string2);
									scoring.setOptionsId(string2);
									scoring.setAttrId(null);
									scoring.setScore(score.getScore());
									scoringMapper.insert(scoring);
									String problem = score.getProblem();
							          Integer topicid = score.getTopicId();
							          sco.setProblem(problem);
							          sco.setTopicid(topicid);
							  }
						}
					}else{
						scoring.setOptionsId(null);
						scoring.setAttrId(null);
						scoringMapper.insert(scoring);
						Integer topicId = scoring.getTopicId();
				        sco.setTopicid(topicId);
				        return sco; 
					}
			}
			return sco;
			
	}   
	/*
	@Override
	public int deleteScoring(Scoring scoring) {
		Integer userId = scoring.getUserId();
		Integer scaleId = scoring.getScaleId();
		Integer topicId = scoring.getTopicId();
		
		return scoringMapper.deleteScoring(userId,scaleId,topicId);
	}*/

	@Override
	public Xml Submitcount(Scoring scoring) {
		Integer userId = scoring.getUserId();
		Integer scaleId = scoring.getScaleId();
		List<Integer> list = scoringMapper.Submitcount(scoring);
		//去null
		List<Integer> nullArr = new ArrayList<Integer>();  
	    nullArr.add(null);  
	    list.removeAll(nullArr);
	  //去null
	  		List<Integer> zz = new ArrayList<Integer>();  
	  	    nullArr.add(0);  
	  	    list.removeAll(nullArr);
	    //去重复
	     Set<Integer> set = new LinkedHashSet<Integer>();
		 set.addAll(list); 
		 List<Integer> list2 = new ArrayList<Integer>();  
		 list2.addAll(set); 
		 
		 //属性ID -- integer
		for (Integer integer : list2) {
			Integer score = scaleAttributeMapper.selectscore(integer);
			if(score==4){ 
				this.addition(integer,userId,scaleId); 
			}else if(score==1){
				this.averaging(integer,userId,scaleId);
			}else if(score==2){
				ScaleAttribute aAttr =  scaleAttributeMapper.selectMSAB(integer);
				this.standard(integer,userId,scaleId,aAttr);
			} 
		}
		List<Integer> zong = new ArrayList<>();
		List<Integer> list3 = scoringMapper.selectOptionsID(scoring);
		//去null
		  list3.removeAll(nullArr);
		//去重复
		     Set<Integer> set1 = new LinkedHashSet<Integer>();
			 set1.addAll(list3); 
			 List<Integer> list4 = new ArrayList<Integer>();  
			 list4.addAll(set1); 
		for (Integer integer2 : list4) {
			List list5 = scoringMapper.selectS(integer2);
			 Set<Integer> set2 = new LinkedHashSet<Integer>();
			 set2.addAll(list5); 
			 List<Integer> list6 = new ArrayList<Integer>();  
			 list6.addAll(set2); 
			 zong.addAll(list6);
		}
		 int s = 0;
		    for (Integer integer5 : zong) {
		      s+=integer5;
		    }
		    Report  report  = new Report();
			report.setUserId(userId);
			report.setAttrId(0);
			report.setScaleId(scaleId);
 			report.setRinform(s);
			reportMapper.insert(report);
			return null;
	}
	
	
	
	
	     
		//累加attrID -- integer
		public Integer addition(Integer integer,Integer userId,Integer scaleId) {
			List<Integer> addition = new ArrayList<>();
			List<Integer> list = scoringMapper.selectOption(integer);
			Set<Integer> set = new LinkedHashSet<Integer>();
			 set.addAll(list); 
			 List<Integer> list2 = new ArrayList<Integer>();  
			 list2.addAll(set); 
			for (Integer integer2 : list2) {
				List score = scoringMapper.selectScore(integer2);
				Set<Integer> set1 = new LinkedHashSet<Integer>();
				 set1.addAll(score); 
				 
				addition.addAll(set1);
			}
			
			 int s = 0;
			    for (Integer integer1 : addition) {
			      s+=integer1;
			    }
			Report  report  = new Report();
			report.setUserId(userId);
			report.setAttrId(integer);
			report.setScaleId(scaleId);
			report.setRinform(s);
			return reportMapper.insert(report);
		}
		//平均
		public Integer averaging(Integer integer,Integer userId,Integer scaleId) {
 			List<Integer> addition = new ArrayList<>();
			List<Integer> list = scoringMapper.selectOption(integer);
			Set<Integer> set = new LinkedHashSet<Integer>();
			 set.addAll(list); 
			 List<Integer> list2 = new ArrayList<Integer>();  
			 list2.addAll(set); 
			for (Integer integer2 : list2) {
				List score = scoringMapper.selectScore(integer2);
				Set<Integer> set1 = new LinkedHashSet<Integer>();
				 set1.addAll(score); 
				addition.addAll(set1);
			}
			 int s = 0;
			    for (Integer integer1 : addition) {
			      s+=integer1;
			    }
			 int i = list2.size();
			 DecimalFormat df = new DecimalFormat("0.0");
			 float z=s/i;
			 String format = df.format(s/(float)i);
			 double d=Double.valueOf(format).doubleValue();
			Report  report  = new Report();
			report.setUserId(userId);
			report.setAttrId(integer);
			report.setScaleId(scaleId);
			report.setRinform(d);
			return reportMapper.insert(report) ;
		}
		//标准分
		public Integer standard(Integer integer,Integer userId,Integer scaleId, ScaleAttribute aAttr) {
			Integer m = aAttr.getM();
			Integer s = aAttr.getS();
			Integer a = aAttr.getA();
			Integer b = aAttr.getB();
			List<Integer> addition = new ArrayList<>();
			List<Integer> list = scoringMapper.selectOption(integer);
			Set<Integer> set = new LinkedHashSet<Integer>();
			 set.addAll(list); 
			 List<Integer> list2 = new ArrayList<Integer>();  
			 list2.addAll(set); 
			for (Integer integer2 : list2) {
				List score = scoringMapper.selectScore(integer2);
				Set<Integer> set1 = new LinkedHashSet<Integer>();
				 set1.addAll(score); 
				addition.addAll(set1);
			}
			 int i = 0;
			    for (Integer integer1 : addition) {
			      i+=integer1;
			    }
			    DecimalFormat df = new DecimalFormat("0.0");
				 String format = df.format((float)a*(i-m)/s+b);
				 double d=Double.valueOf(format).doubleValue();
			Report  report  = new Report();
			report.setUserId(userId);
			report.setAttrId(integer);
			report.setScaleId(scaleId);
			report.setRinform(d);
			return reportMapper.insert(report);
		}

		@Override
		public List selectScoring(Scoring scoring) {
			Integer userId = scoring.getUserId();
			Integer scaleId = scoring.getScaleId();
			Integer topicId = scoring.getTopicId();
			List list = scoringMapper.selectScoring(userId,scaleId,topicId);
			 Set<Integer> set1 = new LinkedHashSet<Integer>();
			 set1.addAll(list); 
			 List<Integer> list2= new ArrayList<Integer>();  
			 list2.addAll(set1);
			//查询属性
			 List list3 = scaleTAMapper.selectAttr(topicId);
			 list2.addAll(list3);
			return list2;
		}
	
	
}
     