package com.github.xenteros.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/login.html", "/hello.html").permitAll()
                .antMatchers("/api/users/login").permitAll()
                .antMatchers("/api/**").authenticated()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/api/users/login")
                .usernameParameter("user")
                .passwordParameter("password")
                .defaultSuccessUrl("/hello.html").permitAll()
                .failureHandler((request, response, exception) -> response.sendError(HttpStatus.BAD_REQUEST.value(), "Username or password invalid"));
    }
}
