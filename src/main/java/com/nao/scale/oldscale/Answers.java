package com.nao.scale.oldscale;

import org.codehaus.jackson.annotate.JsonProperty;

public class Answers {
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
	@JsonProperty(value = "QUESTIONLIBID")
	private String QUESTIONLIBID;
	@JsonProperty(value = "ANSWERCONTENT")
	private String ANSWERCONTENT;
	@JsonProperty(value = "ISRIGHT")
	private String ISRIGHT;
	@JsonProperty(value = "SCORE")
	private String SCORE;
	@JsonProperty(value = "EXOPT")
	private String EXOPT;
	@JsonProperty(value = "REMARK")
	private String REMARK;
	@JsonProperty(value = "SHOWINDEX")
	private String SHOWINDEX;

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

	public String getQUESTIONLIBID() {
		return QUESTIONLIBID;
	}

	public void setQUESTIONLIBID(String qUESTIONLIBID) {
		QUESTIONLIBID = qUESTIONLIBID;
	}

	public String getANSWERCONTENT() {
		return ANSWERCONTENT;
	}

	public void setANSWERCONTENT(String aNSWERCONTENT) {
		ANSWERCONTENT = aNSWERCONTENT;
	}

	public String getISRIGHT() {
		return ISRIGHT;
	}

	public void setISRIGHT(String iSRIGHT) {
		ISRIGHT = iSRIGHT;
	}

	public String getSCORE() {
		return SCORE;
	}

	public void setSCORE(String sCORE) {
		SCORE = sCORE;
	}

	public String getEXOPT() {
		return EXOPT;
	}

	public void setEXOPT(String eXOPT) {
		EXOPT = eXOPT;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public String getSHOWINDEX() {
		return SHOWINDEX;
	}

	public void setSHOWINDEX(String sHOWINDEX) {
		SHOWINDEX = sHOWINDEX;
	}
	
	

}
