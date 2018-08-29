package com.nao.scale.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-10-12
 */
public class Computations extends Model<Computations> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String computations;
	private String msad;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComputations() {
		return computations;
	}

	public void setComputations(String computations) {
		this.computations = computations;
	}

	public String getMsad() {
		return msad;
	}

	public void setMsad(String msad) {
		this.msad = msad;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
