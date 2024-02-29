package org.example.ejercicio3_t3_examen.models;

import lombok.Data;

@Data
public class NumeroAleatorio {
    private int random;

    public NumeroAleatorio(int numero) {
        this.random = numero;
    }
}
