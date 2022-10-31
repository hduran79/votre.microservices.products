package com.votre.microservices.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;

import com.votre.microservices.products.business.DummyBusiness;
import com.votre.microservices.products.dto.DummyDTO;

@RestController
public class DummyController {

    private DummyBusiness business;
    private MessageSource messageSource;

    public DummyController(DummyBusiness business, MessageSource messageSource) {
        this.business = business;
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world", produces = MediaType.APPLICATION_JSON_VALUE)
    public DummyDTO business() {
        return business.helloWorldBean();
    }
    
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public DummyDTO helloWorldPathVariable(@PathVariable String name) {
        return DummyDTO.builder().message(String.format("Hello World, %s", name)).build(); 
    }
    
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Buenos días", locale );

    }
    
    @GetMapping(path = "/throwable/{a}/{b}")
    public int throwableExceptionMapper(@PathVariable int a, @PathVariable int b) {
        return business.throwable(a, b);
    }


}
