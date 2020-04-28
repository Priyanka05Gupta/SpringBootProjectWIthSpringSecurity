package com.lti.springsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * Let’s now configure custom users and roles We will use two roles Admin and User
	 * 1) Admin role has access to the web application and User role has access to execute REST Services. 
	 * 2)We will create one user for Admin role with credentials admin1/secret1
	 * 3)We will create one user for User role with credentials user1/secret1
	 */
	 
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
				.withUser("user1").password("secret1")
				.roles("USER").and().withUser("admin1").password("secret1")
				.roles("USER", "ADMIN");
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/students/**")
				.hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
				.csrf().disable().headers().frameOptions().disable();
	}

}
