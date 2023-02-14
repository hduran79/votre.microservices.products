package com.votre.microservices.products.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.votre.shared.common.util.*"})
public class SpringConfigurador {

}
