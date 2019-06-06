package com;

import com.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

import static com.b_util.SpliderWechat.asdfasdfasd;

@SpringBootApplication
@EnableSwagger2
public class WebappWechatApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(WebappWechatApplication.class, args);
        timer2();
    }


    @Bean
    public FilterRegistrationBean CorsFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CorsFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("corsFilter");
        registration.setOrder(1);
        return registration;
    }

    public static void timer2() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                try {
                    asdfasdfasd();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------延迟5000毫秒，每1000毫秒执行一次--------");
            }
        }, 5000, 2 * 60 * 60 * 1000);
    }

}
