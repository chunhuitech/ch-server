package cn.chunhuitech.www.api.admin.config;/**
 * Created by hechengjin on 18-9-3.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: hechengjin
 * @CreateDate: 18-9-3 下午3:09
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("www.chunhuitech.cn")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalOperationParameters(globalOperationParameters())// 全局参数
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.chunhuitech.www.api.admin.controller.api"))//RequestHandlerSelectors.any()
                .paths(PathSelectors.any())// 监控所有路径 //PathSelectors.regex("/.*")
                .build();
    }
    private List<Parameter> globalOperationParameters(){
        ParameterBuilder builder = new ParameterBuilder();
        Parameter parameter = builder.name("token").description("登录返回的token")
                .modelRef(new ModelRef("string"))
                .parameterType("query")
                .required(false).build();
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(parameter);
        return parameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("春晖 Copyright 2018-2028 (C) All Rights Reserved.")
                .termsOfServiceUrl("http://www.chunhuitech.cn/")
                .contact(new Contact("chunhuitech",null,"chunhuitech@hotmail.com"))
                .version("1.0")
                .build();
    }
}
