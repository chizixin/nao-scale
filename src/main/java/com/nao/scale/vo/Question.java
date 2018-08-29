package com.nao.scale.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Question {
	private Integer _id;
	private String _type;
	private String wording;
	private List<String> option;
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String getWording() {
		return wording;
	}
	public void setWording(String wording) {
		this.wording = wording;
	}
	public List<String> getOption() {
		return option; 
	}
	public void setOption(List<String> option) {
		this.option = option;
	}

	
	
}
