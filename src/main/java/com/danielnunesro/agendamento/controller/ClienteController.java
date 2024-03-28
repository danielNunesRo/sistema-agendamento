package com.danielnunesro.agendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielnunesro.agendamento.dtos.ClienteDTO;
import com.danielnunesro.agendamento.services.ClienteService;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> allClientes = clienteService.findAll();
        return ResponseEntity.ok(allClientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO request) {
        ClienteDTO createdCliente = clienteService.create(request);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }
	
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO request) {
        ClienteDTO updatedCliente = clienteService.update(id, request);
        return ResponseEntity.ok(updatedCliente);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
    	clienteService.delete(id);
    	return ResponseEntity.ok().body("Agendamento excluido com sucesso.");
    }
	
}
