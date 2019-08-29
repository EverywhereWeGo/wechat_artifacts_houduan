package com;

import com.c_SpliderWechat.SpliderWechat;
import com.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


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
        SpliderWechat sw = new SpliderWechat();
        SimpleDateFormat sdf = null;
        Date startdate = null;
        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startdate = sdf.parse("2019-06-10 08:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sw.startSplider();
                System.out.println("等待下一次抓取");
            }
        }, startdate, 6 * 60 * 60 * 1000);
    }

}
