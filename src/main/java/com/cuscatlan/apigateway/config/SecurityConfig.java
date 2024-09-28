package com.cuscatlan.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Security configuration class for the API Gateway.
 * <p>
 * This class configures security settings for the API Gateway using Spring Security.
 * It specifies which endpoints are publicly accessible and which require authentication.
 * </p>
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for incoming HTTP requests.
     *
     * @param http the ServerHttpSecurity instance used to configure security settings
     * @return a SecurityWebFilterChain object that defines the security configuration
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/public/**").permitAll()
                        .pathMatchers(
                                "/api/v1/products/**",
                                "/api/v1/orders/**",
                                "/api/v1/payments/**"
                        )
                        .authenticated() 
                        .anyExchange().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .build();
    }
}
