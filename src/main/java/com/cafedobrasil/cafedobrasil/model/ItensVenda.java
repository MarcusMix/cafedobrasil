package com.cafedobrasil.cafedobrasil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "itensvenda")
public class ItensVenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItensVenda;

    //id venda
    @ManyToOne
    @JoinColumn(name = "idVenda")
    private Venda venda;


    @Column(nullable = false)
    private int qtde;
    
    @Column(nullable = false)
    private double preco;
}
