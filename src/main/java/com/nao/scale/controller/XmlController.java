package com.nao.scale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nao.scale.service.RinformationService;
import com.nao.scale.service.ScaleAttributeService;
import com.nao.scale.service.ScaleBasicService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/xml")
public class XmlController {
	
	@Autowired
	private ScaleAttributeService scaleAttributeService;
	
	@ApiOperation(value = "基本信息--查看所填写的基本信息", notes = "查询基本信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/loadScaleBasic", method = RequestMethod.POST)
	@ResponseBody
	public List getscaleList(Integer id ) {
		List list = scaleAttributeService.getxmlList(id);
		return list;
	}

	
}
