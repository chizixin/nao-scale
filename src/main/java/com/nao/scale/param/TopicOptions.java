package com.nao.scale.param;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.nao.scale.pojo.Options;

public class TopicOptions {
	private Integer id;
	private Integer bark;
	private String topicname;
	private String img;
	private String instruction; 
	private String ttname;
	private String record;
	private Integer scaleId;
	@TableField(exist=false)
	private List<Options> options;
	@TableField(exist=false)
	private String ta;
	@TableField(exist=false)
	private String option;
	
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getTa() {
		return ta;
	}
	public void setTa(String ta) {
		this.ta = ta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBark() {
		return bark;
	}
	public void setBark(Integer bark) {
		this.bark = bark;
	}
	public String getTopicname() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getTtname() {
		return ttname;
	}
	public void setTtname(String ttname) {
		this.ttname = ttname;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public Integer getScaleId() {
		return scaleId;
	}
	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}
	public List<Options> getOptions() {
		return options;
	}
	public void setOptions(List<Options> options) {
		this.options = options;
	}
	
}
