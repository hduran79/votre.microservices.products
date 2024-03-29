package com.votre.microservices.products.dto.dummy;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DummyDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String message;

    
}
