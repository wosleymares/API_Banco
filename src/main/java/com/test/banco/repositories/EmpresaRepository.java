package com.test.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.banco.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
