package com.nao.scale.oldscale;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Questions {
	@JsonProperty(value = "ID")
	private String ID;
	@JsonProperty(value = "UUID")
	private String UUID;
	@JsonProperty(value = "CREATETIME")
	private String CREATETIME;
	@JsonProperty(value = "CREATEEMPID")
	private String CREATEEMPID;
	@JsonProperty(value = "MODIFYTIME")
	private String MODIFYTIME;
	@JsonProperty(value = "MODIFYEMPID")
	private String MODIFYEMPID;
	@JsonProperty(value = "SCALEINFOID")
	private String SCALEINFOID;
	@JsonProperty(value = "QUESTIONLIBID")
	private String QUESTIONLIBID;
	@JsonProperty(value = "SHOWINDEX")
	private String SHOWINDEX;
	@JsonProperty(value = "REMARK")
	private String REMARK;
	
	private Detail detail;
	
	private List<Answers> answers ;
	
	

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getCREATETIME() {
		return CREATETIME;
	}

	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}

	public String getCREATEEMPID() {
		return CREATEEMPID;
	}

	public void setCREATEEMPID(String cREATEEMPID) {
		CREATEEMPID = cREATEEMPID;
	}

	public String getMODIFYTIME() {
		return MODIFYTIME;
	}

	public void setMODIFYTIME(String mODIFYTIME) {
		MODIFYTIME = mODIFYTIME;
	}

	public String getMODIFYEMPID() {
		return MODIFYEMPID;
	}

	public void setMODIFYEMPID(String mODIFYEMPID) {
		MODIFYEMPID = mODIFYEMPID;
	}

	public String getSCALEINFOID() {
		return SCALEINFOID;
	}

	public void setSCALEINFOID(String sCALEINFOID) {
		SCALEINFOID = sCALEINFOID;
	}

	public String getQUESTIONLIBID() {
		return QUESTIONLIBID;
	}

	public void setQUESTIONLIBID(String qUESTIONLIBID) {
		QUESTIONLIBID = qUESTIONLIBID;
	}

	public String getSHOWINDEX() {
		return SHOWINDEX;
	}

	public void setSHOWINDEX(String sHOWINDEX) {
		SHOWINDEX = sHOWINDEX;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}
	
	
}
