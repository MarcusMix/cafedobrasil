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

import com.cafedobrasil.cafedobrasil.model.Produto;
import com.cafedobrasil.cafedobrasil.repository.ProdutoRepository;
import com.cafedobrasil.cafedobrasil.util.EntidadeException;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository pr;

    @GetMapping("/")
    public List<Produto> listarProduto() {
        return pr.findAll();
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto p){
        return pr.save(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id){
       Produto p = pr.findById(id).orElseThrow(()-> new EntidadeException("Produto", id));
        return ResponseEntity.ok(p);
    }
    
    // caso nao encontre, retorna 200 e o corpo vazio
    @GetMapping("/{id}")
    public Produto listarProdutoPorId(@PathVariable Long id){
        Produto p = pr.findById(id).orElse(null);
        return p;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> listarProdutoPorId(@PathVariable Long id, @RequestBody Produto p ){
        Produto pAtual = pr.findById(id).orElseThrow(() -> new EntidadeException("Produto", id));
        if (pAtual.getIdProduto() != null) {
            p.setIdProduto(id);;
            pAtual = pr.save(p);
        }
        return ResponseEntity.ok(pAtual);
    }

    @ExceptionHandler(EntidadeException.class)
    public ResponseEntity<String> handleEntidadeNaoEncontrada(EntidadeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
