package com.arkiv.sports.referee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.arkiv.sports.referee.service.MongoDbAuthenticationProvider;

/**
 * Created by knalla on 1/21/17.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true )
@Order( SecurityProperties.ACCESS_OVERRIDE_ORDER )
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

    @Autowired
    private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;

    @Autowired
    private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

    @Autowired
    private Http401UnauthorizedEntryPoint authenticationEntryPoint;

    @Override
    public void configure( WebSecurity web ) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**");
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .formLogin()
                .loginProcessingUrl("/static/app/authentication")
                .successHandler(ajaxAuthenticationSuccessHandler)
                .failureHandler(ajaxAuthenticationFailureHandler)
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/static/app/logout")
                .logoutSuccessHandler(ajaxLogoutSuccessHandler)
                .deleteCookies("JSESSIONID", "CSRF-TOKEN")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/static/app/rest/dev/health").authenticated()
                .antMatchers("/static/app/rest/dev/cache/**").authenticated()
                .antMatchers("/static/app/rest/heartbeat").permitAll()
                .antMatchers("/static/app/rest/authenticate").permitAll()
                .antMatchers("/static/app/rest/dev/**").authenticated()
                .antMatchers("/static/app/rest/**").authenticated();

    }


    @Bean
    public AuthenticationProvider authenticationProvider( ) {
        return new MongoDbAuthenticationProvider( );
    }
}