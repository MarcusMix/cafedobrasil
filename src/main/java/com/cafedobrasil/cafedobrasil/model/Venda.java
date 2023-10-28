package com.cafedobrasil.cafedobrasil.model;

import java.util.Date;

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
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;
    
    @Column (nullable = false)
    private Date data_venda;

    @Column (nullable = false)
    private Date data_cancelamento;

    @Column (nullable = false)
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;

    
}
