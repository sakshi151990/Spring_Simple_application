package com.GKquiz;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan("com.web")
@EnableWebMvc
public class webConfig extends WebMvcConfigurerAdapter{

	
	@Bean
	public ViewResolver viewresolver()
	{
		InternalResourceViewResolver viewresolver=new InternalResourceViewResolver();
		viewresolver.setSuffix(".jsp");
		viewresolver.setPrefix("/WEB-INF/view/");
		return viewresolver;
		
	}
	
	@Bean
	
		    ServletRegistrationBean h2servletRegistration(){
	
		        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
	
		        registrationBean.addUrlMappings("/console/*");
	
		        return registrationBean;
	    }
	
		
	@Override
	public void configureDefaultServletHandling(
	DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
}
