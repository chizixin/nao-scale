package com.nao.scale.oldscale;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
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
	@JsonProperty(value = "SCALENAME") 
	private String SCALENAME;
	@JsonProperty(value = "SHORTNAME") 
	private String SHORTNAME;

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

	public String getSCALENAME() {
		return SCALENAME;
	}

	public void setSCALENAME(String sCALENAME) {
		SCALENAME = sCALENAME;
	}

	public String getSHORTNAME() {
		return SHORTNAME;
	}

	public void setSHORTNAME(String sHORTNAME) {
		SHORTNAME = sHORTNAME;
	}

	
	@JsonProperty(value = "SYMPTOMS") 
	private String SYMPTOMS;
	@JsonProperty(value = "REMARK") 
	private String REMARK;
	@JsonProperty(value = "GBNAME") 
	private String GBNAME;
	@JsonProperty(value = "GBCODE") 
	private String GBCODE;
	@JsonProperty(value = "ICDNAME") 
	private String ICDNAME;
	@JsonProperty(value = "ICDCODE") 
	private String ICDCODE;
	@JsonProperty(value = "ISPATIENTAUTO") 
	private String ISPATIENTAUTO;
	@JsonProperty(value = "PAGEPATH") 
	private String PAGEPATH;
	@JsonProperty(value = "ISACTION") 
	private String ISACTION;
	@JsonProperty(value = "MAXTIME") 
	private String MAXTIME;
	@JsonProperty(value = "VERNO") 
	private String VERNO;
	@JsonProperty(value = "ORGID") 
	private String ORGID;
	@JsonProperty(value = "ISPUBLIC") 
	private String ISPUBLIC;
	@JsonProperty(value = "RESULTEXPLAIN") 
	private String RESULTEXPLAIN;
	@JsonProperty(value = "ORDERIDX") 
	private String ORDERIDX;
	@JsonProperty(value = "ISDELETED") 
	private String ISDELETED;
	
	private List<Questions> questions ;
	
	private Group group;

	public String getSYMPTOMS() {
		return SYMPTOMS;
	}

	public void setSYMPTOMS(String sYMPTOMS) {
		SYMPTOMS = sYMPTOMS;
	}

	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public String getGBNAME() {
		return GBNAME;
	}

	public void setGBNAME(String gBNAME) {
		GBNAME = gBNAME;
	}

	public String getGBCODE() {
		return GBCODE;
	}

	public void setGBCODE(String gBCODE) {
		GBCODE = gBCODE;
	}

	public String getICDNAME() {
		return ICDNAME;
	}

	public void setICDNAME(String iCDNAME) {
		ICDNAME = iCDNAME;
	}

	public String getICDCODE() {
		return ICDCODE;
	}

	public void setICDCODE(String iCDCODE) {
		ICDCODE = iCDCODE;
	}

	public String getISPATIENTAUTO() {
		return ISPATIENTAUTO;
	}

	public void setISPATIENTAUTO(String iSPATIENTAUTO) {
		ISPATIENTAUTO = iSPATIENTAUTO;
	}

	public String getPAGEPATH() {
		return PAGEPATH;
	}

	public void setPAGEPATH(String pAGEPATH) {
		PAGEPATH = pAGEPATH;
	}

	public String getISACTION() {
		return ISACTION;
	}

	public void setISACTION(String iSACTION) {
		ISACTION = iSACTION;
	}

	public String getMAXTIME() {
		return MAXTIME;
	}

	public void setMAXTIME(String mAXTIME) {
		MAXTIME = mAXTIME;
	}

	public String getVERNO() {
		return VERNO;
	}

	public void setVERNO(String vERNO) {
		VERNO = vERNO;
	}

	public String getORGID() {
		return ORGID;
	}

	public void setORGID(String oRGID) {
		ORGID = oRGID;
	}

	public String getISPUBLIC() {
		return ISPUBLIC;
	}

	public void setISPUBLIC(String iSPUBLIC) {
		ISPUBLIC = iSPUBLIC;
	}

	public String getRESULTEXPLAIN() {
		return RESULTEXPLAIN;
	}

	public void setRESULTEXPLAIN(String rESULTEXPLAIN) {
		RESULTEXPLAIN = rESULTEXPLAIN;
	}

	public String getORDERIDX() {
		return ORDERIDX;
	}

	public void setORDERIDX(String oRDERIDX) {
		ORDERIDX = oRDERIDX;
	}

	public String getISDELETED() {
		return ISDELETED;
	}

	public void setISDELETED(String iSDELETED) {
		ISDELETED = iSDELETED;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	

	

		

}
