package com.enumtech.ET001FirstSpringboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyWebSecurity// extends WebSecurityConfigurerAdapter
{
//Authentication
//@Override
//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication()
//	.withUser("jetha")
//	.password("jetha123")			// cleartext
//		.authorities("ADMIN") 		//list or roles is known as authorities
//		.and()
//		.withUser("bagha")
//		.password("bagha123")		// cleartext
//		.authorities("USER");
	
//	auth.authenticationProvider(myAuthenticationProvider());  //Single Point of Contact
//}

@Bean
public AuthenticationProvider myAuthenticationProvider() {
	DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
	daoProvider.setUserDetailsService(myUserDetailsService());
	daoProvider.setPasswordEncoder(myPasswordEncoder());
	return daoProvider;
}


@Bean
public PasswordEncoder myPasswordEncoder() {
	return new BCryptPasswordEncoder();
}


@Bean
public UserDetailsService myUserDetailsService() {
	
	return new MyET001UserDetailsService();
}


//Authorisation
//@Override
//	protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests()
//    .antMatchers("/amazon/all-products","/amazon/add-product-form").hasAnyAuthority("USER","ADMIN")
//    .antMatchers("/amazon/update-product-form/**","/amazon/delete-product/**").hasAuthority("ADMIN")
//    .anyRequest().authenticated()
//    .and()
//    .formLogin().loginProcessingUrl("/login").successForwardUrl("/amazon/all-products").permitAll()
//    .and()
//    .logout().logoutSuccessUrl("/login").permitAll()
//    .and()
//    .exceptionHandling().accessDeniedPage("/amazon/403")
//    .and()
//    .cors().and().csrf().disable();
//}





//@Bean
//public PasswordEncoder getPasswordEncoder()
//{
//	return NoOpPasswordEncoder.getInstance();
//}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 
	http.authenticationProvider(myAuthenticationProvider());  //authentication
	
	 http.authorizeRequests()
	    .requestMatchers("/amazon/all-products","/amazon/add-product-form").hasAnyAuthority("USER","ADMIN")
	    .requestMatchers("/amazon/update-product-form/**","/amazon/delete-product/**").hasAuthority("ADMIN")
	    .anyRequest().authenticated()
	    .and()
	    .formLogin().loginProcessingUrl("/login").successForwardUrl("/amazon/all-products").permitAll()
	    .and()
	    .logout().logoutSuccessUrl("/login").permitAll()
	    .and()
	    .exceptionHandling().accessDeniedPage("/amazon/403")
	    .and()
	    .cors().and().csrf().disable();
	 
    return http.build();
}


}
