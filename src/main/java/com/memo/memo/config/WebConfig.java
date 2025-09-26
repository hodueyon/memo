package com.memo.memo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@CrossOrigin으로 CORS 설정을 해줘야 Vue에서 API 호출가능하게끔 설정

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 모든 경로
                .allowedOrigins("http://localhost:5173") // Vue 개발 서버 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                /*.allowedHeaders("*")
                .allowCredentials(true)*/;
    }
}

