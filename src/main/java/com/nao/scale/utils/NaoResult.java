package com.nao.scale.utils;

public class NaoResult {
	private Integer status;
	
	private Object object;
	
	private String message;
	
	private String token;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public NaoResult() {
		super();
		// TODO Auto-generated constructor stub
	}
}
