package com.example.crud;

import com.example.crud.interceptor.HeaderLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoConfig implements WebMvcConfigurer {
    public static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    private final HeaderLoggingInterceptor headerLoggingInterceptor;

    public DemoConfig(@Autowired HeaderLoggingInterceptor headerLoggingInterceptor) {
        this.headerLoggingInterceptor = headerLoggingInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(headerLoggingInterceptor)
                .addPathPatterns("/post/**")
                .excludePathPatterns("/except/**");
    }
}
