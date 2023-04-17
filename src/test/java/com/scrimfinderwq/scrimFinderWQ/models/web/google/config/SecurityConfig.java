package com.scrimfinderwq.scrimFinderWQ.models.web.google.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = false)
public class SecurityConfig {

    private final OAuth2AuthorizedClientService authorizedClientService;

    public SecurityConfig(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().cors().disable().authorizeHttpRequests()
                .requestMatchers("/**", "/oauth2/callback/google").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .authorizedClientService(authorizedClientService)
                .and().exceptionHandling().accessDeniedPage("/unauthorized");

        return http.build();
    }


}