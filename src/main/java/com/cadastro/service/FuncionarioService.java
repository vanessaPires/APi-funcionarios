package com.cadastro.service;

import java.util.List;

import com.cadastro.model.Funcionario;

public interface FuncionarioService {
	Funcionario saveFuncionario(Funcionario funcionario);
	List<Funcionario> getAllFuncionarios();
	Funcionario getFuncionarioById(long id);
	Funcionario updateFuncionario(Funcionario funcionario, long id);
	void deleteFuncionario(long id);
}
