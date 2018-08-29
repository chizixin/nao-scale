package com.nao.scale.service.impl;

import com.nao.scale.pojo.User;
import com.nao.scale.service.UserService;
import com.nao.scale.mapper.UserMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zx
 * @since 2017-09-08
 */
@Service
public class UserServiceImap extends ServiceImpl<UserMapper, User> implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	 private static String regex ="[\u4e00-\u9fa5]";
	
	@Override
	public int insertUser(User user) {
		//判断用户名和手机号(必填)
		if(user.getPhone()!=null && user.getAge()!=null){
			String age = user.getAge();
			//取出--年
			String[] split = age.split(",");
				//获取当前年份
				Calendar now = Calendar.getInstance();
				 int i = now.get(Calendar.YEAR);
				//字符串去汉字
				 Pattern pattern = Pattern.compile(regex);
				 Matcher matcher = pattern.matcher(split[0]);
				 String replaceAll = matcher.replaceAll("");
				 int a = Integer.parseInt(replaceAll);
				 int bir = i-a;
				 user.setBir(bir);
			userMapper.insertUser(user);
			Integer id = user.getId();
			return id;
		}else{
			return 0;
		}
	}
	
	
}
