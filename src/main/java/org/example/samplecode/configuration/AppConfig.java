package org.example.samplecode.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class AppConfig {

//    @Override
//    public void addCorsMappings(CorsRegistry corsRegistry){
//        corsRegistry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("http://127.0.0.1:5500/")
//                .allowedMethods("*")
//                .allowedHeaders("*");
//    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // tao source CORS
        CorsConfiguration config = new CorsConfiguration(); // tao CorsConfig de chua cac quy tac CORS
        config.setAllowCredentials(true); // cho phep gui cooke ( token, session ... ) giua FE va BE
        config.setAllowedOrigins(List.of("http://127.0.0.1:5500/" , "http://127.0.0.1:8080/"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH"));
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/user/**", config);
        source.registerCorsConfiguration("/account/**", config); // them url
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }



}
