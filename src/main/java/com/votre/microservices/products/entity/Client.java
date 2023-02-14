package com.votre.microservices.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Client")
public class Client {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "identificationtype")
    private String type;

    @Column(name = "identification")
    private String identification;
}
