package com.thewa.myhealthpal.config;
import com.thewa.myhealthpal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Autowired
	private UserService userService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // To encrypt passwords
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf()
		    .disable()
		    .authorizeHttpRequests()
		    .requestMatchers("/login", "/register")
		    .permitAll() // Allow login and registration
		    .anyRequest()
		    .authenticated() // Protect all other routes
		    .and()
		    .formLogin()
		    .loginPage("/login")
		    .defaultSuccessUrl("/dashboard", true)
		    .permitAll()
		    .and()
		    .logout()
		    .permitAll();
		
		return http.build();
	}
}