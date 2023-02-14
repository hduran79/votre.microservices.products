package com.votre.microservices.products.business.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votre.microservices.products.dto.client.ClienteDTO;
import com.votre.microservices.products.dto.client.TransaccionDTO;
import com.votre.microservices.products.repository.client.IClientRepository;

@Service
public class ClientBusiness implements IClientBusiness {

    @Autowired
    IClientRepository repository;

    ClientBusiness() {
        /* only sonar */
    }

    public ClientBusiness(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClienteDTO> consultClient(TransaccionDTO dto) {
        return repository.consultClient(dto);
    }

}
