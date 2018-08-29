package com.nao.scale.service;
import com.nao.scale.pojo.Scoring;
import com.nao.scale.vo.Xml;
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
public interface ScoringService extends IService<Scoring> {

	Scoring insertScoring(Scoring scoring);

	/*int deleteScoring(Scoring scoring);*/

	Xml Submitcount(Scoring scoring);

	List selectScoring(Scoring scoring);

}
