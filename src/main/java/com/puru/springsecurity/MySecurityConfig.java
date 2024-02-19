package com.puru.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig {

	/*
	 * @Bean UserDetailsService userDetailsService() {
	 * 
	 * InMemoryUserDetailsManager userDetailsService = new
	 * InMemoryUserDetailsManager(); UserDetails user = User.withUsername("Bob")
	 * .password(passwordEncoder().encode("Marley")) .authorities("read").build();
	 * userDetailsService.createUser(user);
	 * 
	 * return userDetailsService;
	 * 
	 * }
	 */

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	/*
	 * BEFORE SPRINGBOOT 3.2
	 * 
	 * @Bean SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
	 * http.httpBasic(); http.authorizeHttpRequests().anyRequest().authenticated();
	 * 
	 * return http.build();
	 * 
	 * }
	 */

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic(Customizer.withDefaults());
		// http.formLogin(Customizer.withDefaults());
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/security").authenticated());
		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);

		return http.build();

	}
}
