package com.danielnunesro.agendamento.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClienteDTO {
	
	private String firstName;
    private String lastName;
    private LocalDate age;
    private String cpf;
    private String email;
    private LocalDate date;
    private LocalTime time;
    
    public ClienteDTO() {
    	
    }

	public ClienteDTO(String firstName, String lastName, LocalDate age, String cpf, String email, LocalDate date,
			LocalTime time) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.cpf = cpf;
		this.email = email;
		this.date = date;
		this.time = time;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getAge() {
		return age;
	}

	public void setAge(LocalDate age) {
		this.age = age;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
    
    
	
}
