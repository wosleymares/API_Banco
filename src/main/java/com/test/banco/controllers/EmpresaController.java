package com.test.banco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.banco.models.Empresa;
import com.test.banco.services.EmpresaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public ResponseEntity<List<Empresa>> listarClientes(){
		List<Empresa> empresas = this.empresaService.listarEmpresas();
		return new ResponseEntity<>(empresas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> listarEmpresas(@PathVariable Long id){
		Empresa empresas = this.empresaService.listarEmpresas(id);
		return ResponseEntity.ok().body(empresas);
	}
	
	@PostMapping
	public ResponseEntity<Empresa> salvar(@Valid @RequestBody Empresa empresa){
		this.empresaService.salvar(empresa);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public ResponseEntity<Empresa> atualizar(@RequestBody Empresa empresa){
		return ResponseEntity.ok(this.empresaService.atualizar(empresa));	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id){
		this.empresaService.remover(id);
		return ResponseEntity.ok("Empresa removida");
	}
	
	@PostMapping("/{Id}/deposita")
	public ResponseEntity<Empresa> deposita(@PathVariable Long Id, @RequestParam double valor){
		Empresa empresa = empresaService.deposita(Id, valor);
		if(empresa != null) {
			return ResponseEntity.ok(empresa);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{Id}/sacar")
	public ResponseEntity<Empresa> sacar(@PathVariable Long Id,@RequestParam double valor){
		Empresa empresa = empresaService.sacar(Id, valor);
		if(empresa != null) {
			return ResponseEntity.ok(empresa);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	

}
