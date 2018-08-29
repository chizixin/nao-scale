package com.nao.scale.service;

import com.nao.scale.pojo.Instructions;
import com.nao.scale.pojo.Report;
import com.nao.scale.pojo.Rinformation;
import com.nao.scale.pojo.User;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2017-10-10
 */
public interface ReportService extends IService<Report> {

	User SelectReport(Instructions instructions);

	List getAttrbuteList(Instructions instructions);

	List getRecordList(Instructions instructions);

	Rinformation getRinformation(Instructions instructions);

	int SelectRep(Instructions instructions);
}
