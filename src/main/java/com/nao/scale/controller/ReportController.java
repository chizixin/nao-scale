package com.nao.scale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nao.scale.pojo.Instructions;
import com.nao.scale.pojo.Rep;
import com.nao.scale.pojo.Rinformation;
import com.nao.scale.pojo.User;
import com.nao.scale.service.ReportService;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zx
 * @since 2017-10-24
 */
@Controller
@RequestMapping("/instructions")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	
	@ApiOperation(value = "查询报告--查询", notes = "查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/SelectReport", method = RequestMethod.POST)
	@ResponseBody
	public Rep SelectReport(Instructions instructions){
		Rep rep = new Rep();
		//用户个人信息
		User user = reportService.SelectReport(instructions);
		//属性列表
		List Attr = reportService.getAttrbuteList(instructions);
		//文本记录
		List record  = reportService.getRecordList(instructions);
		//得分报告
		Rinformation rinformation = reportService.getRinformation(instructions); 
		//得分
		int report = reportService.SelectRep(instructions);
		
		rep.setAttr(Attr);
		rep.setUser(user);
		rep.setRinformation(rinformation);
		rep.setContext(record);
		rep.setReport(report);
		return rep;    
	}
	
}
