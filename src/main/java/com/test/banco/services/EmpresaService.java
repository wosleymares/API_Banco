package com.test.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.banco.models.Empresa;
import com.test.banco.repositories.EmpresaRepository;

import jakarta.transaction.Transactional;


@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Transactional
	public Empresa salvar(Empresa empresa) {
		return this.empresaRepository.save(empresa);
	}
	
	@Transactional
	public Empresa atualizar(Empresa empresa) {
		return this.empresaRepository.save(empresa);
	}
	
	public List<Empresa> listarEmpresas(){
		return this.empresaRepository.findAll();
	}
	
	
	public Empresa listarEmpresas(Long id) {
	Optional<Empresa> empresas =	this.empresaRepository.findById(id);
		return empresas.orElseThrow();
	}

	public void remover(Long id) {
		this.empresaRepository.deleteById(id);		
	}
	
	public Empresa sacar(Long Id, double valor) {
		Empresa empresa = empresaRepository.findById(Id).orElse(null);
		if(empresa != null && valor > 0 && empresa.getSaldo() >= valor) {
			empresa.setSaldo(empresa.getSaldo() - valor);
			return empresaRepository.save(empresa);
		}
		return null;
		
	}
	
	public Empresa deposita(Long Id, double valor) {
		Empresa empresa = empresaRepository.findById(Id).orElse(null);
		if(empresa != null && valor > 0) {
			empresa.setSaldo(empresa.getSaldo() + valor);
			return empresaRepository.save(empresa);
		}
		return null;
		
	}
	
	
}
