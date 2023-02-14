package com.votre.microservices.products.controller.dummy;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votre.microservices.products.business.dummy.DummyBusiness;
import com.votre.microservices.products.dto.dummy.DummyDTO;
import com.votre.microservices.products.dto.user.UserDTO;
import com.votre.microservices.products.entity.User;

@RequestMapping(value = "dummy")
@RestController
@Validated
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
    public DummyDTO helloWorldPathVariable(
                    @Size(min = 3, max = 30, message = "ID should not be less than 100")
                    @Pattern(regexp = "^[a-zA-Z]*$", message = "the name field only accepte letters")
                    @PathVariable String name) {
        return DummyDTO.builder().message(String.format("Hello World, %s", name)).build(); 
    }
    
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Buenos días", locale );

    }
    
    @GetMapping(path = "/exception/{a}")
    public int exceptionMapper(                    
                    @Positive(message = "the name field only accepte numbers positives")
                    @PathVariable int a) {
        return business.exceptionCustom(a);
    }
    
    @GetMapping(path = "/throwable/{a}/{b}")
    public int throwableExceptionMapper(                    
                    @Positive(message = "the name field only accepte numbers positives")
                    @PathVariable int a,
                    @PathVariable int b) {
        return business.throwable(a, b);
    }
    
    @PutMapping(path = "/update")
    public User putUpdate(@Valid @RequestBody User user) {
        return User.builder().name(user.getName()).birthDate(user.getBirthDate()).build();
    }
    
    @GetMapping("/feing/{id}")
    public UserDTO circuitBreaker(@PathVariable String id) {
        return business.jsonplaceholder(id);
    }


}
