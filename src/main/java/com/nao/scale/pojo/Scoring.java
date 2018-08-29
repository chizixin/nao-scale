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
 * @since 2017-10-10
 */
@TableName("scoring")
public class Scoring extends Model<Scoring> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String attrId;
	private Integer topicId;
	private String context;
	private String optionsId;
	private Integer userId;
	private Integer scaleId;
	private String score;
	
	@TableField(exist = false)
	private Options options;
	@TableField(exist = false)
	private String problem;
	@TableField(exist = false)
	private Integer topicid;
	
	
	
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAttrId() {
		return attrId;
	}
	public void setAttrId(String attrId) {
		this.attrId = attrId;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getOptionsId() {
		return optionsId;
	}
	public void setOptionsId(String optionsId) {
		this.optionsId = optionsId;
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
	
	public Options getOptions() {
		return options;
	}
	public void setOptions(Options options) {
		this.options = options;
	}

	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Integer getTopicid() {
		return topicid;
	}
	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
