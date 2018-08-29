package com.nao.scale.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/**
 * @author User
 *	发送手机短信工具类
 */
public class SendPhoneMessageUtil{
	 public static final String DEF_CHATSET = "UTF-8";
	    public static final int DEF_CONN_TIMEOUT = 30000;
	    public static final int DEF_READ_TIMEOUT = 30000;
	    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
		
	    //2.发送注册短信
	    public static String getRequest2(String phone,String code){
	        String result =null;
	        try {
	        	String url = "http://send.18sms.com/msg/HttpBatchSendSM";//请求接口地址
		        Map params = new HashMap();//请求参数
				params.put("account", "Mj1t9m5"); //用户产品账号  短信 语音 国际 不同验证码 换不同账号即可
	            params.put("pswd", "6Qv3If7Xm5");//用户产品密码
	            params.put("mobile", phone); //手机号码 多手机号用逗号分隔如 13300000000,13200000000
	            params.put("msg", "您好，您的注册验证码是："+code+"，请在15分钟内完成输入。如非本人操作，请忽略！【六六脑】");//必填参数。短信内容(内容后面必须要带上签名如:[示远科技])
	            params.put("needstatus", "true");//是否需要状态报告，取值true或false，true，表明需要状态报告；false不需要状态报告 needstatus参数需要等于true才会返回msgid
	            params.put("product", "");//可选参数。用户订购的产品id，不填写（针对老用户）系统采用用户的默认产品，用户订购多个产品时必填，否则会发生计费错误。
	            result = net(url, params, "POST");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return result;
	    }
	    //2.发送修改密码短信
	    public static String getRequest3(String phone,String code){
	        String result =null;
	        try {
		        String url = "http://send.18sms.com/msg/HttpBatchSendSM";//请求接口地址
		        Map params = new HashMap();//请求参数
				params.put("account", "Mj1t9m5"); //用户产品账号  短信 语音 国际 不同验证码 换不同账号即可
	            params.put("pswd", "6Qv3If7Xm5");//用户产品密码
	            params.put("mobile", phone); //手机号码 多手机号用逗号分隔如 13300000000,13200000000
	            params.put("msg", "您好，您正在进行密码重置校验，验证码："+code+"，请在15分钟内完成输入。请勿泄露给他人，如非本人操作，请忽略！【六六脑】");//必填参数。短信内容(内容后面必须要带上签名如:[示远科技])
	            params.put("needstatus", "true");//是否需要状态报告，取值true或false，true，表明需要状态报告；false不需要状态报告 needstatus参数需要等于true才会返回msgid
	            params.put("product", "");//可选参数。用户订购的产品id，不填写（针对老用户）系统采用用户的默认产品，用户订购多个产品时必填，否则会发生计费错误。
	            result = net(url, params, "POST");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return result;
	    }
	 
	 
	    public static void main(String[] args) {
	    		
	    }
	 
	    /**
	     *
	     * @param strUrl 请求地址
	     * @param params 请求参数
	     * @param method 请求方法
	     * @return  网络请求字符串
	     * @throws Exception
	     */
	    public static String net(String strUrl, Map params,String method) throws Exception {
	        HttpURLConnection conn = null;
	        BufferedReader reader = null;
	        String rs = null;
	        try {
	            StringBuffer sb = new StringBuffer();
	            if(method==null || method.equals("GET")){
	                strUrl = strUrl+"?"+urlencode(params);
	            }
	            URL url = new URL(strUrl);
	            conn = (HttpURLConnection) url.openConnection();
	            if(method==null || method.equals("GET")){
	                conn.setRequestMethod("GET");
	            }else{
	                conn.setRequestMethod("POST");
	                conn.setDoOutput(true);
	            }
	            conn.setRequestProperty("User-agent", userAgent);
	            conn.setUseCaches(false);
	            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
	            conn.setReadTimeout(DEF_READ_TIMEOUT);
	            conn.setInstanceFollowRedirects(false);
	            conn.connect();
	            if (params!= null && method.equals("POST")) {
	                try {
	                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
	                        out.writeBytes(urlencode(params));
	                } catch (Exception e) {
	                    // TODO: handle exception
	                }
	            }
	            InputStream is = conn.getInputStream();
	            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
	            String strRead = null;
	            while ((strRead = reader.readLine()) != null) {
	                sb.append(strRead);
	            }
	            rs = sb.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                reader.close();
	            }
	            if (conn != null) {
	                conn.disconnect();
	            }
	        }
	        return rs;
	    }
	 
	    //将map型转为请求参数型
	    public static String urlencode(Map<String,Object>data) {
	        StringBuilder sb = new StringBuilder();
	        for (Map.Entry i : data.entrySet()) {
	            try {
	                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
	            } catch (UnsupportedEncodingException e) {
	                e.printStackTrace();
	            }
	        }
	        return sb.toString();
	    }
	    /**
	     * 随机生成6位随机验证码
	      * 方法说明
	      * @Discription:扩展说明
	      * @return
	      * @return String
	      * @Author: feizi
	      * @Date: 2015年4月17日 下午7:19:02
	      * @ModifyUser：feizi
	      * @ModifyDate: 2015年4月17日 下午7:19:02
	     */
	    public static String createRandomVcode(){
	        //验证码
	    	int m = (int)((Math.random()*9+1)*100000);
	    	return m+"";
	    }
}
