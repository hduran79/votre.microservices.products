package com.votre.microservices.products.business.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votre.microservices.products.dto.payment.PaymentDTO;
import com.votre.microservices.products.dto.payment.TransaccionDTO;
import com.votre.microservices.products.repository.payment.IPaymentRepository;

@Service
public class ClientBusiness implements IClientBusiness {

    @Autowired
    IPaymentRepository repository;

    ClientBusiness() {
        /* only sonar */
    }

    public ClientBusiness(IPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PaymentDTO> consultClient(TransaccionDTO dto) {
        return repository.consultClient(dto);
    }

}
