package org.andromeda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.andromeda")
public class AndromedaApplication {

    public static void main(String... args) {
        SpringApplication.run(AndromedaApplication.class, args);
    }

}
