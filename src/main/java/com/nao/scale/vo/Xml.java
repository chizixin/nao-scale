package com.nao.scale.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nao.scale.pojo.ScaleBasic;


@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })  
public class Xml {
	private Questionnaire questionnaire;
	
	
	private List scaleBasic;

	

	public List getScaleBasic() {
		return scaleBasic;
	}

	public void setScaleBasic(List scaleBasic) {
		this.scaleBasic = scaleBasic;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	
}
