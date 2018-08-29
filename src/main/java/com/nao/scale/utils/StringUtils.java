package com.nao.scale.utils;

import java.lang.reflect.Field;
import java.util.List;

public class StringUtils {
	/** 
     * 判断字符串是否为空 
     * @param str 
     * @return 
     */  
    public static boolean isEmpty(String str){  
        return (str == null || "".equals(str.trim()));  
    }  
      
    /** 
     * 获取名称后缀 
     * @param name 
     * @return 
     */  
    public static String getExt(String name){  
        if(name == null || "".equals(name) || !name.contains("."))  
            return "";  
        return name.substring(name.lastIndexOf(".")+1);  
    }  
    
    
    
    public static String listToString(List<?> list) {
        // 变量
        StringBuffer str = new StringBuffer();
        // 前提条件
        if (null == list || 0 == list.size() || null == list.get(0)) {
            return null;
        }
        // class对象
        Class<?> classType = list.get(0).getClass();
        // 此JavaBean中所声明的所有字段
        Field[] fields = classType.getDeclaredFields();
        // 循环
        for (int i = 0; i < list.size(); i++) {
            // 拼接每一个对象的每一个字段
            for (Field field : fields) {
                field.setAccessible(true);
                Object fieldValue;
                // 得到指定对象上此 Field 表示的字段的值
                try {
                    fieldValue = field.get(list.get(i));
                    // 前（对象-1）个对象字段的拼接
                    str.append(fieldValue).append("|");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            str.append("|");
        }
        // str.deleteCharAt(str.length() -1);
        // str.deleteCharAt(str.length() - 1);
        str.delete(str.length() - 2, str.length());
        // 转换成字符串
        return str.toString();

    }
}
