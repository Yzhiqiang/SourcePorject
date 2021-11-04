package com.source.sourceporject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.source.sourceporject.mapper")
@SpringBootApplication
public class SourcePorjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SourcePorjectApplication.class, args);
    }
}
