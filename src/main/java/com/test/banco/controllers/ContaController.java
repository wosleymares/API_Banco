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
import org.springframework.web.bind.annotation.RestController;

import com.test.banco.models.Conta;
import com.test.banco.services.ContaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contas")
@Validated
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	public ResponseEntity<List<Conta>> listarContas(){
		List<Conta> contas = this.contaService.listarContas();
		return new ResponseEntity<>(contas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Conta> listarContas(@PathVariable Long id){
		Conta contas = this.contaService.listarContas(id);
		return ResponseEntity.ok().body(contas);
	}
	
	@PostMapping
	public ResponseEntity<Conta> salvar(@Valid @RequestBody Conta conta){
		this.contaService.salvar(conta);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Conta> atualizar(@RequestBody Conta conta){
		return ResponseEntity.ok(this.contaService.atualizar(conta));	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id){
		this.contaService.remover(id);
		return ResponseEntity.ok("Conta removida");
	}

}
