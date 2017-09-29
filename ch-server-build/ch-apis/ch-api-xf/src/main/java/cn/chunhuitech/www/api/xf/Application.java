package cn.chunhuitech.www.api.xf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by hechengjin on 17-9-28.
 */

@SpringBootApplication
@ComponentScan({"cn.chunhuitech.www.api.common.*", "cn.chunhuitech.www.core.xf.*", "cn.chunhuitech.www.api.xf.*"})
@MapperScan("cn.chunhuitech.www.core.xf.mysql.mapper.*")
@EnableWebMvc
public class Application {
    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Application.class, args);
    }
}
