package com.nao.scale.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@TableName("topic")
@XmlRootElement(name = "topic")
public class Topic extends Model<Topic> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer bark;
	private String topicname;
	private String img;
	private String instruction; 
	private String ttname;
	private String record;
	private Integer scaleId;
	
	
	@TableField(exist=false)
	private String options;
	
	@TableField(exist=false)
	private int qid;
	
	@TableField(exist=false)
	private String ta;
	
	@TableField(exist=false)
	private String current;
	
	@TableField(exist=false)
	private List<Options> option;
	
	@TableField(exist=false)
	private List<Scoring> scor;
	
	@TableField(exist=false)
	private Options opt;
	
	@TableField(exist=false)
	private Scoring scoring;
	
	@TableField(exist=false)
	private ScaleAttribute scaleAttr;
	
	@TableField(exist=false)
	private List<ScaleAttribute> scaleAttribute;
	
	//private List<ScaleTA> scaleTA;
	@TableField(exist=false)
	private String aid;
	
	@TableField(exist=false)
	private String optionsnmae;
	
	@TableField(exist=false)
	private List<ScaleAttribute> attr;




	

	

	public List<ScaleAttribute> getAttr() {
		return attr;
	}

	public void setAttr(List<ScaleAttribute> attr) {
		this.attr = attr;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public List<Scoring> getScor() {
		return scor;
	}

	public void setScor(List<Scoring> scor) {
		this.scor = scor;
	}

	public String getOptionsnmae() {
		return optionsnmae;
	}

	public void setOptionsnmae(String optionsnmae) {
		this.optionsnmae = optionsnmae;
	}

	public Scoring getScoring() {
		return scoring;
	}

	public void setScoring(Scoring scoring) {
		this.scoring = scoring;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public ScaleAttribute getScaleAttr() {
		return scaleAttr;
	}

	public void setScaleAttr(ScaleAttribute scaleAttr) {
		this.scaleAttr = scaleAttr;
	}

	public Options getOpt() {
		return opt;
	}

	public void setOpt(Options opt) {
		this.opt = opt;
	}

	public Integer getScaleId() {
		return scaleId;
	}

	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}

	public List<ScaleAttribute> getScaleAttribute() {
		return scaleAttribute;
	}

	public void setScaleAttribute(List<ScaleAttribute> scaleAttribute) {
		this.scaleAttribute = scaleAttribute;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public List<Options> getOption() {
		return option;
	}

	public void setOption(List<Options> option) {
		this.option = option;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	

	public String getTtname() {
		return ttname;
	}



	public void setTtname(String ttname) {
		this.ttname = ttname;
	}



	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}



	

	@Override
	protected Serializable pkVal() {
		return this.id;
	}



	public void getScaleTA(List<ScaleTA> list2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", bark=" + bark + ", topicname=" + topicname + ", img=" + img + ", instruction="
				+ instruction + ", ttname=" + ttname + ", record=" + record + ", scaleId=" + scaleId + ", options="
				+ options + ", ta=" + ta + ", current=" + current + ", option=" + option + ", opt=" + opt
				+ ", scaleAttr=" + scaleAttr + ", scaleAttribute=" + scaleAttribute + ", aid=" + aid + "]";
	}

	
	
	

}
