package com.bitc.reactasyncserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        addMapping() : 지정한 패턴에 맞는 페이지에 대해서 접근 권한 확인
//        allowedOrigins(url) : 접근 허용할 외부 url
        
//        1번째 방법
        registry.addMapping("/**") //  '/'는 최상위 url => 최상위 url에 접근하는 모든 걸 허용하겠다.
                .allowedOrigins("http://localhost:3000","http://localhost:4000");
        
//        registry.addMapping("/login/**")
//                .allowedOrigins("http://localhost:3000"); //이 페이지만 허용. 다른 페이지는 불허용
    }
}
