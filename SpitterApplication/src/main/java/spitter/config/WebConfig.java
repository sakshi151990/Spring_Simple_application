package spitter.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

@Configuration
@EnableWebMvc
@ComponentScan("spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter  {

/*	@Bean
	public ViewResolver viewResolver() {
	InternalResourceViewResolver resolver =
	new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	resolver.setExposeContextBeansAsAttributes(true);
	return resolver;
	}*/
	@Override
	public void configureDefaultServletHandling(
	DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
	TilesConfigurer tiles = new TilesConfigurer();
	tiles.setDefinitions(new String[] {
	"/WEB-INF/layout/tiles.xml"
	});
	tiles.setCheckRefresh(true);
	return tiles;
	}
	
	@Bean
	public ViewResolver viewResolvertiles() {
	return new TilesViewResolver();
	}
	
	@Bean
	public ViewResolver cnViewResolver(ContentNegotiationManager cmm) {
		
		ContentNegotiatingViewResolver cnv= new ContentNegotiatingViewResolver();
		cnv.setContentNegotiationManager(cmm);
	return  cnv;
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer config)
	{
		config.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
	public ViewResolver beanname()
	{
		return new BeanNameViewResolver();
	}
	
	@Bean
	public View spittlesui()

{
	return new MappingJackson2JsonView();
		

}}
