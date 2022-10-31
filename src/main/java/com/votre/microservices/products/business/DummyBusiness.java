package com.votre.microservices.products.business;

import org.springframework.stereotype.Service;

import com.votre.microservices.products.dto.DummyDTO;

@Service
public class DummyBusiness {

    DummyBusiness() {

    }

    public DummyDTO helloWorldBean() {
        return DummyDTO.builder().message("Hola Mundo !!!").build();
    }
    
    public int throwable(int a, int b) {
        return a / b;
    }
}
