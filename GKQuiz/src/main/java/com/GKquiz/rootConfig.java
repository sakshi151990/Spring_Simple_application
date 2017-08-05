package com.GKquiz;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.data.Questions;
import com.data.User;
import com.data.userresult;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages={"com.data","com.web"},excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class rootConfig extends WebMvcConfigurerAdapter {

	@Bean
	public User getUser()
	{
		return new User();
	}
	
	@Bean
	public Questions getQuestionAnswerbean()
	{
		return new Questions();
	}
	
	@Bean
	public userresult getuserresultbean()
	{
		return new userresult();
	}
	
	@Bean
	public DataSource getdatasource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		
		datasource.setUrl("jdbc:h2:~/test;DB_CLOSE_DELAY=-1");
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{LocalSessionFactoryBean sessionfactory=new LocalSessionFactoryBean();
	sessionfactory.setDataSource(getdatasource());
	sessionfactory.setAnnotatedClasses(User.class);
	sessionfactory.setAnnotatedClasses(userresult.class);
	sessionfactory.setAnnotatedClasses(Questions.class);
	sessionfactory.setPackagesToScan("com.data");
	
		return sessionfactory;
		
	}
	
	
}
