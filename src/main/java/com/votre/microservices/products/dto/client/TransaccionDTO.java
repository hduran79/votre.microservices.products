package com.votre.microservices.products.dto.client;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class TransaccionDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Builder.Default
    private String referencia = "";
    @Builder.Default
    private String nombre = "";
    private float nroOrden;
    private float valorPago;
    @Builder.Default
    private String idTienda = "";
    @Builder.Default
    private String usuario = "";
    @Builder.Default
    private String formaPago = "";
    @Builder.Default
    private String comodin1 = "";
    @Builder.Default
    private String comodin2 = "";
    @Builder.Default
    private String comodin3 = "";

    private List<ClienteDTO> clientes;
}
