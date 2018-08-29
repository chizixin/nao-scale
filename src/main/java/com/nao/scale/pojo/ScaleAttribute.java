package com.nao.scale.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@TableName("scale_attribute")
public class ScaleAttribute extends Model<ScaleAttribute> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer fid;//父级id
	private Integer level;//等级
	private Integer isEnd;
	//@TableField(value="scale_id")
	private Integer scaleId;//量表ID
	private Integer score;
	private Integer M;
	private Integer S;
	private Integer A;
	private Integer B;
	
	@TableField(exist = false)
	private String com;
	
	@TableField(exist = false)
	private String rinform;
	
	
	
	public String getRinform() {
		return rinform;
	}



	public void setRinform(String rinform) {
		this.rinform = rinform;
	}



	public String getCom() {
		return com;
	}



	public void setCom(String com) {
		this.com = com;
	}



	@TableField(exist = false)
	private List<ScaleAttribute> scaleAttribute = new ArrayList<ScaleAttribute>();
	@TableField(exist = false)
	private List<Computations> comptations = new ArrayList<Computations>();
	
	
	
	
	public List<Computations> getComptations() {
		return comptations;
	}



	public void setComptations(List<Computations> comptations) {
		this.comptations = comptations;
	}



	public ScaleAttribute() {		
	}

	

	public List<ScaleAttribute> getScaleAttribute() {
		return scaleAttribute;
	}

	public Integer getM() {
		return M;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setM(Integer m) {
		M = m;
	}

	public Integer getS() {
		return S;
	}

	public void setS(Integer s) {
		S = s;
	}

	public Integer getA() {
		return A;
	}

	public void setA(Integer a) {
		A = a;
	}

	public Integer getB() {
		return B;
	}

	public void setB(Integer b) {
		B = b;
	}

	public void setScaleAttribute(List<ScaleAttribute> scaleAttribute) {
		this.scaleAttribute = scaleAttribute;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id 

 = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name 

 = name;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(Integer isEnd) {
		this.isEnd = isEnd;
	}

	

	public Integer getScaleId() {
		return scaleId;
	}



	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}



	@Override
	protected Serializable pkVal() {
		return this.id 

;
	}



	public List<ScaleTA> getScaleta(Integer id2) {
		// TODO Auto-generated method stub
		return null;
	}



	


	

	

}