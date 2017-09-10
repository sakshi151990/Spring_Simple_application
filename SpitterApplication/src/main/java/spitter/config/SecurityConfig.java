package spitter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter 	{
 public void configure(AuthenticationManagerBuilder auth) throws Exception
 {//with user will add the below users in inmemory user store
	 auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("ADMIN").password("password").roles("USER","ADMIN");
 }
 protected void configure(HttpSecurity http) throws Exception {
 http.csrf().disable()
 .authorizeRequests()
 .antMatchers("/spitter/me").hasRole("SPITTER")
 .antMatchers("/spittlesui/").permitAll()
 .anyRequest().permitAll().and()
 .requiresChannel()
 .antMatchers("/spitter/form").requiresSecure().and().formLogin().loginPage("/login.html");
 }}

