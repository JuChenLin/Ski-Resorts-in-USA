package com.priscilla.web.json;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JsonMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/priscilla").setViewName("success");
    }

    @Bean
    public WebMvcConfigurer  webMvcTestConfigurer() {
        WebMvcConfigurer  adapter = new WebMvcConfigurer () {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/login").setViewName("login");
//                registry.addViewController("/favorite").setViewName("skiresort/favorite");

//                registry.addViewController("/").setViewName("resort/list");
//                registry.addViewController("/index").setViewName("resort/list");
//                registry.addViewController("/member").setViewName("member");
//                registry.addViewController("/edit").setViewName("skiresort/edit");
//                registry.addViewController("/detail").setViewName("skiresort/detail");

//                registry.addViewController("/test").setViewName("test/list");
//                registry.addViewController("/test/index").setViewName("test/list");
//                registry.addViewController("/test/resorts").setViewName("test/list");
            }

            // Register Interceptor
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //super.addInterceptors(registry);
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/favorite");
////                        .excludePathPatterns("/", "/index", "/login", "/user/login");
//
//                registry.addInterceptor(new AdminHandlerInterceptor())
//                        .addPathPatterns("/resort", "/resort/{id}");
////                        .excludePathPatterns("/", "/index", "/login", "/user/login", "resort");
//            }
        };
        return adapter;
    }
}

