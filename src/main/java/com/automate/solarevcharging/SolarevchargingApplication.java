package com.automate.solarevcharging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SolarevchargingApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication
        .run(SolarevchargingApplication.class, args);
  }

}
