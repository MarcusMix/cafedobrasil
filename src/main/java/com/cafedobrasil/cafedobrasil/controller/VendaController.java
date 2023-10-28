package com.cafedobrasil.cafedobrasil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafedobrasil.cafedobrasil.model.Venda;
import com.cafedobrasil.cafedobrasil.repository.VendaRepository;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaRepository vc;

    @GetMapping("/")
    public List<Venda> listarVenda(){
        return vc.findAll();
    }

    
    
}
