package com.test.banco.services;

import org.springframework.stereotype.Service;

@Service
public interface CalculaTaxaService {
	
	public double depositar(double valor);
	public double sacar(double valor);
	public double calculaTarifaCliente(double valor);
	public double calculaTarifaEmpresa(double valor);

}
