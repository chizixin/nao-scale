package com.nao.scale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nao.scale.baidu.ueditor.ActionEnter;
import javax.servlet.http.HttpServletRequest;


@RestController
public class UeditorController {

	@RequestMapping("/")
	public String index(){
		return "ueditor";
	}

	@Autowired
	private ActionEnter actionEnter;

	@RequestMapping("/ueditor/exec")
	public String exe(HttpServletRequest request){
		return actionEnter.exec(request);
	}

}