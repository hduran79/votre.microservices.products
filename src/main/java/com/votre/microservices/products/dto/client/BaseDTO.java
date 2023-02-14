package com.votre.microservices.products.dto.client;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Code CIA required")
    @Size(min = 1, max = 3, message = "Code CIA is invalid, must be 3 characters")
    @Pattern(regexp = "(574|507|96)+", message = "Code CIA is incorrect")
    private String codCia;

    @Builder.Default
    private String status = "";

    @Builder.Default
    private String descStatus = "";

    private String accion;

    @JsonIgnore
    protected String schema;
}
