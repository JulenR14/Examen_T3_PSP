# Ejercicio3T3Examen

Este proyecto es una aplicación Spring Boot que proporciona una API REST para generar y actualizar números aleatorios.

## Características

- Genera una lista de 100 números aleatorios.
- Genera un número aleatorio con un número especificado de dígitos.
- Actualiza un número aleatorio.

## Endpoints

- `GET /random/numbers`: Devuelve una lista de 100 números aleatorios.
- `GET /random/number/{digitos}`: Devuelve un número aleatorio con un número especificado de dígitos.
- `PUT /random/number`: Actualiza un número aleatorio.

## Cómo ejecutar

Para ejecutar este proyecto, necesitarás tener instalado Java y Maven. Luego, puedes clonar el repositorio y ejecutar el siguiente comando en la raíz del proyecto:

```bash
mvn spring-boot:run
```

Esto iniciará la aplicación en el puerto 8080.