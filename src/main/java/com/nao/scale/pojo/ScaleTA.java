package com.nao.scale.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-09-10
 */
@TableName("scale_t_a")
public class ScaleTA extends Model<ScaleTA> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer tid;
	private Integer aid;
	@TableField(exist = false)
	private String ta;
	
	


	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
