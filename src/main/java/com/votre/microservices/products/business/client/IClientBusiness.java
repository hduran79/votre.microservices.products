package com.votre.microservices.products.business.client;

import java.util.List;

import com.votre.microservices.products.dto.client.ClienteDTO;
import com.votre.microservices.products.dto.client.TransaccionDTO;

public interface IClientBusiness {

    List<ClienteDTO> consultClient(TransaccionDTO dto); 
    
    
}
