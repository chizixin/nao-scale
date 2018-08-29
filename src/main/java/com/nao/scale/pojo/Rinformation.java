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
@TableName("rinformation")
public class Rinformation extends Model<Rinformation> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer scaleId;
	private String Reportname;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getScaleId() {
		return scaleId;
	}

	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getReportname() {
		return Reportname;
	}

	public void setReportname(String Reportname) {
		this.Reportname = Reportname;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
