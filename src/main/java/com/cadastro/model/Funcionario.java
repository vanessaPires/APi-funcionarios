package com.cadastro.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	//VARIÁVEIS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "primeiro_nome", nullable = false) // SNAKE CASE
	private String primeiroNome; // CAMEL CASE
	
	@Column(name = "ultimo_nome")
	private String ultimoNome;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	public Funcionario() {
		super();
	}

	public Funcionario(long id, String primeiroNome, String ultimoNome, String email) {
		super();
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", email="
				+ email + "]";
	}
	
}
