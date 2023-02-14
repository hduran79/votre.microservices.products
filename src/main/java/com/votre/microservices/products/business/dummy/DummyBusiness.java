package com.votre.microservices.products.business.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votre.microservices.products.dto.dummy.DummyDTO;
import com.votre.microservices.products.dto.user.UserDTO;
import com.votre.microservices.products.repository.dummy.IDummyClient;
import com.votre.shared.common.util.exception.config.CommonsBusinessException;

@Service
public class DummyBusiness {

     @Autowired
     IDummyClient client;

    DummyBusiness() {

    }

    public DummyDTO helloWorldBean() {
        return DummyDTO.builder().message("Hola Mundo !!!").build();
    }

    public int exceptionCustom(int a) {

        if (a >= 2) {
            throw new CommonsBusinessException("TEC-001", "Error de negocio");
        }

        return a;
    }

    public int throwable(int a, int b) {
        return a / b;
    }

    public UserDTO jsonplaceholder(String id) {
        return client.getUserId(id);
    }
}
