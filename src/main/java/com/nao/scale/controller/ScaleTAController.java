package com.nao.scale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nao.scale.pojo.ScaleTA;
import com.nao.scale.service.ScaleTAService;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zx
 * @since 2017-09-10
 */
@Controller
@RequestMapping("/scaleTA")
public class ScaleTAController {
	
	@Autowired
	private ScaleTAService scaleTAService;
	
	@ApiOperation(value = "基本信息-编辑属性", notes = "修改", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/updateTopicAttr", method = RequestMethod.POST)
	@ResponseBody
	public boolean updateTopicAttr(ScaleTA scaleTA){
		int i = scaleTAService.updateTopicAttr(scaleTA);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@ApiOperation(value = "基本信息-编辑属性", notes = "修改", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/insertTopicAttr", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertTopicAttr(ScaleTA scaleTA){
		int i = scaleTAService.insertTopicAttr(scaleTA);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
