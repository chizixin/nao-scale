package com.nao.scale.oldscale;

import org.codehaus.jackson.annotate.JsonProperty;

public class Group {
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
	@JsonProperty(value = "GROUPNAME")
	private String GROUPNAME;
	@JsonProperty(value = "SHORTNAME")
	private String SHORTNAME;
	@JsonProperty(value = "PARENTID")
	private String PARENTID;
	@JsonProperty(value = "REMARK")
	private String REMARK;

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

	public String getGROUPNAME() {
		return GROUPNAME;
	}

	public void setGROUPNAME(String gROUPNAME) {
		GROUPNAME = gROUPNAME;
	}

	public String getSHORTNAME() {
		return SHORTNAME;
	}

	public void setSHORTNAME(String sHORTNAME) {
		SHORTNAME = sHORTNAME;
	}

	public String getPARENTID() {
		return PARENTID;
	}

	public void setPARENTID(String pARENTID) {
		PARENTID = pARENTID;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	
}
