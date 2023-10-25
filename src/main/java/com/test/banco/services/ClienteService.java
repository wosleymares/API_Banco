package com.test.banco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.banco.models.Cliente;
import com.test.banco.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente atualizar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return this.clienteRepository.findAll();
	}
	
	
	public Cliente listarClientes(Long id) {
	Optional<Cliente> cliente =	this.clienteRepository.findById(id);
		return cliente.orElseThrow();
	}

	public void remover(Long id) {
		this.clienteRepository.deleteById(id);		
	}
	
	
	@Transactional
	public Cliente sacar(Long ClienteId, double valor) {
		Cliente cliente = clienteRepository.findById(ClienteId).orElse(null);
		if(cliente != null && valor >= 0 && cliente.getSaldo() >= valor) {
			return clienteRepository.save(cliente);
		}
		return null;
	}
	
	@Transactional
	public Cliente deposita(Long ClienteId,double valor) {
		Cliente cliente = clienteRepository.findById(ClienteId).orElse(null);
		if(cliente != null && valor >= 0) {
			cliente.setSaldo(cliente.getSaldo() + valor);
			return clienteRepository.save(cliente);
		}
		return null;
	}
	
	

}
