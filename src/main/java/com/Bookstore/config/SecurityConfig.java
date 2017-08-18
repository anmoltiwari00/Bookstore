package com.Bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Bookstore.Service.impl.UserSecurityService;
import com.Bookstore.Utility.SecurityUtility;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	public BCryptPasswordEncoder cryptPasswordEncoder() {
		return SecurityUtility.passwordEncoder();
	}
	
	public static final String[] urlMatchers =  {"/css/**", "/js/**", "/image/**", "/","/myAccount"};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers(urlMatchers).permitAll().anyRequest().authenticated();
		http.formLogin().failureUrl("/login?error").defaultSuccessUrl("/").loginPage("/login").permitAll()
		.and()
		.logout().logoutSuccessUrl("/?logout").deleteCookies("remeber-me").permitAll().and().rememberMe();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userSecurityService).passwordEncoder(cryptPasswordEncoder());
	}
		
	

}
