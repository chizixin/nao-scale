package com.nao.scale.controller;


import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.nao.scale.pojo.ScaleBasic;
import com.nao.scale.service.RinformationService;
import com.nao.scale.service.ScaleAttributeService;
import com.nao.scale.service.ScaleBasicService;

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
@RequestMapping("/scaleBasic")
public class ScaleBasicController {
		
	@Autowired
	private ScaleBasicService scaleBasicService;
	@Autowired
	private ScaleAttributeService scaleAttributeService;
	@Autowired
	private RinformationService RinformationServiceService; 

	
	@ApiOperation(value = "基本信息--查看所填写的基本信息", notes = "查询基本信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/loadScaleBasic", method = RequestMethod.POST)
	@ResponseBody
	public List getscaleList(Integer id ) {
		List list = scaleBasicService.getscaleList(id);
		return list;
	}
	
	@ApiOperation(value = "基本信息--添加基本信息", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/insertScaleBasic", method = RequestMethod.POST)
	@ResponseBody
	public int insertScale(ScaleBasic scaleBasic){ 
		int id = scaleBasicService.insertScaleBasic(scaleBasic);
		RinformationServiceService.insertRinformation(id);
		return id;
	}
	
	@ApiOperation(value = "基本信息--修改基本信息", notes = "修改", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/updateScaleBasic", method = RequestMethod.POST)
	@ResponseBody 
	public Boolean updateScale(ScaleBasic scaleBasic){
		int i = scaleBasicService.updateScaleBasic(scaleBasic);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@ApiOperation(value = "基本信息--删除", notes = "删除", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/delScaleBasic", method = RequestMethod.POST)
	@ResponseBody 
	public Boolean delScaleBasic(Integer id){
		int i = scaleBasicService.delScaleBasic(id);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	@ApiOperation(value = "添加题目--查询大列表", notes = "管理查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/selectTopic", method = RequestMethod.POST)
	@ResponseBody 
	public List selectTopic(Integer id) {
		 List list = scaleBasicService.getScaleTopicList(id);
 		 return list;  
    }
	
	
	
	@ApiOperation(value = "答题--答题初始页面", notes = "答题查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/selectBasic", method = RequestMethod.POST) 
	@ResponseBody 
	public ScaleBasic selectBasic(ScaleBasic scaleBasic) {
		ScaleBasic ScaleBasic = scaleBasicService.getScaleTopicOptionsList(scaleBasic);
		 return ScaleBasic;  
    }
	
	@ApiOperation(value = "添加题目--答题", notes = "管理查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/selectT", method = RequestMethod.POST)
	@ResponseBody    
	public List selectT(Integer id) { 
		 List list = scaleBasicService.getScaleTopicL(id);
		 return list;  
    }
	 
	@ApiOperation(value = "量表导入--导入", notes = "导入", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/guideInto", method = RequestMethod.POST)
	@ResponseBody
	public Integer pictureUpload(MultipartFile uploadFile) {
		Integer id = scaleBasicService.uploadPicture(uploadFile);
		//为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		//String json = JsonUtils.objectToJson(result);
		System.out.println(id);
		return id;
	}
	@ApiOperation(value = "量表list", notes = "管理查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/selectScaleBasic", method = RequestMethod.POST)
	@ResponseBody    
	public List selectScaleBasic(ScaleBasic scaleBasic) { 
		 List list = scaleBasicService.selectScaleBasic(scaleBasic);
		 System.out.println(list);
		 return list;  
    }
	
	@ApiOperation(value = "测评XML--导入测评", notes = "管理查询", httpMethod = "POST", produces = MediaType.APPLICATION_XML_VALUE)
	@RequestMapping(value = "/scaleXML", method = RequestMethod.POST)
	@ResponseBody 
	public boolean scaleXML(ScaleBasic scaleBasic) {
		 int i = scaleBasicService.getScale(scaleBasic);
			if(i>0){
				return true;
			}else{
				return false;
			}
    }
	
}
