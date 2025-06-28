//package rent.history.checker.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	http
//			.authorizeRequests(authorizeRequests ->
//							authorizeRequests
//									.antMatchers("/api/public/**").permitAll()
//									.anyRequest().authenticated()
//							  )
//			.oauth2ResourceServer(oauth2 ->
//							oauth2.jwt(jwt ->
//											jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
//									  )
//								 );
//	return http.build();
//  }
//
//  @Bean
//  public JwtAuthenticationConverter jwtAuthenticationConverter() {
//	return new JwtAuthenticationConverter();
//  }
//}