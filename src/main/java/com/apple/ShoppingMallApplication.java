package com.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
//enabling thread pool
@EnableAsync
public class ShoppingMallApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShoppingMallApplication.class, args);
    }

}
