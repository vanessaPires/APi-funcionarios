package com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Funcionario;
import com.cadastro.serviceImpl.FuncionarioServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("api/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioServiceImpl service;
	
	//REQUEST TESTE
	@GetMapping("/home")
	public String hello() { 
		return "oi";
	}
	
	// REQUEST DE LISTAGEM
	//localhost:8080/api/funcionarios
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll() { 
		List<Funcionario> funcionarios = service.getAllFuncionarios();
		return ResponseEntity.ok().body(funcionarios);
	}
	
	// REQUEST POR ID
	//localhost:8080/api/funcionarios/1
	@GetMapping("{id}")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable("id") long FuncionarioId) { 
		return new ResponseEntity<Funcionario>(service.getFuncionarioById(FuncionarioId), HttpStatus.OK);
	}
	
	//REQUEST PARA SALVAR
	//localhost:8080/api/funcionarios
	@PostMapping
	public ResponseEntity<Funcionario> saveFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(service.saveFuncionario(funcionario), HttpStatus.CREATED);
	}
	
	//REQUEST PARA ATUALIZAR
	//localhost:8080/api/funcionarios/1
	@PutMapping("{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable("id") long id, 
			@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(service.updateFuncionario(funcionario, id), HttpStatus.OK);
	}
	
	//REQUEST PARA DELETAR
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteFuncionario(@PathVariable("id") long id){
		service.deleteFuncionario(id);
		
		return new ResponseEntity<String>("Funcionário deletado com sucesso.", 
				HttpStatus.OK);
	}
	
	
}
