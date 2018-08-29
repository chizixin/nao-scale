package com.nao.scale.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nao.scale.pojo.User;
import com.nao.scale.service.UserService;
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
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "个人信息填写--添加", notes = "添加", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	@ResponseBody
	public Integer insertUser(User user){
		int id = userService.insertUser(user);
		return id;
	}
}
