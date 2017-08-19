package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com" })
@EnableAutoConfiguration
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ServerApplication.class);

        ConfigurableApplicationContext context = springApplication.run(args);
    }
}
