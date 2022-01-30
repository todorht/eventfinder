package com.eventsfinder.user.security;

import com.eventsfinder.user.application.service.UserService;
import com.eventsfinder.user.jwt.JwtConfig;
import com.eventsfinder.user.jwt.JwtTokenVerifier;
import com.eventsfinder.user.jwt.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;
    private final UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager(), jwtConfig, secretKey, userService);
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers("api/login")
                        .permitAll()
                    .antMatchers(GET, "/api/event/**", "/")
                        .permitAll()
                    .antMatchers(POST, "/api/event/**")
                        .hasAnyAuthority("ROLE_USER")
                    .anyRequest()
                        .authenticated()
                .and()
                .addFilter(customAuthenticationFilter)
                .addFilterAfter(new JwtTokenVerifier(jwtConfig, secretKey), CustomAuthenticationFilter.class);
    }
}
