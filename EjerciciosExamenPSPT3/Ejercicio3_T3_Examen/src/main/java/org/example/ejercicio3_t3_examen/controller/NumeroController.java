package org.example.ejercicio3_t3_examen.controller;

import org.example.ejercicio3_t3_examen.models.NumeroAleatorio;
import org.example.ejercicio3_t3_examen.services.RandomService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Este es un controlador REST para gestionar números aleatorios.
 */
@RestController
public class NumeroController {

    // Servicio inyectado para manejar operaciones de números aleatorios
    @Autowired
    private RandomService randomService;

    /**
     * Este endpoint devuelve una lista de 100 números aleatorios.
     * @return ResponseEntity que contiene una lista de números aleatorios y el estado HTTP.
     */
    @GetMapping("/random/numbers")
    public ResponseEntity<List<NumeroAleatorio>> get100Numbers(){

        List<NumeroAleatorio> numeroAleatorio = randomService.getNumbers();

        return new ResponseEntity<>(numeroAleatorio, HttpStatus.OK);
    }

    /**
     * Este endpoint devuelve un número aleatorio con un número especificado de dígitos.
     * @param digitos El número de dígitos para el número aleatorio.
     * @return ResponseEntity que contiene un número aleatorio y el estado HTTP.
     */
    @GetMapping("/random/number/{digitos}")
    public ResponseEntity<NumeroAleatorio> getNumber(@PathVariable int digitos){

        NumeroAleatorio numeroAleatorio = randomService.getNumeroAleatorio(digitos);

        return new ResponseEntity<>(numeroAleatorio, HttpStatus.OK);
    }

    /**
     * Este endpoint actualiza un número aleatorio.
     * @param numero El número aleatorio a actualizar.
     * @return ResponseEntity que contiene el número aleatorio actualizado y el estado HTTP.
     */
    @PutMapping("/random/number")
    public ResponseEntity<NumeroAleatorio> updateNumber(@RequestBody NumeroAleatorio numero){

        NumeroAleatorio numeroAleatorio = randomService.actualizarNumeroAleatorio(numero);

        return new ResponseEntity<>(numeroAleatorio, HttpStatus.OK);
    }
}