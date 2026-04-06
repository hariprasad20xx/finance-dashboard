package com.finance.dashboard.config;

import com.finance.dashboard.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/h2-console/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/records").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/records/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/records/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/records/filter").hasAnyRole("ADMIN", "ANALYST")
                        .requestMatchers(HttpMethod.GET, "/dashboard").hasAnyRole("ADMIN", "ANALYST")

                        .requestMatchers(HttpMethod.GET, "/records").hasAnyRole("ADMIN", "ANALYST", "VIEWER")

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}