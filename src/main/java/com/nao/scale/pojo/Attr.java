package com.nao.scale.pojo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Attr")
public class Attr {
	
	private Integer id;
	private Integer score;
	private String  Msad;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getMsad() {
		return Msad;
	}
	public void setMsad(String msad) {
		Msad = msad;
	}
	
	
	
	
	
}
