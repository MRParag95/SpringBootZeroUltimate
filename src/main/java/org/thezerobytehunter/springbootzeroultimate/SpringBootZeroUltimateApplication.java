package org.thezerobytehunter.springbootzeroultimate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableScheduling
public class SpringBootZeroUltimateApplication {
    static void main( String[] args ) {
        SpringApplication.run( SpringBootZeroUltimateApplication.class, args );
    }
}