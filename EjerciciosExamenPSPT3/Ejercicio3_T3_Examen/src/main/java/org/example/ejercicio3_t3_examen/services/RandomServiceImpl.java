package org.example.ejercicio3_t3_examen.services;

import org.example.ejercicio3_t3_examen.models.NumeroAleatorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta es una clase de servicio que implementa la interfaz RandomService.
 * Proporciona métodos para obtener y actualizar números aleatorios.
 */
@Service
public class RandomServiceImpl implements RandomService{

    /**
     * Este método devuelve una lista de 100 números aleatorios.
     * @return Lista de objetos NumeroAleatorio.
     */
    @Override
    public List<NumeroAleatorio> getNumbers() {
        List<NumeroAleatorio> listaNumerosAletorios = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            listaNumerosAletorios.add(new NumeroAleatorio((int) (Math.random() * 1000)));
        }

        return listaNumerosAletorios;
    }

    /**
     * Este método devuelve un número aleatorio con un número especificado de dígitos.
     * @param digitos El número de dígitos para el número aleatorio.
     * @return Un objeto NumeroAleatorio.
     */
    @Override
    public NumeroAleatorio getNumeroAleatorio(int digitos) {
        String cadenaNumeros = "";

        for(int i = 0; i < digitos; i++){
            cadenaNumeros += (int) (Math.random() * 10);
        }

        return new NumeroAleatorio(Integer.parseInt(cadenaNumeros));
    }

    /**
     * Este método actualiza un número aleatorio.
     * @param numero El objeto NumeroAleatorio a actualizar.
     * @return El objeto NumeroAleatorio actualizado.
     */
    @Override
    public NumeroAleatorio actualizarNumeroAleatorio(NumeroAleatorio numero) {
        int cantidadDigitos = String.valueOf(numero).length();
        String cadenaDeNumeros = "";
        for(int i = 0; i < cantidadDigitos; i++){
            cadenaDeNumeros += (int) (Math.random() * 10);
        }
        return new NumeroAleatorio(Integer.parseInt(cadenaDeNumeros));
    }
}