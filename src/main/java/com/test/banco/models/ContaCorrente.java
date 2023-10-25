package com.test.banco.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="conta_corrente")
@Getter
@Setter

public class ContaCorrente extends Conta{
	
	@Override
	public double calculaTarifaCliente(double valor) {
		return valor * 0.02;
	}
	
	@Override
	public double calculaTarifaEmpresa(double valor) {
		return valor * 0.03;
	}

}
