package vw.nama.springcontainer.di.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import vw.nama.springcontainer.di.model.*;

@Configuration
public class AppConfig {

    @Bean("firstBean")
    @DependsOn(value = {
        "secondBean",
        "thirdBean"
    })
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean
    public SecondBean secondBean() {
        return new SecondBean();
    }

    @Bean
    public ThirdBean thirdBean() {
        return new ThirdBean();
    }
}