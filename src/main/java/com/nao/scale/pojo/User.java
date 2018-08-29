package com.nao.scale.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String phone;
	private String age;
	private Integer sex;
	private Integer hand;
	private Integer educationId;
	private Integer bir;
	
	


	public Integer getBir() {
		return bir;
	}

	public void setBir(Integer bir) {
		this.bir = bir;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getHand() {
		return hand;
	}

	public void setHand(Integer hand) {
		this.hand = hand;
	}

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
