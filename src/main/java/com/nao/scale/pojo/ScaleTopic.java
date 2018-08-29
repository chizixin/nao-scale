package com.nao.scale.pojo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

public class ScaleTopic {
	
	private Integer scaleId;
	private Integer attrid;
	private Integer topicId;
	private Integer optionsid;
	
	private String scalename;
	private String name;
	private String introduce;
	private String attrname;
	private Integer level;
	private Integer bark;
	private String topicname;
	private String optionsname;
	
	
	public Integer getAttrid() {
		return attrid;
	}
	public void setAttrid(Integer attrid) {
		this.attrid = attrid;
	}
	public Integer getOptionsid() {
		return optionsid;
	}
	public void setOptionsid(Integer optionsid) {
		this.optionsid = optionsid;
	}
	public String getScalename() {
		return scalename;
	}
	public void setScalename(String scalename) {
		this.scalename = scalename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getAttrname() {
		return attrname;
	}
	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
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
	public String getOptionsname() {
		return optionsname;
	}
	public void setOptionsname(String optionsname) {
		this.optionsname = optionsname;
	}
	public Integer getScaleId() {
		return scaleId;
	}
	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	
	
	
	

}
