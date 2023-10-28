package com.cafedobrasil.cafedobrasil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafedobrasil.cafedobrasil.model.ItensVenda;
import com.cafedobrasil.cafedobrasil.repository.ItensVendaRepository;

@RestController
@RequestMapping("/itensvenda")
public class ItensVendaController {
    
    @Autowired
    private ItensVendaRepository vr;

    @GetMapping("/")
    public List<ItensVenda> listarItensVenda() {
        return vr.findAll();
    }

    
}
