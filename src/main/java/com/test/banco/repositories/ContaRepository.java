package com.test.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.banco.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
