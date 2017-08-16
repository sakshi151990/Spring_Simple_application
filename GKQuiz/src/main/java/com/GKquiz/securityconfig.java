package com.GKquiz;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class securityconfig  extends WebSecurityConfigurerAdapter  {

	@Autowired
	 DataSource datasource;
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{    System.out.println("inside configure");
auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery("select u.NAME,u.PASSWORD,'true' as ENABLED from USER u where u.NAME=?")
	.authoritiesByUsernameQuery("select r.NAME,r.ROLE from USER_ROLES r where r.NAME=?");

	// auth.inMemoryAuthentication().withUser("user").password("password").authorities("ROLE_USER").and().withUser("ADMIN").password("password").authorities("ROLE_USER","ROLE_ADMIN");
	}
	
	
	protected void configure(HttpSecurity http) throws Exception{
		  
		http.authorizeRequests()
		.antMatchers("/welcome").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
		.antMatchers(HttpMethod.GET,"/adminpage").access("hasRole('ROLE_ADMIN')")
		.and().formLogin().loginPage("/login").failureUrl("/login")
		.usernameParameter("name").passwordParameter("password").defaultSuccessUrl("/welcome").and().logout().logoutSuccessUrl("/logout");
		http.csrf().disable();
	}


}