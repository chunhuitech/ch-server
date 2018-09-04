package cn.chunhuitech.www.api.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by hechengjin on 17-9-28.
 */

@SpringBootApplication
@ComponentScan({"cn.chunhuitech.www.api.common.*", "cn.chunhuitech.www.core.admin.*", "cn.chunhuitech.www.api.admin.*"})
@MapperScan("cn.chunhuitech.www.core.admin.mysql.mapper.*")
@EnableWebMvc
public class Application {
    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Application.class, args);
    }
}
