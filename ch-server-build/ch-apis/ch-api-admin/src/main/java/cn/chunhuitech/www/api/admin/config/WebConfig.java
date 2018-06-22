package cn.chunhuitech.www.api.admin.config;

import cn.chunhuitech.www.api.common.interceptor.WeiXinLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
        super.addInterceptors(registry);
        registry.addInterceptor(weiXinLoginInterceptor());
    }
    @Bean
    public WeiXinLoginInterceptor weiXinLoginInterceptor() {
        WeiXinLoginInterceptor weiXinLoginInterceptor = new WeiXinLoginInterceptor();
        return weiXinLoginInterceptor;
    }
}
