package com.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.blog.interceptor.LoginInterceptor;
import com.blog.interceptor.LoginLocaleResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

/**
 * @author 神州战神
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 登录拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**")
                .excludePathPatterns("/admin","/admin/login");
    }

    /**
     * 国际化语言配置
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new LoginLocaleResolver();
    }

}
