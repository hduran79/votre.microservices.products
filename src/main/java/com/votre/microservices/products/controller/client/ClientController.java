package com.votre.microservices.products.controller.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.votre.microservices.products.business.client.IClientBusiness;
import com.votre.microservices.products.dto.client.ClienteDTO;
import com.votre.microservices.products.dto.client.TransaccionDTO;

@RestController
@RequestMapping(value = "client")
@Validated
public class ClientController {

    @Autowired
    @Qualifier("clientBusiness")
    private IClientBusiness business;

    @GetMapping(path = "/")
    public List<ClienteDTO> consultClient(@Valid @RequestBody TransaccionDTO dto) {
        return business.consultClient(dto);
    }

}
