package com.votre.microservices.products.controller.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votre.microservices.products.business.user.UserBusiness;
import com.votre.microservices.products.entity.User;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RequestMapping(value = "users")
@RestController
@Valid
public class UserController {

    private UserBusiness business;
    private static final String FALLBACK_METHOD = "fallbackTypeCode";

    public UserController(UserBusiness business) {
        this.business = business;
    }

    @GetMapping("/jpa")
    public List<User> retrieveAllUsers() {
        return business.retrieveAllUsers();
    }

    @GetMapping("/{id}")
    public EntityModel<User> retrieveUser(
                    @Min(value = 100, message = "ID should not be less than 100") @Pattern(regexp = "^[0-9]*$",
                        message = "the ID field accepts only numbers") @Positive @PathVariable int id) {

        var user = business.findOne(id);

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
                    @Min(value = 100, message = "ID should not be less than 100") @Pattern(
                        regexp = "^[0-9]$") @Positive(message = "ID is Positive") @PathVariable int id) {
        business.deleteById(id);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(business.save(user));
    }

//    @CircuitBreaker(name = "msTypeCode", fallbackMethod = FALLBACK_METHOD)
//    @GetMapping("/circuit-breaker")
//    public String circuitBreaker() {
//        return business.helloWorld();
//    }
    
//    private String fallbackTypeCode(RuntimeException e) {
//        return "Servicio no disponible, intente mas tarde !!!";
//    }


}
