package com.nao.scale.service.impl;

import com.nao.scale.pojo.Options;
import com.nao.scale.pojo.Rinformation;
import com.nao.scale.pojo.ScaleAttribute;
import com.nao.scale.pojo.ScaleBasic;
import com.nao.scale.pojo.ScaleTopic;
import com.nao.scale.pojo.Scoring;
import com.nao.scale.pojo.Topic;
import com.nao.scale.service.ScaleBasicService;
import com.nao.scale.utils.HttpClientUtil;
import com.nao.scale.utils.JsonUtils2;
import com.nao.scale.utils.UnicodeUtil;
import com.nao.scale.utils.XsltReadFileUtil;
import com.nao.scale.mapper.OptionsMapper;
import com.nao.scale.mapper.RinformationMapper;
import com.nao.scale.mapper.ScaleAttributeMapper;
import com.nao.scale.mapper.ScaleBasicMapper;
import com.nao.scale.mapper.ScaleTAMapper;
import com.nao.scale.mapper.ScoringMapper;
import com.nao.scale.mapper.TopicMapper;
import com.nao.scale.oldscale.Answers;
import com.nao.scale.oldscale.Detail;
import com.nao.scale.oldscale.Group;
import com.nao.scale.oldscale.Questions;
import com.nao.scale.oldscale.Root;
import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@Service
public class ScaleBasicServiceImap extends ServiceImpl<ScaleBasicMapper, ScaleBasic> implements ScaleBasicService {

	@Autowired
	private ScaleBasicMapper scaleBasicDao;
	@Autowired
	private TopicMapper topicMapper ;
	@Autowired
	private OptionsMapper optionsMapper ;
	@Autowired
	private ScaleTAMapper scaleTAMapper ;
	@Autowired
	private ScoringMapper scoringMapper;
	@Autowired
	private ScaleAttributeMapper scaleAttributeMapper;
	@Autowired
	private RinformationMapper rinformationMapper;
	
	@Override
	public List getscaleList(Integer id ) {
		return scaleBasicDao.selectListByID(id);
	}
	
	@Override
	public List selectScaleBasic(ScaleBasic scaleBasic) {
		return scaleBasicDao.selectScaleBasicList();
	}    

	@Override
	public int insertScaleBasic(ScaleBasic scaleBasic) {
		String scalename = scaleBasic.getScalename();
		if(scalename!=null&&!"".equals(scalename)){
		 scaleBasicDao.insertScaleBasic(scaleBasic);
		 Integer id = scaleBasic.getId();
		 return id;
		}else{
			return 0;
		}
	}

	@Override
	public int updateScaleBasic(ScaleBasic scaleBasic) {
		return scaleBasicDao.updateById(scaleBasic);
	}

	
	@Override
	public List selectScale() {
		return scaleBasicDao.selectScale();
	}

	@Override
	public List<ScaleTopic> getList() {
		return scaleBasicDao.getList();
	}

	@Override
	public List getScaleTopicList(Integer id) {
		List<ScaleBasic> list = scaleBasicDao.getScale(id);
		List<Topic> barkList = topicMapper.getTopicBark(id); 
		for(int i = 0 ; i < list.size() ; i++) {
			ScaleBasic scaleBasic = list.get(i);
			Integer id1 = scaleBasic.getId();
			List<Topic> list1 = topicMapper.getTopic(id1);
			
			for (Topic topic : list1) {
				Integer id2 = topic.getId();
				Integer bark = topic.getBark();
				List<Options> list2 = optionsMapper.getOptions(id2);
				topic.setOption(list2);
				List<ScaleAttribute> list3 = scaleAttributeMapper.getScaleAttribute(id2);
				topic.setScaleAttribute(list3);
				for (int z = 0; z< barkList.size(); z++) {
					if(barkList.get(z).getBark().equals(bark)){
						topic.setQid(z+1);
					}
				};
			}
			scaleBasic.setTopic(list1);
		}
 		return list;
	}
 
	@Override
	public List getScaleTopicL(Integer id) {
		List<ScaleBasic> list = scaleBasicDao.getScale(id); 
		for(int i = 0 ; i < list.size() ; i++) {
			ScaleBasic scaleBasic = list.get(i);
			//Integer id1 = scaleBasic.getId();
			List<Topic> list1 = topicMapper.getTopicList(id); 
			for (Topic topic : list1) {
				Integer id2 = topic.getId();
				List<Options> list2 = optionsMapper.getOptionsList(id2);
				topic.setOption(list2);
				List<ScaleAttribute> list3 =scaleAttributeMapper.getScaleta(id2); 
				topic.setScaleAttribute(list3);
			} 
			scaleBasic.setTopic(list1);
		}
		return list;
	}

	@Override
	public Integer uploadPicture(MultipartFile uploadFile) {
		FTPClient ftpClient = new FTPClient();
		Map resultMap = new HashMap<>();
		BufferedReader reader = null;
		String laststr = "";
		
		try {
			//取出json文件内容
			InputStream inputStream = uploadFile.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while((tempString = reader.readLine()) != null){
			laststr += tempString;
			}
			reader.close();
			
			String scale = laststr.replaceAll(" ", "");
			System.out.println(scale);
			List<ScaleBasic> jsonToList = JsonUtils2.jsonToList(scale, ScaleBasic.class);
			return jsonToList.get(0).getId();
			
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public ScaleBasic getScaleTopicOptionsList(ScaleBasic scaleBasic) {
		Scoring scoring = scaleBasic.getScoring();
		Integer id = scaleBasic.getId();
		ScaleBasic scaleBasic2= scaleBasicDao.getScaleList(id);
		//查询大列表
		List<Topic> list1 = topicMapper.getTopicList(id); 
		for (Topic topic : list1) {
			Integer id2 = topic.getId();
			List<Options> list2 = optionsMapper.getOptionsList(id2);
			topic.setOption(list2);
			List<ScaleAttribute> list3 =scaleAttributeMapper.getScaleta(id2); 
			topic.setScaleAttribute(list3);
		} 
		//查询该量表下的bark
		List<Topic> barkList = topicMapper.getTopicBark(id); 
		//总体数
		int  total= list1.size();
		//判断是否跳题（单选）
		if(scaleBasic!=null&&scaleBasic.getProblem()!=null&&scaleBasic.getProblem()!=0){
				//跳题的题号
				Integer problem = scaleBasic.getProblem();
				//根据下标找出下一题
				Topic topic = list1.get(problem-1);
				//下一题的bark
				Integer bark2 = topic.getBark();
				//取出该题的下表(题号)
				for (int i = 0; i < barkList.size(); i++) {
					if(barkList.get(i).getBark().equals(bark2)){
						scaleBasic2.setCurrent(i+1);
					}
				};
				scaleBasic2.setTop(topic);
				//多选或文本(根据bark查找下一题)
		}else if(scaleBasic!=null&&scaleBasic.getTopicid()!=null){
			//取出题目的id
			Integer id2 = scaleBasic.getTopicid();
			//找出下一题
			Topic topic = topicMapper.selectTop(id2);
			//取出id查出题的内容
			Integer id3 = topic.getId();
			Integer bark2 = topic.getBark();
			List<Options> list4 = optionsMapper.getOptionsLi(id3);
			List<ScaleAttribute> list5 =scaleAttributeMapper.getScaletaLi(id3); 
			topic.setOption(list4);
			topic.setScaleAttribute(list5);
			for (int i = 0; i < barkList.size(); i++) {
				if(barkList.get(i).getBark().equals(bark2)){
					scaleBasic2.setCurrent(i+1);
				}
			};
			scaleBasic2.setTop(topic); 
			//第一题
		}else{
			Topic topic = topicMapper.getTopList(id);
			Integer id2= topic.getId();
			Integer bark2= topic.getBark();
			List<Options> list2 = optionsMapper.getOptionsList(id2);
			topic.setOption(list2);
			List<ScaleAttribute> list3 =scaleAttributeMapper.getScaleta(id2); 
			topic.setScaleAttribute(list3);
			for (int i = 0; i < barkList.size(); i++) {
				if(barkList.get(i).getBark().equals(bark2)){
					scaleBasic2.setCurrent(i+1);
				}
			};
			scaleBasic2.setTop(topic);
		}
		scaleBasic2.setTotal(total+1) ;
		return scaleBasic2;
	}
	
	@Override
	public int delScaleBasic(Integer id) {
		
		return scaleBasicDao.deleteById(id);
	}
	
	
	/**
	 * 导入新的量表工具
	 * 
	 */
	@Override
	public String uploadJson(MultipartFile uploadFile) {
		FTPClient ftpClient = new FTPClient();
		Map resultMap = new HashMap<>();
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer();
		ScaleBasic scaleBasic = new ScaleBasic();
		Rinformation rinformation = new Rinformation();
		Topic topic = new Topic();
		Options options = new Options();
		try {
			//取出json文件内容
			InputStream inputStream = uploadFile.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while((tempString = reader.readLine()) != null){
				buffer.append(tempString);
			}
			reader.close();
			String scale = buffer.toString();
			//String scale = laststr.replaceAll(" ", "");
			String string = UnicodeUtil.convert(scale);
			System.out.println("===>"+string);
			//List<Root> jsonToList = JsonUtils2.jsonToList(scale, Root.class);
			Root root = JsonUtils2.jsonToPojo(scale, Root.class); 
			//量表基本信息
			String scalename = root.getSCALENAME();
			String shortname = root.getSHORTNAME();
			String ispatientauto = root.getISPATIENTAUTO();
			//付文本编辑器
			String resultexplain = root.getRESULTEXPLAIN();
			//题目
			Group group = root.getGroup();
			String groupname = group.getGROUPNAME();
			//判断属性
			String a = "1";
			String b = "4";
			String c = "5";
			String d = "6";
			String e = "7";
			if(groupname!="综合"&&groupname!="生活能力"&&groupname!="=情绪"&&groupname!="运动"){
				scaleBasic.setAid(a);
			} else  if (groupname!="认知"&&groupname!="生活能力"&&groupname!="=情绪"&&groupname!="运动"){
				scaleBasic.setAid(e);
			}else if(groupname!="认知"&&groupname!="综合"&&groupname!="=情绪"&&groupname!="运动"){
				scaleBasic.setAid(b);
			}else if(groupname!="认知"&&groupname!="生活能力"&&groupname!="=综合"&&groupname!="运动"){
				scaleBasic.setAid(c);
			}else if(groupname!="认知"&&groupname!="生活能力"&&groupname!="=情绪"&&groupname!="综合"){
				scaleBasic.setAid(d);
				}
			//添加量表基本信息
			scaleBasic.setScalename(scalename); 
			scaleBasic.setName(shortname);
			scaleBasicDao.insertScaleBasic(scaleBasic);
			//取出量表ID
			Integer id = scaleBasic.getId();
			//添加付文本编辑器内容
			rinformation.setScaleId(id);
			rinformation.setReportname(resultexplain);
			rinformationMapper.insert(rinformation);
			
			//取出量表题目
			List<Questions> questions = root.getQuestions();
			System.out.println(questions.size());
			for (Questions questions2 : questions) {
				Detail detail = questions2.getDetail();
				//提干
				String content = detail.getCONTENT();
				//提干说明
				String memo = detail.getMEMO();
				//添加题目
				topic.setScaleId(id);
				topic.setTopicname(content);
				topic.setInstruction(memo);
				//是否多选0否1是
				String ismultiselect = detail.getISMULTISELECT();
				if(ismultiselect!="0"&&ismultiselect=="1"){
					topic.setTtname("checkboxs");
				}else{
					topic.setTtname("radio/text");
				}
				topicMapper.insertTopic(topic);
				Integer topicID = topic.getId();
				
				
				List<Answers> answers = questions2.getAnswers();
				
				for (Answers answers2 : answers) {
						//选项内容
					   String answercontent = answers2.getANSWERCONTENT();
					   //得分
					   String score = answers2.getSCORE();
					   //跳题
					   String exopt = answers2.getEXOPT();
					   //添加
					   options.setTopicId(topicID);
					   options.setOptionsname(answercontent);
					   options.setScore(score);
					   options.setProblem(exopt);
					   optionsMapper.insert(options);
				}
				
			}
			return root.getID();
			
		} catch (Exception e) {  
			return null;
		}
	}

	@Override
	public int getScale(ScaleBasic scaleBasic) {
		Integer id = scaleBasic.getId();
		String scalename = scaleBasic.getScalename();
		try {
            //创建一个URL实例
            URL url = new URL("http://localhost:8081/nao-scale-xml/scaleBasic/scaleXML?id="+id);
            System.out.println(url);
            try {
                //通过URL的openStrean方法获取URL对象所表示的自愿字节输入流
                InputStream is = url.openStream();
                InputStreamReader isr = new InputStreamReader(is,"utf-8");

                //为字符输入流添加缓冲
                BufferedReader br = new BufferedReader(isr);
                String data = br.readLine();//读取数据
                 System.out.println(data);//输出数据
                  this.cp(data,scalename);
              
                br.close();
                isr.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        
		return 0;
	}
		return id;
	}

	public void cp(String data,String scalename) {
		
		//String wording = XsltReadFileUtil.readToString("G:\\黄飏鲲\\index.xslt");//文件地址
		//System.out.println(wording);
		HashMap<String,String> map = new HashMap<String,String>(); 
		//String cc = "<catalog><id>5</id><scalename>量表测试名称</scalename><name>量表测试短命</name><time>10-20</time><topiccount>12</topiccount><introduce>量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍量表介绍</introduce><guide>量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南量表指南表指南量表指南量表指南量表指南量表指南</guide><age>2,3,4</age><test>2,4</test><aid>1,2</aid><topic><id>20</id><bark>20</bark><topicname>第一题</topicname><img></img><instruction>第一题提干说明文字</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><option><option><id>103</id><topicId>20</topicId><optionsname>选项一</optionsname><img /><instruction>选项一选项说明文字</instruction><score>5</score><problem>3</problem><mutex>false</mutex></option><option><id>104</id><topicId>20</topicId><optionsname>选项二</optionsname><img /><instruction>选项二选项说明文字</instruction><score>2</score><problem>5</problem><mutex>false</mutex></option></option><qid>1</qid><attr /><options /><aid /><optionsnmae /></topic><topic><id>21</id><bark>21</bark><topicname>第二题</topicname><img /><instruction>第二题提干说明文字</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><option><option><id>105</id><topicId>21</topicId><optionsname>选项一</optionsname><img /><instruction /><score>2</score><problem>6</problem><mutex>false</mutex></option><option><id>106</id><topicId>21</topicId><optionsname>选项二</optionsname><img /><instruction /><score>5</score><problem>1</problem><mutex>false</mutex></option></option><qid>2</qid><attr><attr><id>27</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic><topic><id>22</id><bark>22</bark><topicname>第三题</topicname><img /><instruction>第三题或明文字</instruction><ttname>text</ttname><record>true</record><scaleId>5</scaleId><option><option><id>107</id><topicId>22</topicId><optionsname /><img /><instruction /><score /><problem /><mutex /></option></option><qid>3</qid><attr><attr><id>27</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr><attr><id>28</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic><topic><id>23</id><bark>23</bark><topicname>第四题</topicname><img /><instruction>第四题说明文字</instruction><ttname>checkbox</ttname><record>false</record><scaleId>5</scaleId><option><option><id>108</id><topicId>23</topicId><optionsname>很不满意</optionsname><img /><instruction>选项说明文字</instruction><score>2</score><problem /><mutex>true</mutex></option><option><id>109</id><topicId>23</topicId><optionsname>不满意</optionsname><img /><instruction>选项说明文字</instruction><score>5</score><problem /><mutex>false</mutex></option><option><id>110</id><topicId>23</topicId><optionsname>一般</optionsname><img /><instruction>选项说明文字</instruction><score>4</score><problem /><mutex>false</mutex></option><option><id>111</id><topicId>23</topicId><optionsname>满意</optionsname><img /><instruction>选项说明文字</instruction><score>2</score><problem /><mutex>true</mutex></option><option><id>112</id><topicId>23</topicId><optionsname>很满意</optionsname><img /><instruction>选项说明文字</instruction><score>8</score><problem /><mutex>false</mutex></option></option><qid>4</qid><attr><attr><id>27</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr><attr><id>28</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic><topic><id>24</id><bark>24</bark><topicname>第五题</topicname><img /><instruction>提干说明文字</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><option><option><id>113</id><topicId>24</topicId><optionsname>选项一</optionsname><img /><instruction>选项说明文字</instruction><score>5</score><problem>3</problem><mutex>false</mutex></option><option><id>114</id><topicId>24</topicId><optionsname>选项二</optionsname><img /><instruction>选项说明文字</instruction><score>6</score><problem>4</problem><mutex>false</mutex></option></option><qid>5</qid><attr><attr><id>33</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr><attr><id>31</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic><topic><id>25</id><bark>25</bark><topicname>第六题</topicname><img /><instruction>提干说明文字</instruction><ttname>text</ttname><record>false</record><scaleId>5</scaleId><option><option><id>115</id><topicId>25</topicId><optionsname /><img /><instruction /><score /><problem /><mutex /></option></option><qid>6</qid><attr><attr><id>27</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr><attr><id>28</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic><topic><id>26</id><bark>26</bark><topicname>第七题</topicname><img /><instruction>题干选项文字</instruction><ttname>checkbox</ttname><record>false</record><scaleId>5</scaleId><option><option><id>116</id><topicId>26</topicId><optionsname>1</optionsname><img /><instruction>选项文字说明</instruction><score>6</score><problem /><mutex>true</mutex></option><option><id>117</id><topicId>26</topicId><optionsname>2</optionsname><img /><instruction>选项文字说明</instruction><score>4</score><problem /><mutex>false</mutex></option><option><id>118</id><topicId>26</topicId><optionsname>3</optionsname><img /><instruction>选项文字说明</instruction><score>2</score><problem /><mutex>false</mutex></option><option><id>119</id><topicId>26</topicId><optionsname>4</optionsname><img /><instruction>选项文字说明</instruction><score>6</score><problem /><mutex>false</mutex></option><option><id>120</id><topicId>26</topicId><optionsname>5</optionsname><img /><instruction>选项文字说明</instruction><score>7</score><problem /><mutex>true</mutex></option></option><qid>7</qid><attr><attr><id>28</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr><attr><id>29</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic><topic><id>27</id><bark>27</bark><topicname>第八题</topicname><img /><instruction>提干文字说明</instruction><ttname>checkbox</ttname><record>false</record><scaleId>5</scaleId><option><option><id>121</id><topicId>27</topicId><optionsname>很不同意</optionsname><img /><instruction>选项文字说明</instruction><score>3</score><problem /><mutex>true</mutex></option><option><id>122</id><topicId>27</topicId><optionsname>不同意</optionsname><img /><instruction>选项文字说明</instruction><score>4</score><problem /><mutex>false</mutex></option><option><id>123</id><topicId>27</topicId><optionsname>一般</optionsname><img /><instruction>选项文字说明</instruction><score>2</score><problem /><mutex>true</mutex></option><option><id>124</id><topicId>27</topicId><optionsname>同意</optionsname><img /><instruction>选项文字说明</instruction><score>6</score><problem /><mutex>false</mutex></option><option><id>125</id><topicId>27</topicId><optionsname>很同意</optionsname><img /><instruction>选项文字说明</instruction><score>4</score><problem /><mutex>false</mutex></option></option><qid>8</qid><attr /><options /><aid /><optionsnmae /></topic><topic><id>28</id><bark>28</bark><topicname>第九题</topicname><img /><instruction>提干文字说明</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><option><option><id>126</id><topicId>28</topicId><optionsname>选项一</optionsname><img /><instruction>选项文字说明</instruction><score>2</score><problem>10</problem><mutex>false</mutex></option><option><id>127</id><topicId>28</topicId><optionsname>选项二</optionsname><img /><instruction>选项文字说明</instruction><score>3</score><problem>11</problem><mutex>false</mutex></option></option><qid>9</qid><attr><attr><id>29</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr><attr><id>31</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic><topic><id>29</id><bark>29</bark><topicname>第十题</topicname><img /><instruction>提干文字说明</instruction><ttname>text</ttname><record>false</record><scaleId>5</scaleId><option><option><id>128</id><topicId>29</topicId><optionsname /><img /><instruction /><score /><problem /><mutex /></option></option><qid>10</qid><attr /><options /><aid /><optionsnmae /></topic><topic><id>30</id><bark>30</bark><topicname>第十一体</topicname><img /><instruction>提干文字说明</instruction><ttname>text</ttname><record>true</record><scaleId>5</scaleId><option><option><id>129</id><topicId>30</topicId><optionsname /><img /><instruction /><score /><problem /><mutex /></option></option><qid>11</qid><attr><attr><id>29</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic><topic><id>31</id><bark>31</bark><topicname>第十二题</topicname><img /><instruction>提干文字说明</instruction><ttname>checkbox</ttname><record>false</record><scaleId>5</scaleId><option><option><id>130</id><topicId>31</topicId><optionsname>1</optionsname><img /><instruction>选项文字说明</instruction><score>5</score><problem /><mutex>true</mutex></option><option><id>131</id><topicId>31</topicId><optionsname>2</optionsname><img /><instruction>选项文字说明</instruction><score>3</score><problem /><mutex>false</mutex></option><option><id>132</id><topicId>31</topicId><optionsname>3</optionsname><img /><instruction>选项文字说明</instruction><score>2</score><problem /><mutex>false</mutex></option><option><id>133</id><topicId>31</topicId><optionsname>4</optionsname><img /><instruction>选项文字说明</instruction><score>5</score><problem /><mutex>false</mutex></option><option><id>134</id><topicId>31</topicId><optionsname>5</optionsname><img /><instruction>选项文字说明</instruction><score>3</score><problem /><mutex>true</mutex></option></option><qid>12</qid><attr><attr><id>33</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr><attr><id>29</id><bark /><topicname /><img /><instruction /><ttname /><record /><scaleId /><qid>0</qid><options /><aid /><optionsnmae /></attr></attr><options /><aid /><optionsnmae /></topic></catalog>";
		map.put("wording", "<List><item><id>5</id><scalename>MMSE简易智能精神状态检查量表</scalename><name/><time/><topiccount/><introduce/><guide/><age/><test/><aid>1</aid><topic><topic><id>20</id><bark>20</bark><topicname>现在是哪一年？</topicname><img/><instruction/><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5643</id><topicId>20</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5644</id><topicId>20</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>1</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>21</id><bark>21</bark><topicname>现在是什么季节？</topicname><img/><instruction/><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5645</id><topicId>21</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5646</id><topicId>21</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>3</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>31</id><bark>21</bark><topicname>请您计算以下题目，从100中减去7等于多少？再减7？再减7？再减7？再减7？</topicname><img/><instruction>要求病人从100开始减7，之后再减7，一直减5次（即93，86，79，72，65）。每答对1个得1分，如果前次错了，但下一个答案是对的，也得1分（例如第一次 100-7，回答为92，但再减7，回答为85 ，也得1分）。</instruction><ttname>checkbox</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5647</id><topicId>31</topicId><optionsname>“100-7”计算正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5648</id><topicId>31</topicId><optionsname>“第二次减7”计算正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5649</id><topicId>31</topicId><optionsname>“第三次减7”计算正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5650</id><topicId>31</topicId><optionsname>“第四次减7”计算正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5651</id><topicId>31</topicId><optionsname>“第五次减7”计算正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5652</id><topicId>31</topicId><optionsname>全部计算错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>3</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>22</id><bark>22</bark><topicname>现在是几月份？</topicname><img/><instruction/><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5655</id><topicId>22</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5656</id><topicId>22</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>4</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>23</id><bark>23</bark><topicname>今天是几号？</topicname><img/><instruction/><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5657</id><topicId>23</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5658</id><topicId>23</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>5</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>24</id><bark>24</bark><topicname>今天是星期几？</topicname><img/><instruction/><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5659</id><topicId>24</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5660</id><topicId>24</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>6</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>25</id><bark>25</bark><topicname>这是什么城市（城市名）？</topicname><img/><instruction/><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5661</id><topicId>25</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5662</id><topicId>25</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>7</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>26</id><bark>26</bark><topicname>这是什么区（城区名）？</topicname><img/><instruction>如能回答出就诊医院在本地的哪个方位也可。如为外地患者，则可问患者家在当地的哪个方位。</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5663</id><topicId>26</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5664</id><topicId>26</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>8</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>27</id><bark>27</bark><topicname>这是什么街道？</topicname><img/><instruction>如为外地患者，则可问患者家在当地的哪个方位。</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5665</id><topicId>27</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5666</id><topicId>27</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>9</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>28</id><bark>28</bark><topicname>这是第几层楼？</topicname><img/><instruction/><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5667</id><topicId>28</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5668</id><topicId>28</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>10</qid><attr><attr><id>37</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>29</id><bark>29</bark><topicname>这是什么地方？</topicname><img/><instruction/><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5669</id><topicId>29</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5670</id><topicId>29</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>11</qid><attr><attr><id>38</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>30</id><bark>30</bark><topicname>现在我告诉您三个名词，我说完后请您重复一遍。（名词见‘操作说明’）</topicname><img/><instruction>告诉被测试者您将问几个问题来检查他/她的记忆力，然后缓慢说出3个相互无关的东西的名称，大概一秒一个；说完所有的3个名称之后，要求被测试者重复它们。如果他们没能完全记住，您可以重复，但重复的次数不能超过5次。如果5次后他们仍未记住所有的3个名称，那么对于回忆能力的检查就没有意义了。（请跳过第13题“回忆能力”检查）。无顺序要求。 A 词=皮球、B词=苹果、C词=树木</instruction><ttname>checkbox</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5671</id><topicId>30</topicId><optionsname>A词正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5672</id><topicId>30</topicId><optionsname>B词正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5673</id><topicId>30</topicId><optionsname>C词正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5674</id><topicId>30</topicId><optionsname>全错</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>12</qid><attr><attr><id>39</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>32</id><bark>32</bark><topicname>现在请您说出刚才我让您记住的是哪三样东西。（提示：如第11题记忆力测评回答未全正确，则这题无需测评，直接记为全错）</topicname><img/><instruction>A词=皮球、B词=苹果、C词=树木。如果第11题记忆力测评中被测试者完全记住了3个名称，现在就让他们再重复一遍。每正确重复1个得1分。最高3分。顺序不做要求。</instruction><ttname>checkbox</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5675</id><topicId>32</topicId><optionsname>A词正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5676</id><topicId>32</topicId><optionsname>B词正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5677</id><topicId>32</topicId><optionsname>C词正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5678</id><topicId>32</topicId><optionsname>全错</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>13</qid><attr><attr><id>40</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>33</id><bark>33</bark><topicname>请告诉我您现看到的图面上物体是什么</topicname><img>http://test.rehab.66nao.com/static/images/assess/image/mmse/MMSEwatch.jpg</img><instruction>展示手表图片给测试者看，要求他们说出这是什么。</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5679</id><topicId>33</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5680</id><topicId>33</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>14</qid><attr><attr><id>42</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>34</id><bark>34</bark><topicname>请告诉我您现看到的图面上物体是什么</topicname><img>http://test.rehab.66nao.com//static/images/assess/image/mmse/MMSEpencle.jpg</img><instruction>展示铅笔图片给测试者看，要求他们说出这是什么。</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5681</id><topicId>34</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5682</id><topicId>34</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>15</qid><attr><attr><id>42</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>35</id><bark>35</bark><topicname>注意听我说的话，请将它重复一遍。（见“操作说明”）</topicname><img/><instruction>要求被测试者注意他听到的话并重复一次，注意只允许重复一次。这句话是“四十四只石狮子”，只有正确，咬字清楚的才记1分。</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5683</id><topicId>35</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5684</id><topicId>35</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>16</qid><attr><attr><id>43</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>36</id><bark>36</bark><topicname>我给您一张纸，请您按我说的去做，现在开始。 （注意不要重复或者示范；动作指示见‘操作说明’）</topicname><img/><instruction>给被测试者一张空白的平纸，要求对方按您的命令去做，注意不要重复或示范。只有他们按正确顺序做的动作才算正确，每个正确动作计1分。 动作指示： 1、用右手拿着张纸； 2、用两只手将它对折起来； 3、放在您的左腿上。</instruction><ttname>checkbox</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5685</id><topicId>36</topicId><optionsname>第一个动作正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5686</id><topicId>36</topicId><optionsname>第二个动作正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5687</id><topicId>36</topicId><optionsname>第三个动作正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5688</id><topicId>36</topicId><optionsname>全部错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>17</qid><attr><attr><id>44</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>37</id><bark>37</bark><topicname>请您阅读一下这句话，并根据这句话的意思去做。</topicname><img>http://test.rehab.66nao.com/static/images/assess/image/mmse/MMSEcloseeye.png</img><instruction>点击“闭上您的眼睛”图片给被测试者看，要求被测试者读它并按要求去做。只有他们确实闭上眼睛才能得分。</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5689</id><topicId>37</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5690</id><topicId>37</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>18</qid><attr><attr><id>45</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>38</id><bark>38</bark><topicname>请在白纸上写一句完整的句子（需包含主语、动词，并有意义）。</topicname><img/><instruction>给被测试者一张白纸，让他们自发的写出一句完整的句子。句子必须有主语、动词，并有意义。注意您不能给予任何提示。语法和标点的错误可以忽略。</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5691</id><topicId>38</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5692</id><topicId>38</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>19</qid><attr><attr><id>46</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic><topic><id>39</id><bark>39</bark><topicname>请根据您看到的图片，在白纸上画出相同的形状。</topicname><img>http://test.rehab.66nao.com/static/images/assess/image/mmse/MMSEpentagon.jpg</img><instruction>给被测试者一张白纸，要求被测试者照样准确地画出来。评分标准：五边形需画出5个清楚地角和5个边。同时，两个五边形交叉处形成菱形。线条的抖动和图形的旋转可以忽略。</instruction><ttname>radio</ttname><record>false</record><scaleId>5</scaleId><context/><option><option><id>5693</id><topicId>39</topicId><optionsname>正确</optionsname><img/><instruction/><score>1</score><problem/><mutex/></option><option><id>5694</id><topicId>39</topicId><optionsname>错误</optionsname><img/><instruction/><score>0</score><problem/><mutex/></option></option><qid>20</qid><attr><attr><id>47</id><bark/><topicname/><img/><instruction/><ttname/><record/><scaleId/><context/><qid>0</qid><options/><aid/><optionsnmae/></attr></attr><options/><aid/><optionsnmae/></topic></topic><total/><scaleId/><userId/><top/><scoring/><topicid/><problem/><current/></item></List>");
		map.put("name", "MMSE简易智能精神状态检查量表");
		//map.put("wording", data);
		map.put("desc", "");
		String param = JSONUtils.toJSONString(map);
		
		String json = HttpClientUtil.doPostJson("http://dev-assessment-hub.66nao.com/api/v2/assessment/scales/", param);
		System.out.println(json);
	}
 
	

	
}
