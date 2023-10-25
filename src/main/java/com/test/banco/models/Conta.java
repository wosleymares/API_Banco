package com.test.banco.models;

import com.test.banco.services.CalculaTaxaService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="contas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Conta implements CalculaTaxaService{

    @Id
    @Column(name="numero_conta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numConta;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresa empresa;

    @Column(name="saldo")
    private Double saldo;


	@Override
	public double depositar(double valor) {
		return this.saldo += valor;
		
	}

	@Override
	public double sacar(double valor) {
		this.saldo -= valor;
		return this.saldo;
		
	}

	@Override
	public double calculaTarifaCliente(double valor) {
		return valor * 0.2;
		
	}
	
	@Override
	public double calculaTarifaEmpresa(double valor) {
		return valor * 0.3;
	}
}
