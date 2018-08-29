package com.nao.scale.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nao.scale.pojo.ScaleAttribute;
import com.nao.scale.service.ScaleAttributeService;
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
@RequestMapping("/scaleAttribute")
public class ScaleAttributeController {
	@Autowired
	private ScaleAttributeService scaleAttributeService;
	
	@ApiOperation(value = "题目属性管理--添加属性", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/insertAttr", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertAttr(ScaleAttribute scaleAttribute){
		int i = scaleAttributeService.insertAttr(scaleAttribute);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@ApiOperation(value = "题目属性管理--列表", notes = "查询基本信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/getscaleAttrList", method = RequestMethod.POST)
	@ResponseBody
	public List<ScaleAttribute> getscaleAttrList(Integer scaleId ) {
		List<ScaleAttribute> list = scaleAttributeService.getAttrbuteList(scaleId);
		return list;
	}
	
	@ApiOperation(value = "题目属性管理--删除", notes = "删除", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/DeleteAttr", method = RequestMethod.POST)
	@ResponseBody
	public Boolean DeleteAttr(Integer id){
		int i = scaleAttributeService.DeleteAttr(id);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@ApiOperation(value = "题目属性管理--添加上级属性回显", notes = "查询小于四级的属性", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/loadScaleAttr", method = RequestMethod.POST)
	@ResponseBody
	public List getscaleList(Integer scaleId) {
		List list = scaleAttributeService.loadScaleAttr(scaleId);
		return list;
	}
	
	@ApiOperation(value = "添加题目--最低级属性查询", notes = "查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/loadAttr", method = RequestMethod.POST)
	@ResponseBody
	public List loadAttr(Integer scaleId) {
		List list = scaleAttributeService.loadAttr(scaleId);
		return list;
	}
	
	@ApiOperation(value = "计分方式管理--修改", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/UpdateAttr", method = RequestMethod.POST)
	@ResponseBody
	public boolean UpdateAttr(String score){
		int i = scaleAttributeService.UpdateAttr(score);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	@ApiOperation(value = "计分方式管理--回显", notes = "查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/loadscore", method = RequestMethod.POST)
	@ResponseBody
	public List loadscore(Integer id) {
		List list = scaleAttributeService.loadscore(id);
		return list;
	}
	
	
}

