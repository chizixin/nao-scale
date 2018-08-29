package com.nao.scale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.nao.scale.service.ScaleBasicService;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/aaa")
public class Conversion {
	
	@Autowired
	private ScaleBasicService scaleBasicService;
	
	@ApiOperation(value = "量表导入--导入", notes = "导入", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/bbb", method = RequestMethod.POST)
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		String id = scaleBasicService.uploadJson(uploadFile);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		//String json = JsonUtils.objectToJson(result);
		System.out.println(id);
		return id;
	}

}
