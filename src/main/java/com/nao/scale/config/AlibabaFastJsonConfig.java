package com.nao.scale.config;


import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class AlibabaFastJsonConfig {
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		//supportedMediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
		supportedMediaTypes.add(MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8"));
		supportedMediaTypes.add(MediaType.parseMediaType("application/json"));
		fastConverter.setSupportedMediaTypes(supportedMediaTypes);
		AlibabaFastJsonConfig fastJsonConfig = new AlibabaFastJsonConfig();
	//	fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	//	fastConverter.setFastJsonConfig(fastJsonConfig);
		return new HttpMessageConverters(fastConverter);
	}
	
}
