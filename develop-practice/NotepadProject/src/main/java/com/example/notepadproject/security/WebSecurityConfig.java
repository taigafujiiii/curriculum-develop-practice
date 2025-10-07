package com.example.notepadproject.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	/*フォームの値を暗号化する
    @Bean
    PasswordEncoder passwordEmcoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login   
        		.loginProcessingUrl("/loginDone")
        		.loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll()
            ).logout(logout -> logout
            	.logoutSuccessUrl("/login")	 
        	).authorizeHttpRequests(authz -> authz
        		.requestMatchers("/login", "/registration", "/addUser", "/css/**", "/javascript/**").permitAll()
        		.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                .anyRequest().authenticated())
        .csrf(csrf -> csrf
                .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
        .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
        	);
        return http.build();
	}
}
