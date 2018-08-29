package com.nao.scale.pojo;
import com.baomidou.mybatisplus.activerecord.Model;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-10-10
 */
public class Report extends Model<Report> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private Integer scaleId;
	private Integer attrId;
	private double rinform;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public double getRinform() {
		return rinform;
	}

	public void setRinform(double rinform) {
		this.rinform = rinform;
	}

	public void setRinform(Float rinform) {
		this.rinform = rinform;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
