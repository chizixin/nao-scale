package com.nao.scale.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 年龄工具类
 * @author 张鑫
 * 描述:
 * 时间:
 */
public class AgeUtil {
	/**
	 * 方法描述:根据年龄的字符串返回一个Int   年龄
	 * @param birthday
	 * @return
	 *
	 */
	 public static int getAgeByBirth(String birthday) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        int age = 0;
        try {
        	Date date = format.parse(birthday);
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(date);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
           return 0;
        }
    }
	 /**
	  * 描述:根据一个格式为："1993-05"  的生日返回一个年龄
	  * 2017年6月19日下午4:46:36
	  * int
	  * @param birthday
	  * @return
	  * @Author:候其俊
	  */
	 public static int getAgeByBirthday(String birthday){
		 String[] birth = birthday.split("-");
		 Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		 	int year = c.get(Calendar.YEAR);//获取当前年
		 if(Integer.parseInt(birth[1])>=6){
			return year-Integer.parseInt(birth[0])+1;
		 }else{
			 return year-Integer.parseInt(birth[0]);
		 }
	 }
	 public static Integer getPackagevaId(String birthday){
		 int age = getAgeByBirthday(birthday);
		 if(age>17 && age <=44){
			 return 1;
		 }else if(age >44 && age <=59){
			 return 2;
		 }else if(age >59){
			 return 3;
		 }
		return null;
	 }
	public static void main(String[] args) {
		Integer id = getPackagevaId("1990-02");
		System.out.println(id);
	}
}
