package com.zarlok.webshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DataSource securityDataSource;

    @Autowired
    public SecurityConfig(@Qualifier("securityDataSource") DataSource securityDataSource){
        this.securityDataSource = securityDataSource;
    }

    @Bean
    public UserDetailsManager userDetailsManager(){return new JdbcUserDetailsManager(securityDataSource);}


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeRequests(configurer->
                        configurer
                                .antMatchers("/manage/user/**").hasRole("ADMIN")
                                .antMatchers("/manage/product/**").hasRole("ADMIN")
                                .antMatchers("/manage/**").hasRole("ADMIN")
                                .antMatchers("/product/addReview").hasAnyRole("ADMIN", "USER"))
                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer
                                .permitAll(true))
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied"))
                .build();
    }
}

