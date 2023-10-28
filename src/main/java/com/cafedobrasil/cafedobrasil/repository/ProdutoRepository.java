package com.cafedobrasil.cafedobrasil.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafedobrasil.cafedobrasil.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{
    
    //List<Produto> findAllByOrderByIdDesc();
}
