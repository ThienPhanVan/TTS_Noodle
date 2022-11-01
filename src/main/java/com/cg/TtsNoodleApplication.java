package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.context.properties.EnableConfigurationProperties;
=======
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
>>>>>>> sinh_dev1

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TtsNoodleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtsNoodleApplication.class, args);
    }

}
