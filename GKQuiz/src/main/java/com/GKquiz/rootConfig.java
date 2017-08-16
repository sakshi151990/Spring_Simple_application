package com.GKquiz;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.data.Questions;
import com.data.User;
import com.data.mailproperties;
import com.data.resultmailservice;
import com.data.userRoles;
import com.data.userresult;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableConfigurationProperties(mailproperties.class)
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
	public userRoles getUserRoles()
	{
		return new userRoles();
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
/*	
	@Bean
	public DataSource dataSource() {
	return new EmbeddedDatabaseBuilder()
	.setType(EmbeddedDatabaseType.H2)
		.build();

}*/
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{LocalSessionFactoryBean sessionfactory=new LocalSessionFactoryBean();
	sessionfactory.setDataSource(getdatasource());
	sessionfactory.setAnnotatedClasses(User.class);
	sessionfactory.setAnnotatedClasses(userresult.class);
	sessionfactory.setAnnotatedClasses(Questions.class);
	sessionfactory.setAnnotatedClasses(userRoles.class);
	sessionfactory.setPackagesToScan("com.data");
	Properties props = new Properties();
	props.setProperty("dialect", "org.hibernate.dialect.H2Dialect"); 
	sessionfactory.setHibernateProperties(props);
		return sessionfactory;
		
	}
	
	//@Bean
	
	public MailSender mailSender(Environment env) {
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);
    mailSender.setUsername("sakshikansal08@gmail.com");
    mailSender.setPassword("motu0107");
     
    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");
     
	return mailSender;
	}
	
//	@Bean
	public resultmailservice getmailservice()
	{
		return new resultmailservice();
	}
	
}
