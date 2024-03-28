package com.danielnunesro.agendamento.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.danielnunesro.agendamento.dtos.ClienteDTO;
import com.danielnunesro.agendamento.entities.Cliente;

@Mapper
public interface ClienteMapper {
	
	ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
	
	@Mapping(target = "id", ignore = true) 
    Cliente toCliente(ClienteDTO clienteDTO);
	
    ClienteDTO toClienteDTO(Cliente cliente);
	
	List<ClienteDTO> toClienteDTOList(List<Cliente> clientes);
	
}
