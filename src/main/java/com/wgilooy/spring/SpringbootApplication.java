package com.wgilooy.spring;

import com.wgilooy.config.MySpringBootAnnotation;
import org.springframework.boot.SpringApplication;

@MySpringBootAnnotation
public class SpringbootApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
