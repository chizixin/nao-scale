package com.nao.scale.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Questionnaire {
		private Integer _id;
		private String _name;
		private String title;
		private String brief;
		private String subtitle;
		private String   paragraph;
		private List<Question> question;
		public Integer get_id() {
			return _id;
		}
		public void set_id(Integer _id) {
			this._id = _id;
		}
		public String get_name() {
			return _name;
		}
		public void set_name(String _name) {
			this._name = _name;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getBrief() {
			return brief;
		}
		public void setBrief(String brief) {
			this.brief = brief;
		}
		public String getSubtitle() {
			return subtitle;
		}
		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}
		public String getParagraph() {
			return paragraph;
		}
		public void setParagraph(String paragraph) {
			this.paragraph = paragraph;
		}
		public List<Question> getQuestion() {
			return question;
		}
		public void setQuestion(List<Question> question) {
			this.question = question;
		}
	
	

}
