package com.votre.microservices.products.repository.payment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.votre.microservices.products.dto.payment.PaymentDTO;
import com.votre.microservices.products.dto.payment.TransaccionDTO;

@Mapper
public interface IPaymentRepository {

    List<PaymentDTO> consultClient(TransaccionDTO dto);

}
