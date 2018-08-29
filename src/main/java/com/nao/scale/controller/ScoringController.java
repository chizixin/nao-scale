package com.nao.scale.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nao.scale.pojo.Scoring;
import com.nao.scale.service.ScoringService;
import com.nao.scale.service.TopicService;
import com.nao.scale.vo.Xml;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zx
 * @since 2017-10-24
 */
@Controller
@RequestMapping("/scoring")
public class ScoringController {
	
	@Autowired
	private ScoringService scoringService;
	@Autowired
	private TopicService topicService;
	
	@ApiOperation(value = "答题下一步--添加分数信息", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/insertScoring", method = RequestMethod.POST)
	@ResponseBody
	public Scoring insertScoring(Scoring scoring){
		Scoring i = scoringService.insertScoring(scoring);    
		return i;
	}
	
	@ApiOperation(value = "答题上一步--删除上一题信息", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/selectScoring", method = RequestMethod.POST)
	@ResponseBody
	public List selectScoring(Scoring scoring){
		List list = scoringService.selectScoring(scoring);
		return list;  
	}
	
	
	@ApiOperation(value = "答题--算分数", notes = "算分", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/Submitcount", method = RequestMethod.POST)
	@ResponseBody
	public Xml Submitcount(Scoring scoring ) { 
		Xml list = scoringService.Submitcount(scoring);
		return list;
	}
	
	@ApiOperation(value = "答题-- 编辑回显 ", notes = "回显", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/selectByimg", method = RequestMethod.POST)
	@ResponseBody
	public List selectTopic(Integer scaleId) {
		 List list = topicService.selectImg(scaleId); 
		return list;  
   }
}
