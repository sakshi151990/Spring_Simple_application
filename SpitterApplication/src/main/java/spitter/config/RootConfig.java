package spitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import spitter.data.SpittleRepository;
import spitter.data.SpittleRepositoryIML;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"spitter"},excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {

	@Bean
	public SpittleRepository spittleRepository()
	{
		return new SpittleRepositoryIML();
	}
}
