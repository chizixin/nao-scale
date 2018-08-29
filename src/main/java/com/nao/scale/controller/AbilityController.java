package com.nao.scale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nao.scale.service.AbilityService;

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
@RequestMapping("/ability")
public class AbilityController {
	
	@Autowired
	private AbilityService abilityService;
	
	@ApiOperation(value = "基本信息--认知分类", notes = "认知分类", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/loadAbility", method = RequestMethod.POST)
	@ResponseBody
	public List getAttribute( ) {
		List list = abilityService.loadAbility();
		return list;
	}
}
