package com.cafedobrasil.cafedobrasil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafedobrasil.cafedobrasil.model.Venda;

public interface VendaRepository extends JpaRepository <Venda, Long>  {
    
    
}
