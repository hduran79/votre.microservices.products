package com.votre.microservices.products.dto.payment;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PaymentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pin;
    private String idCliente;
    private String nombre;
    private String saldo;
    private String direccion;
    private String ciudad;
    private String estado;
    private String pais;
    private String telefono;
    private String email;
}
