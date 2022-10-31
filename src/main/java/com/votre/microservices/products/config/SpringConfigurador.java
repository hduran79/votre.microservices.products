package com.votre.microservices.products.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.votre.ms.exception.*", "com.votre.configuration"})
public class SpringConfigurador {

}
