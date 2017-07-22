package spitter.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import spitter.data.HibernateSpitterRepository;
import spitter.data.SpittleRepository;
import spitter.data.SpittleRepositoryIML;
import spitter.data.spitterRepository;
import spitter.data.spitterRepositoryIML;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages={"spitter"},excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig {

	@Bean
	public SpittleRepository spittleRepository()
	{
		return new SpittleRepositoryIML();
	}
	
@Bean
	public spitterRepository spitterRepository()
	{
		return new spitterRepositoryIML();
	}


	
	@Bean
	public DataSource dataSource() {
	return new EmbeddedDatabaseBuilder()
	.setType(EmbeddedDatabaseType.H2)
		.build();

}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
	LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
	sfb.setDataSource(dataSource);
	sfb.setMappingResources("Spitter.hbm.xml");
	//sfb.setPackagesToScan(new String[] { "spitter.data" });
	Properties props = new Properties();
	props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
	sfb.setHibernateProperties(props);
	return sfb;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	return new JdbcTemplate(dataSource);
	}
}