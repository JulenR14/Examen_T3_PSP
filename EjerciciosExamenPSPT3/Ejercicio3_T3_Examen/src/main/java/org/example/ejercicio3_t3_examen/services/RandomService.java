package org.example.ejercicio3_t3_examen.services;

import org.example.ejercicio3_t3_examen.models.NumeroAleatorio;

import java.util.List;

/**
 * Esta es una interfaz para el servicio RandomService.
 * Proporciona métodos para obtener y actualizar números aleatorios.
 */
public interface RandomService {

    /**
     * Este método devuelve una lista de números aleatorios.
     * @return Lista de objetos NumeroAleatorio.
     */
    List<NumeroAleatorio> getNumbers();

    /**
     * Este método devuelve un número aleatorio con un número especificado de dígitos.
     * @param digitos El número de dígitos para el número aleatorio.
     * @return Un objeto NumeroAleatorio.
     */
    NumeroAleatorio getNumeroAleatorio(int digitos);

    /**
     * Este método actualiza un número aleatorio.
     * @param numero El objeto NumeroAleatorio a actualizar.
     * @return El objeto NumeroAleatorio actualizado.
     */
    NumeroAleatorio actualizarNumeroAleatorio(NumeroAleatorio numero);
}