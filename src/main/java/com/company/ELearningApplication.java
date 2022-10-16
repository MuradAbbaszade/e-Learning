package com.company;

import com.company.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ELearningApplication {
    @Autowired
    UserServiceImpl studentService;
    public static void main(String[] args){
        SpringApplication.run(ELearningApplication.class);
    }
    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

            }

        };
        return clr;
    }
}
