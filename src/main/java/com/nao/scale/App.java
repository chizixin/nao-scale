package com.nao.scale;
 import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringBoot
 * 
 *
 */
@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.nao.scale"})
@EnableSwagger2
public class App extends SpringBootServletInitializer {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
		app.setBannerMode(Mode.CONSOLE);
		//SpringApplication.run(Swagger2.class, args);
		app.run(App.class, args);
		//SpringApplication.run(App.class, args);
	}

	/**
	 * 部署Tomcat
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(App.class);
	}
 
	
	
}
