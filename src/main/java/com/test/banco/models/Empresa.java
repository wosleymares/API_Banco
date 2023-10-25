package com.test.banco.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="empresas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Empresa {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name="nome", unique = true, nullable = false)
    private String nome;
    
    @Column(name="cnpj", unique = true, nullable = false)
    private String cnpj;
    
    @Column(name="saldo")
    private double saldo;
    
    
}
