package com.danielnunesro.agendamento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielnunesro.agendamento.dtos.ClienteDTO;
import com.danielnunesro.agendamento.entities.Cliente;
import com.danielnunesro.agendamento.exceptions.ConflictException;
import com.danielnunesro.agendamento.exceptions.ResourceNotFoundException;
import com.danielnunesro.agendamento.mapper.ClienteMapper;
import com.danielnunesro.agendamento.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<ClienteDTO> findAll() {
		List<ClienteDTO> allClientes = ClienteMapper.INSTANCE.toClienteDTOList(repository.findAll());
		return allClientes;
	}
	
	public ClienteDTO findById(Long id) {
		var clienteExisting = repository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Usuario não encontrado!")); 
		ClienteDTO cliente = ClienteMapper.INSTANCE.toClienteDTO(clienteExisting);
		return cliente;
		
	}
	
	
	public ClienteDTO create(ClienteDTO request) {
		
		if (clienteExistenteNoMesmoHorario(request)) {
            throw new ConflictException("Já há outro cliente agendado para o mesmo horário");
        }
		
		var newCliente = ClienteMapper.INSTANCE.toCliente(request);
		repository.save(newCliente);
		ClienteDTO clienteDTO = ClienteMapper.INSTANCE.toClienteDTO(newCliente);
		return clienteDTO;
		
		
	}
	
	public ClienteDTO update(Long id, ClienteDTO clienteUpd) {
		
		var clienteExisting = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado!"));
		
		if (clienteExistenteNoMesmoHorario(clienteUpd)) {
            throw new ConflictException("Já há outro cliente agendado para o mesmo horário, tente um novo horário.");
        }
		
		clienteExisting.setFirstName(clienteUpd.getFirstName());
		clienteExisting.setLastName(clienteUpd.getLastName());
		clienteExisting.setAge(clienteUpd.getAge());
		clienteExisting.setCpf(clienteUpd.getCpf());
		clienteExisting.setEmail(clienteUpd.getEmail());
		clienteExisting.setDate(clienteUpd.getDate());
		clienteExisting.setTime(clienteUpd.getTime());
		repository.save(clienteExisting);
		return ClienteMapper.INSTANCE.toClienteDTO(clienteExisting);
	}
	
	public void delete(Long id) {
		var clienteExisting = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado!"));
		repository.deleteById(clienteExisting.getId());
	}
	
	
	
	
	
	
	private boolean clienteExistenteNoMesmoHorario(ClienteDTO clienteDTO) {
        LocalDateTime novoAgendamento = LocalDateTime.of(clienteDTO.getDate(), clienteDTO.getTime());
        
        List<Cliente> clientesAgendados = repository.findAll();
        
        for (Cliente cliente : clientesAgendados) {
            LocalDateTime agendamentoExistente = LocalDateTime.of(cliente.getDate(), cliente.getTime());
            if (agendamentoExistente.equals(novoAgendamento)) {
                return true; 
            }
        }
        
        return false; 
    }
	
}
