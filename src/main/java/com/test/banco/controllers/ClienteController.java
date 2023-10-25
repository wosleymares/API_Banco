package com.test.banco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.banco.models.Cliente;
import com.test.banco.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> clientes = this.clienteService.listarClientes();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarClientes(@PathVariable Long id){
		Cliente clientes = this.clienteService.listarClientes(id);
		return ResponseEntity.ok().body(clientes);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente){
		this.clienteService.salvar(cliente);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
		return ResponseEntity.ok(this.clienteService.atualizar(cliente));	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id){
		this.clienteService.remover(id);
		return ResponseEntity.ok("Cliente removido");
	}
	
	@PostMapping("/{clienteId}/depositar")
	public ResponseEntity<Cliente> depositar(@PathVariable Long clienteId, @RequestParam double valor){
		Cliente cliente = clienteService.deposita(clienteId, valor);
		if(cliente != null) {
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{clienteId}/sacar")
	public ResponseEntity<Cliente> sacar(@PathVariable Long clienteId,@RequestParam double valor){
		Cliente cliente = clienteService.sacar(clienteId, valor);
		if(cliente != null) {
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	

}
