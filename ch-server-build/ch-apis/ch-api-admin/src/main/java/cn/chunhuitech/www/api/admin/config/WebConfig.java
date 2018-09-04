package cn.chunhuitech.www.api.admin.config;

import cn.chunhuitech.www.api.common.interceptor.WeiXinLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by hechengjin on 17-10-27.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
        registry.addInterceptor(weiXinLoginInterceptor()).excludePathPatterns("/swagger-ui.html/**","/swagger-resources/**","/webjars/**","/error/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//        super.addResourceHandlers(registry);
    }

    @Bean
    public WeiXinLoginInterceptor weiXinLoginInterceptor() {
        WeiXinLoginInterceptor weiXinLoginInterceptor = new WeiXinLoginInterceptor();
        return weiXinLoginInterceptor;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
//        super.configureDefaultServletHandling(configurer);
    }
}
