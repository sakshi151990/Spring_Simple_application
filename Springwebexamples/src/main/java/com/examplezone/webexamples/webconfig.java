package com.examplezone.webexamples;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.examplezone.webexamples")
public class webconfig extends WebMvcConfigurerAdapter{

	public ViewResolver viewresolver()
	{
		InternalResourceViewResolver viewrsolve=new InternalResourceViewResolver();
		viewrsolve.setPrefix("/WEB-INF/views");
		viewrsolve.setSuffix(".html");
		
		return viewrsolve;
		
		
	}
	
	@Override
	public void configureDefaultServletHandling(
	DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
	
}
