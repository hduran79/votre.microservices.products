package com.votre.microservices.products.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votre.microservices.products.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
