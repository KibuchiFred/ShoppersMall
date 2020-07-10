package com.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
//to autoconfigure the spring session servlet filter. equal to store-type property
//in the application.properties. thus comment out
//@EnableRedisHttpSession
public class ShoppingMallApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShoppingMallApplication.class, args);
    }

}
