package com.bni.rekcheck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // semua endpoint
                        .allowedOrigins("http://localhost:3000") // izinkan frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // metode HTTP
                        .allowedHeaders("*");
            }
        };
    }
}
