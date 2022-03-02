package com.generation.iroomiedb;

import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.generation.iroomiedbjwt.config.JwtFilter;

@SpringBootApplication
public class IRoomiedbApplication {

	public static void main(String[] args) {
		SpringApplication.run(IRoomiedbApplication.class, args);
	}//main
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<>();
		registrationBean.setFilter( new JwtFilter());
		registrationBean.addUrlPatterns("/api/user/*");
		registrationBean.addUrlPatterns("/api/propiedades/*");
		return registrationBean;
	} // jwtFilter


}//class
