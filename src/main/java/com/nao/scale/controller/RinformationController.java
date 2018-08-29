package com.nao.scale.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nao.scale.pojo.Rinformation;
import com.nao.scale.service.RinformationService;

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
@RequestMapping("/rinformation")
public class RinformationController {
	
	@Autowired
	private RinformationService rinformationService;
	
	
	@ApiOperation(value = "报告信息--回显 ", notes = "回显", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/selectByscale", method = RequestMethod.POST)
	@ResponseBody
	public Rinformation selectTopic(Integer scaleId) {
		 Rinformation  rinformation = rinformationService.selectByscale(scaleId);
		return rinformation;  
   }
	@ApiOperation(value = "报告信息--修改", notes = "修改", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/updateRinformation", method = RequestMethod.POST)
	@ResponseBody
	public boolean UpTopic(Rinformation rinformation){
		int i = rinformationService.updateRinformation(rinformation);
		if(i>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	
}
