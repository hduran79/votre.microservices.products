package com.votre.microservices.products.repository.dummy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.votre.microservices.products.dto.user.UserDTO;

@FeignClient(value = "DummyClient", url = "https://jsonplaceholder.typicode.com")
public interface IDummyClient {

    @GetMapping(value = "/posts/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    UserDTO getUserId(@PathVariable("id") String id);
}
