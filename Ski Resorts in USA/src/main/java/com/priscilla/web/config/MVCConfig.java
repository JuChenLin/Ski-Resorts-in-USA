package com.priscilla.web.config;

import com.priscilla.web.component.AdminHandlerInterceptor;
import com.priscilla.web.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/priscilla").setViewName("success");
    }

    @Bean
    public WebMvcConfigurer  webMvcConfigurer() {
        WebMvcConfigurer  adapter = new WebMvcConfigurer () {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/favorite").setViewName("skiresort/favorite");

//                registry.addViewController("/").setViewName("resort/list");
//                registry.addViewController("/index").setViewName("resort/list");
//                registry.addViewController("/member").setViewName("member");
//                registry.addViewController("/edit").setViewName("resort/edit");
                registry.addViewController("/detail").setViewName("skiresort/detail");
            }

            // Register Interceptor
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/favorite");
//                        .excludePathPatterns("/", "/index", "/login", "/user/login");

                registry.addInterceptor(new AdminHandlerInterceptor())
                        .addPathPatterns("/resort", "/resort/{id}");
//                        .excludePathPatterns("/", "/index", "/login", "/user/login", "resort");
            }
        };
        return adapter;
    }
}

