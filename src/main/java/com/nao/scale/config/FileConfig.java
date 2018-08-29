package com.nao.scale.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {
	 @Bean  
	    public MultipartConfigElement multipartConfigElement() {  
	        MultipartConfigFactory factory = new MultipartConfigFactory();  
	        //单个文件最大  
	        factory.setMaxFileSize("10240KB"); //KB,MB  
	        /// 设置总上传数据总大小  
	        factory.setMaxRequestSize("102400KB");  
	        return factory.createMultipartConfig();  
	    }  
}
