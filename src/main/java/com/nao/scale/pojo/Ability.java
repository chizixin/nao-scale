package com.nao.scale.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@TableName("ability")
public class Ability extends Model<Ability> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String abilityname;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbilityname() {
		return abilityname;
	}

	public void setAbilityname(String abilityname) {
		this.abilityname = abilityname;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
