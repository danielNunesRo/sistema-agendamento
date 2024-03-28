package com.danielnunesro.agendamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielnunesro.agendamento.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	
}
