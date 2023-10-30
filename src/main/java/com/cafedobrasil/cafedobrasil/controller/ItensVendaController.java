package com.cafedobrasil.cafedobrasil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafedobrasil.cafedobrasil.model.ItensVenda;
import com.cafedobrasil.cafedobrasil.repository.ItensVendaRepository;
import com.cafedobrasil.cafedobrasil.util.EntidadeException;

@RestController
@RequestMapping("/itensvenda")
public class ItensVendaController {
    
    @Autowired
    private ItensVendaRepository vr;

    @GetMapping("/")
    public List<ItensVenda> listarItensVenda() {
        return vr.findAll();
    }

    @PostMapping
    public ItensVenda salvarItensVenda(@RequestBody ItensVenda v){
        return vr.save(v);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id){
       ItensVenda v = vr.findById(id).orElseThrow(()-> new EntidadeException("Produto", id));
        return ResponseEntity.ok(v);
    }
    
    @GetMapping("/{id}")
    public ItensVenda listarProdutoPorId(@PathVariable Long id){
        ItensVenda v = vr.findById(id).orElse(null);
        return v;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> listarProdutoPorId(@PathVariable Long id, @RequestBody ItensVenda v ){
        ItensVenda vAtual = vr.findById(id).orElseThrow(() -> new EntidadeException("Produto", id));
        if (vAtual.getIdItensVenda()!= null) {
            v.setIdItensVenda(id);
            vAtual = vr.save(v);
        }
        return ResponseEntity.ok(vAtual);
    }

    @ExceptionHandler(EntidadeException.class)
    public ResponseEntity<String> handleEntidadeNaoEncontrada(EntidadeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }   



}
