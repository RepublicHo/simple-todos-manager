package com.example.simpletodosmanager;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        SimpleTodosManagerApplication.class,
        Jsr310JpaConverters.class

})
@EnableJpaAuditing
public class SimpleTodosManagerApplication {

    @PostConstruct
    void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {

        SpringApplication.run(SimpleTodosManagerApplication.class, args);
    }

}
