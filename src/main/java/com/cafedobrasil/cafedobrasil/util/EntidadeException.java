package com.cafedobrasil.cafedobrasil.util;

public class EntidadeException extends RuntimeException {
    public EntidadeException(String entidade, Long id) {
        super("A entidade " + entidade + " com o ID " + id + " não foi encontrada.");
    }
}
