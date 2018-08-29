package com.nao.scale.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.nao.scale.service.PictureService;
import com.nao.scale.utils.JsonUtils;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/scalePic")
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	@ApiOperation(value = "报告信息--添加得分说明", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/pic/upload", method = RequestMethod.POST)
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map result = pictureService.uploadPicture(uploadFile);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		String json = JsonUtils.objectToJson(result);
		return json;
	}
	
}  