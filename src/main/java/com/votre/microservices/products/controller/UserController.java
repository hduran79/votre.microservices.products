package com.votre.microservices.products.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.votre.microservices.products.business.UserBusiness;
import com.votre.microservices.products.entity.User;

@RestController
public class UserController {

    private UserBusiness business;

    public UserController(UserBusiness business) {
        this.business = business;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return business.retrieveAllUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {

        User user = business.findOne(id);

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        business.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(business.save(user));
    }

}
