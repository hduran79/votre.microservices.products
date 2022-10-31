package com.votre.microservices.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.votre.microservices.products.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
