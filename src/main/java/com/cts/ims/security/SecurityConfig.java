package com.cts.ims.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Autowired
	public void configureGloble(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password")).roles("USER")
				.and().withUser("admin").password(passwordEncoder().encode("password")).roles("USER","ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/rawmaterial/getById/**","/user/getuser/**").hasRole("USER")
				.antMatchers("/user/add","/rawmaterial/add").hasRole("ADMIN")
				.antMatchers("/**").hasRole("ADMIN").and().csrf().disable()
				.headers().frameOptions().disable();
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests()
	 * .antMatchers("/rawmaterial/getById/**","/user/getuser/**").permitAll()
	 * .antMatchers("/add","/update","/remove/**").hasRole("ADMIN")
	 * .anyRequest().authenticated() .and().httpBasic(); }
	 */

}
