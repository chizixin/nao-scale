package com.nao.scale.mapper;

import com.nao.scale.pojo.ScaleAttribute;
import com.nao.scale.pojo.ScaleTA;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
public interface ScaleAttributeMapper extends BaseMapper<ScaleAttribute> {

	List loadScaleAttr(Integer scaleId);

	int insertAttr(ScaleAttribute attr);

	List selectListtopic(Integer scaleId);

	void getAttr();

	List selectbyFid(String name);

	int updateIsEnd(Integer fid);

	List updateIsEnd(List list);

	List<ScaleAttribute> getAttrbuteList(Integer scaleId);

	List updateAttr(ScaleAttribute scaleAttribute);

	List loadscore(Integer id);

	List<ScaleAttribute> getScaleta(Integer id2);

	void updateById(List<ScaleAttribute> attr);

	List<ScaleAttribute> selectListScore(@Param("scaleId")Integer scaleId, @Param("userId")Integer userId);

	List<ScaleAttribute> selectListSc(@Param("scaleId")Integer scaleId, @Param("id")Integer id, @Param("userId")Integer userId);

	List<ScaleAttribute> selectListS(@Param("scaleId")Integer scaleId, @Param("id2")Integer id2, @Param("userId")Integer userId);

	List<ScaleAttribute> selectList(@Param("scaleId")Integer scaleId, @Param("id3")Integer id3,@Param("userId") Integer userId);

	String selectFid(String string);

	String selectFi(String fid);

	String selectF(String fid2);

	Integer selectscore(Integer integer);

	ScaleAttribute selectMSAB(Integer integer);

	List<ScaleAttribute> selectListOne(Integer scaleId);

	List<ScaleAttribute> selectListTwo(@Param("id")Integer id, @Param("scaleId")Integer scaleId);

	List<ScaleAttribute> getScaletaLi(Integer id3);

	List getxml(Integer id);

	List<ScaleAttribute> getScaleAttribute(Integer id2);

	List getAtt(Integer id);


	//List<ScaleAttribute> selectListThree(@Param("id")Integer id, @Param("scaleID")Integer scaleID);


	


}   