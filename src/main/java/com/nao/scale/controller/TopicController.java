package com.nao.scale.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nao.scale.pojo.Topic;
import com.nao.scale.service.TopicService;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@Controller
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	private TopicService topicServer;
	
	@ApiOperation(value = "题目管理--上移题目", notes = "上移", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/UpTopic", method = RequestMethod.POST)
	@ResponseBody
	public boolean UpTopic(Integer id){
		//查询当前id的bark
		Integer bark = topicServer.selectbrak(id);
		Integer bark2 = topicServer.selectupbrak(bark);
		topicServer.updateMove(bark2,bark);
		int i = topicServer.update(id,bark2);
		if(i>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	@ApiOperation(value = "题目管理--下移题目", notes = "下移", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/DownTopic", method = RequestMethod.POST)
	@ResponseBody
	public Boolean DownTopic(Integer id){
		Integer bark = topicServer.selectbrakdown(id);
		Integer bark2 = topicServer.selectdownbrak(bark);
		topicServer.updateDown(bark2,bark);
		int i = topicServer.updateD(id,bark2);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@ApiOperation(value = "题目管理--删除", notes = "", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/DeleteTopic", method = RequestMethod.POST)
	@ResponseBody
	public Boolean DeleteTopic(Integer id){
		int i = topicServer.DeleteTopic(id);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@ApiOperation(value = "题目管理-- 编辑回显 ", notes = "回显", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/selectById", method = RequestMethod.POST)
	@ResponseBody
	public List selectTopic(Integer id) {
		 List list = topicServer.selectId(id);
		return list;  
   }
	

	
	@ApiOperation(value = "基本信息--添加基本信息", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/insertTopic", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertTopic(Topic topic){
		int i = topicServer.insertTopic(topic);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@ApiOperation(value = "基本信息-编辑信息", notes = "修改", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/updateTopic.json", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateTopic(Topic topic){
		int i = topicServer.updateTopic(topic);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
}
