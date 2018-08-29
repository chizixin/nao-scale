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
@TableName("scale_basic")
@XmlRootElement(name = "scale_basic")
public class ScaleBasic extends Model<ScaleBasic> implements Serializable{

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String scalename;
	private String name;
	private String time;
	private Integer topiccount;
	private String introduce;
	private String guide;
	private String age;
	private String test;
	private String aid;
	@TableField(exist = false)
	private List<ScaleBasic> ScaleBasic ; 
	
	@TableField(exist = false)
	private List<Topic> topic;
	@TableField(exist = false)
	private Integer total;
	@TableField(exist = false)
	private Integer scaleId;
	@TableField(exist = false)
	private Integer userId;
	
	public ScaleBasic(){} 
	
	@TableField(exist = false)
	private Topic top;
	
	@TableField(exist = false)
	private Scoring scoring;
	
	@TableField(exist = false)
	private Integer  topicid;
	
	@TableField(exist = false)
	private Integer problem ;
	
	@TableField(exist = false)
	private Integer current ;//当前的题的下标



	public Integer getScaleId() {
		return scaleId;
	}

	public void setScaleId(Integer scaleId) {
		this.scaleId = scaleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTopicid() {
		return topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

	public Integer getProblem() {
		return problem;
	}

	public void setProblem(Integer problem) {
		this.problem = problem;
	}

	public Scoring getScoring() {
		return scoring;
	}

	public void setScoring(Scoring scoring) {
		this.scoring = scoring;
	}

	public Topic getTop() {
		return top;
	}

	public void setTop(Topic top) {
		this.top = top;
	}

	public List<ScaleBasic> getScaleBasic() {
		return ScaleBasic;
	}

	public void setScaleBasic(List<ScaleBasic> scaleBasic) {
		ScaleBasic = scaleBasic;
	}

	public ScaleBasic(Integer id, String scalename, String name, String time, Integer topiccount, String introduce,
			String guide, String age, String test, String aid, List<Topic> topic) {
		super();
		this.id = id;
		this.scalename = scalename;
		this.name = name;
		this.time = time;
		this.topiccount = topiccount;
		this.introduce = introduce;
		this.guide = guide;
		this.age = age;
		this.test = test;
		this.aid = aid;
		this.topic = topic;
	}




	public List<Topic> getTopic() {
		return topic;
	}

	public void setTopic(List<Topic> topic) {
		this.topic = topic;
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

	public String getScalename() {
		return scalename;
	}

	public void setScalename(String scalename) {
		this.scalename = scalename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getTime() {
		return time;
	}




	public void setTime(String time) {
		this.time = time;
	}




	public Integer getTopiccount() {
		return topiccount;
	}

	public void setTopiccount(Integer topiccount) {
		this.topiccount = topiccount;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
