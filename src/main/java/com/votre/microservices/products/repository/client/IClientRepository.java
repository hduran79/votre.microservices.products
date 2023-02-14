package com.votre.microservices.products.repository.client;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.votre.microservices.products.dto.client.ClienteDTO;
import com.votre.microservices.products.dto.client.TransaccionDTO;

@Mapper
public interface IClientRepository {

    List<ClienteDTO> consultClient(TransaccionDTO dto);

}
