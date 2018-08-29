package com.nao.scale.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.nao.scale.baidu.ueditor.ActionEnter;
import com.nao.scale.baidu.ueditor.ConfigManager;
import com.nao.scale.baidu.ueditor.UEditorConfig;

import java.util.List;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;

/**
 * Created by pangxiaofeng on 2017/6/17.
 */
@Configuration
@EnableConfigurationProperties(UEditorConfig.class)
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private UEditorConfig uEditorConfig;

    @Bean
    @ConditionalOnMissingBean(ActionEnter.class)
    public ActionEnter actionEnter() {
        ActionEnter actionEnter = new ActionEnter(ConfigManager.getInstance(uEditorConfig));
        return actionEnter;
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + uEditorConfig.getUploadPath());
        registry.addResourceHandler("/statics/**").addResourceLocations("/statics/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/upload/**").addResourceLocations("/upload/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
    /**
	 * 文件上传配置
	 * 
	 * @return MultipartConfigElement
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
		factory.setMaxFileSize("10MB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("20MB"); 
		// Sets the directory location where files will be stored.
		// factory.setLocation("路径地址");
		return factory.createMultipartConfig();
	}
    /**
     * 用于处理编码问题
     *
     * @return
     */
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      super.configureMessageConverters(converters);
   
      // 初始化转换器
      FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
      // 初始化一个转换器配置
      FastJsonConfig fastJsonConfig = new FastJsonConfig();
      fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
      // 将配置设置给转换器并添加到HttpMessageConverter转换器列表中
      fastConvert.setFastJsonConfig(fastJsonConfig);
   
      converters.add(fastConvert);
    }

}