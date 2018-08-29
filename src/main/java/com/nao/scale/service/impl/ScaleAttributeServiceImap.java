 package com.nao.scale.service.impl;

import com.nao.scale.pojo.Computations;
import com.nao.scale.pojo.ScaleAttribute;
import com.nao.scale.service.ScaleAttributeService;
import com.nao.scale.utils.JsonUtils;
import com.nao.scale.mapper.ComputationsMapper;
import com.nao.scale.mapper.ScaleAttributeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@Service
public class ScaleAttributeServiceImap extends ServiceImpl<ScaleAttributeMapper, ScaleAttribute> implements ScaleAttributeService {
	
	@Autowired
	private ScaleAttributeMapper scaleAttributeMapper; 
	@Autowired
	private ComputationsMapper computationsMapper;
	
	@Override
	public int insertAttr(ScaleAttribute attr) {
		//判断是否有父级id，如果没有默认为0
		if(attr.getFid()==null||attr.getFid().equals("undefined")){
			attr.setFid(0);attr.setLevel(1);
		}else{
				scaleAttributeMapper.updateIsEnd(attr.getFid());
			}
		return scaleAttributeMapper.insertAttr(attr);
	}

	@Override
	public int DeleteAttr(Integer id) {
		return scaleAttributeMapper.deleteById(id);
	}

	@Override
	public List loadScaleAttr(Integer scaleId) {
		return scaleAttributeMapper.loadScaleAttr(scaleId);
	}

	@Override
	public List<ScaleAttribute> getAttrbuteList(Integer scaleId) {
		EntityWrapper<ScaleAttribute> ew = new EntityWrapper<ScaleAttribute>();
		//ew.where("fid={0}", "0");
		//ew.andNew("scaleID={0}", scaleID);
		List<ScaleAttribute> list = scaleAttributeMapper.selectListOne(scaleId);//查询出所有的父级元素，这是第一级别
		for(int x = 0 ; x < list.size() ; x++) {
			 ScaleAttribute scaleAttribute = list.get(x);
				List<Computations> list4 = computationsMapper.selectList();
				scaleAttribute.setComptations(list4);
			}
		
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				ScaleAttribute attribute = list.get(i);
				EntityWrapper<ScaleAttribute> ew1 = new EntityWrapper<ScaleAttribute>();
				//ew1.where("fid={0}", attribute.getId());
				//ew1.andNew("scaleID={0}", scaleID);
				List<ScaleAttribute> list2 = scaleAttributeMapper.selectListTwo(attribute.getId(),scaleId);//查询出所有的父级元素，这是第二级别
				for(int q = 0 ; q < list2.size() ; q++) {
					 ScaleAttribute scaleAttribute = list2.get(q);
						List<Computations> list5 = computationsMapper.selectList(new EntityWrapper<Computations>());
						scaleAttribute.setComptations(list5);
					}
				attribute.setScaleAttribute(list2);//赋值第二级
				
				if(list2!=null && list2.size()>0){
					for(int j=0;j<list2.size();j++){
						ScaleAttribute attr = list2.get(j);
						EntityWrapper<ScaleAttribute> ew2 = new EntityWrapper<ScaleAttribute>();
						//ew2.where("fid={0}", attr.getId());
						//ew2.andNew("scaleID={0}", scaleID);
						List<ScaleAttribute> list3 = scaleAttributeMapper.selectListTwo(attr.getId(),scaleId);//查询出所有的父级元素，这是第三级别
						for(int w = 0 ; w < list3.size() ; w++) {
							 ScaleAttribute scaleAttribute = list3.get(w);
								List<Computations> list6 = computationsMapper.selectList(new EntityWrapper<Computations>());
								scaleAttribute.setComptations(list6);
							}
						attr.setScaleAttribute(list3);//赋值第三级
						
						if(list3!=null && list3.size()>0){
							for(int m=0;m<list3.size();m++){
								ScaleAttribute salaatt = list3.get(m);
								EntityWrapper<ScaleAttribute> ew3 = new EntityWrapper<ScaleAttribute>();
								//ew3.where("fid={0}",salaatt.getId());
								//ew3.andNew("scaleID={0}", scaleID);
								List<ScaleAttribute> list4 = scaleAttributeMapper.selectListTwo(salaatt.getId(),scaleId);//查询出所有的父级元素，这是第四级别
								for(int z = 0 ; z < list4.size() ; z++) {
									 ScaleAttribute scaleAttribute = list4.get(z);
										List<Computations> list7 = computationsMapper.selectList(new EntityWrapper<Computations>());
										scaleAttribute.setComptations(list7);
									}
								salaatt.setScaleAttribute(list4);
							}
						}
					}
				}
			}
		}
		return list;
	}


	@Override
	public List loadAttr(Integer scaleId) {
		return scaleAttributeMapper.selectListtopic(scaleId);
	}

	@Override
	public int UpdateAttr(String score) {
		List<ScaleAttribute> list = JsonUtils.jsonToList(score, ScaleAttribute.class);
		int i = this.UpdateAttrrList(list);
		return 0;
	}
	
	public int UpdateAttrrList(List<ScaleAttribute> list) {
		
		for (ScaleAttribute attribute : list) {
				this.UpdateAttrBute(attribute);
		}
		return 0;
	}		
	
	
	
	public int UpdateAttrBute(ScaleAttribute scaleAttribute) {
		scaleAttributeMapper.updateById(scaleAttribute);
		List<ScaleAttribute> attribute = scaleAttribute.getScaleAttribute();
		if(attribute!=null&attribute.size()>0){
			int i = this.UpdateAttrrList(attribute);
		}
		return 0;
	}	
	
	@Override
	public List loadscore(Integer id) {
		 List<ScaleAttribute> list = scaleAttributeMapper.loadscore(id);
		 for(int i = 0 ; i < list.size() ; i++) {
			 ScaleAttribute scaleAttribute = list.get(i);
				List<Computations> list1 = computationsMapper.selectList(new EntityWrapper<Computations>());
				scaleAttribute.setComptations(list1);
			}
		return list;
	}

	@Override
	public List getxmlList(Integer id) {
		return  scaleAttributeMapper.getxml(id) ;
	}
	
	
}
