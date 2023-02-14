package com.votre.microservices.products.business.client;

import java.util.List;

import com.votre.microservices.products.dto.payment.PaymentDTO;
import com.votre.microservices.products.dto.payment.TransaccionDTO;

public interface IClientBusiness {

    List<PaymentDTO> consultClient(TransaccionDTO dto); 
    
    
}
