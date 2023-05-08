package org.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.Locale;

/**
 * @author jackqiu
 * 1.如果你想diy一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配!
 *  2.扩展springmvc的dispatchservLet
 *  3.如果我们要扩展springmvc，官方建议我们这样去做!
 * */
@Configuration
//错误的    -->       @EnableWebMvc//有此注解,本类中的任何配置失效
public class MyMvcConfig implements WebMvcConfigurer {
//    //ViewResolver实现了视图解析器接口的类，我们就可以把它看做视图解析器
//    @Bean
//    public MyViewResolver myViewResolver(){
//        return new MyViewResolver();
//    }
//
//    //自定义了一个自己的视图解析器MyViewResolver
//    public static class MyViewResolver implements ViewResolver{
//        @Override
//        public View resolveViewName(String s, Locale locale) throws Exception {
//            return null;
//        }
//    }
//
//    //视图跳转
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/aaa","/test");//重定向路径设置
//        registry.addViewController("/bbb").setViewName("test1");//视图跳转
//    }
    @Autowired
    private HandlerInterceptor handlerInterceptor;

    @Autowired
    private MyLocaleResolver myLocaleResolver;

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver() {//todo : 方法名一定要为localeResolver
        return myLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor).
                addPathPatterns("/*").excludePathPatterns("/","/index.html","/asserts","/user/login");
    }
}
