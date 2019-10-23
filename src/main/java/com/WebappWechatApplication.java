package com;

import com.c_SpliderWechat.Splider;
import com.filter.CorsFilter;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
@EnableSwagger2
public class WebappWechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappWechatApplication.class, args);
        timer();
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

    public static void timer() {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
//                sw.startSplider();
//                csdn.startSplider();
                System.out.println("等待下一次抓取");
            }
        }, 1, 10, TimeUnit.SECONDS);


    }


}
