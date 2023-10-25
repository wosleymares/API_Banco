package com.test.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.banco.models.Conta;
import com.test.banco.repositories.ContaRepository;

import jakarta.transaction.Transactional;

@Service
public class ContaService {
	
	@Autowired
	ContaRepository contaRepository;
	
	@Transactional
	public Conta salvar(Conta conta) {
		return this.contaRepository.save(conta);
	}
	
	@Transactional
	public Conta atualizar(Conta conta) {
		return this.contaRepository.save(conta);
	}
	
	public List<Conta> listarContas(){
		return this.contaRepository.findAll();
	}
	
	
	public Conta listarContas(Long id) {
	Optional<Conta> contas = this.contaRepository.findById(id);
		return contas.orElseThrow();
	}

	public void remover(Long id) {
		this.contaRepository.deleteById(id);		
	}
	

}
