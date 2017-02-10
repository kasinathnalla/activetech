package com.arkiv.sports.referee.config;//package com.arkiv.sports.com.arkiv.sports.referee.config;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@ComponentScan( basePackages = { "com.arkiv.sports.com.arkiv.sports.referee" } )
//@EnableAutoConfiguration
//@Configuration
//public class WebAppConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
//
//        registry.addResourceHandler( "/**" ).addResourceLocations( "classpath:/app/" );
//        registry.addResourceHandler( "/html/**" ).addResourceLocations( "classpath:/html/" );
//        registry.addResourceHandler( "/img/**" ).addResourceLocations( "classpath:/app/img/" );
//        registry.addResourceHandler( "/js/**" ).addResourceLocations( "classpath:/app/js/" );
//
//    }
//
//    @Bean
//    @Autowired
//    public ServletRegistrationBean dispatcherRegistration( DispatcherServlet dispatcherServlet ) {
//        ServletRegistrationBean registration = new ServletRegistrationBean( dispatcherServlet );
//        registration.setUrlMappings( Arrays.asList( "/*" ) );
//         registration.addUrlMappings("/**");
//        return registration;
//    }
//
//}
