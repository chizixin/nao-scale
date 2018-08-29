package com.nao.scale.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.List;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-10-10
 */
public class Instructions extends Model<Instructions> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String attrId;
	private String instructions;
	private Integer userId;
	private Integer scaleId;
	
	@TableField(exist=false)
	private List<User> user;
	@TableField(exist=false)
	private List<ScaleAttribute> scaleAttribute;
	@TableField(exist=false)
	private List<ScaleBasic> ScaleBasic;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
  
	public String getAttrId() {
		return attrId;
	}

	public void setAttrId(String attrId) {
		this.attrId = attrId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getScaleId() {
		return scaleId;
	}

	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<ScaleAttribute> getScaleAttribute() {
		return scaleAttribute;
	}

	public void setScaleAttribute(List<ScaleAttribute> scaleAttribute) {
		this.scaleAttribute = scaleAttribute;
	}

	public List<ScaleBasic> getScaleBasic() {
		return ScaleBasic;
	}

	public void setScaleBasic(List<ScaleBasic> scaleBasic) {
		ScaleBasic = scaleBasic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
