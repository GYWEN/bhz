package org.bhz.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.server.RemoteServer;

@SpringBootApplication
@EnableDubbo
public class BhzSysConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(BhzSysConsumerApplication.class, args);
    }

}
