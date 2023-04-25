package com.cadastro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.exception.ResourceNotFoundException;
import com.cadastro.model.Funcionario;
import com.cadastro.repositories.FuncionarioRepository;
import com.cadastro.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public Funcionario saveFuncionario(Funcionario funcionario) { 
		return funcionarioRepository.save(funcionario);
	}
	
	@Override
	public List<Funcionario> getAllFuncionarios() { 
		return funcionarioRepository.findAll();
	}
	
	@Override
	public Funcionario getFuncionarioById(long id) { 
		return funcionarioRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Funcionarios", "id", id));
	}
	
	@Override
	public Funcionario updateFuncionario(Funcionario funcionario, long id) { 
		
		Funcionario funcionarioExistente = funcionarioRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Funcionario", "id", id));
		
		funcionarioExistente.setPrimeiroNome(funcionario.getPrimeiroNome());
		funcionarioExistente.setUltimoNome(funcionario.getUltimoNome());
		funcionarioExistente.setEmail(funcionario.getEmail());
		
		funcionarioRepository.save(funcionarioExistente);
		return funcionarioExistente;
	}
	
	@Override
	public void deleteFuncionario(long id) { 
		funcionarioRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Funcionario", "id", id));
		
		funcionarioRepository.deleteById(id);
	}
}
