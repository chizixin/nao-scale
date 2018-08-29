package com.nao.scale.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;


import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@TableName("options")
public class Options extends Model<Options> {

    private static final long serialVersionUID = 1L;

	private Integer id;//主键
	//@TableField(value="topicID")
	private Integer topicId;//题目外键
	private String optionsname;//题的内容
	private String img;//图片
	private String instruction;//说明
	private String score;//得分
	private String  problem;//跳至题号
	private Boolean mutex;
	
	
	
	
	

	

	public Boolean getMutex() {
		return mutex;
	}

	public void setMutex(Boolean mutex) {
		this.mutex = mutex;
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

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getOptionsname() {
		return optionsname;
	}

	public void setOptionsname(String optionsname) {
		this.optionsname = optionsname;
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

	


	/*@Override
	public String toString() {
		return "Options [id=" + id + ", topicID=" + topicID + ", optionsname=" + optionsname + ", img=" + img
				+ ", instruction=" + instruction + ", score=" + score + ", problem=" + problem + "]";
	}*/

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
