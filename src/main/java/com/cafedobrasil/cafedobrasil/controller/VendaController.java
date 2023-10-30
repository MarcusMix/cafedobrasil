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
 
import com.cafedobrasil.cafedobrasil.model.Venda;
import com.cafedobrasil.cafedobrasil.repository.VendaRepository;
import com.cafedobrasil.cafedobrasil.util.EntidadeException;
 
@RestController
@RequestMapping("/vendas")
public class VendaController {
 
    @Autowired
    private VendaRepository vr;
 
    @GetMapping("/")
    public List<Venda> listarVenda(){
        return vr.findAll();
    }
    @PostMapping
    public Venda salvarVenda(@RequestBody Venda v){
        return vr.save(v);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable Long id){
       Venda v = vr.findById(id).orElseThrow(()-> new EntidadeException("venda", id));
        return ResponseEntity.ok(v);
    }
   
    // caso nao encontre, retorna 200 e o corpo vazio
    @GetMapping("/{id}")
    public Venda listarProdutoPorId(@PathVariable Long id){
        Venda v = vr.findById(id).orElse(null);
        return v;
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<?> listarProdutoPorId(@PathVariable Long id, @RequestBody Venda v ){
        Venda vAtual = vr.findById(id).orElseThrow(() -> new EntidadeException("Venda", id));
        if (vAtual.getIdVenda() != null) {
            v.setIdVenda(id);;
            vAtual = vr.save(v);
        }
        return ResponseEntity.ok(vAtual);
    }
 
    @ExceptionHandler(EntidadeException.class)
    public ResponseEntity<String> handleEntidadeNaoEncontrada(EntidadeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
   
   
}