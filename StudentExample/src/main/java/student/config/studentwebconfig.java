package student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("student.web")
public class studentwebconfig extends WebMvcConfigurerAdapter{

	
	@Bean
	public ViewResolver viewresolver()
	{
		InternalResourceViewResolver viewrsolve=new InternalResourceViewResolver();
		viewrsolve.setPrefix("/WEB-INF/views/");
		viewrsolve.setSuffix(".jsp");
		
		return viewrsolve;
		
		
	}
	
	@Override
	public void configureDefaultServletHandling(
	DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
	
	
}
