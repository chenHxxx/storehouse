package com.sxt.sys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Autowired
    private RedisSessionInterceptor redisSessionInterceptor;
    @Bean
    public RedisSessionInterceptor getSessionInterceptor()
    {
        return new RedisSessionInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //所有已sys开头的访问都要进入RedisSessionInterceptor拦截器进行登录验证，并排除login接口(全路径)。必须写成链式，分别设置的话会创建多个拦截器。
        //必须写成getSessionInterceptor()，否则SessionInterceptor中的@Autowired会无效
/*        InterceptorRegistration addInterceptor = registry.addInterceptor(redisSessionInterceptor);
        addInterceptor.excludePathPatterns("/resource/**");//排除静态资源
        addInterceptor.excludePathPatterns("/sys/toLogin");
        addInterceptor.addPathPatterns("/**");*/
        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/abc/**").excludePathPatterns("/abc/toLogin");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("system/index/login");
    }*/

    //配置静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
