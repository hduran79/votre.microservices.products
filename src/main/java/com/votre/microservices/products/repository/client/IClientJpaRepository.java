package com.votre.microservices.products.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.votre.microservices.products.entity.Client;

@Repository
public interface IClientJpaRepository extends JpaRepository<Client, String> {

    Client findById(Long id);

  }
