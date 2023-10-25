package com.test.banco.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="conta_poupanca")
@Getter
@Setter

public class ContaPoupanca extends Conta{
	
	@Override
	public double calculaTarifaCliente(double valor) {
		return 0;
	}
}
