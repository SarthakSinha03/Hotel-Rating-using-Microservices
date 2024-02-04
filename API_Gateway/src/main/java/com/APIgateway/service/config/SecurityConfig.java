package com.APIgateway.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
//import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebFluxSecurity

public class SecurityConfig {
	
	
    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {

        httpSecurity
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Client()
                .and()
                .oauth2ResourceServer()
                .jwt();


        return httpSecurity.build();


    }
	
	
	
	
	
	/*
	
		
//		 http
//	        .authorizeExchange(exchanges -> exchanges
//	            .anyExchange().authenticated()
//	        )
//	        .httpBasic(withDefaults())
//	        .formLogin(withDefaults());
//	    return http.build();

//		http.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated()).httpBasic(withDefaults())
//				.formLogin(withDefaults());
//		
//		return http.build();
		
//		return http
//				.authorizeExchange()
//					.pathMatchers(HttpMethod.GET, "/posts/**").permitAll()
//	                .pathMatchers(HttpMethod.DELETE, "/posts/**").hasRole("ADMIN")
//					//.pathMatchers("/users/{user}/**").access(this::currentUserMatchesPath)
//					.anyExchange().authenticated()
//					.and()
//				.build();
	}
	*/
}
