# Proyecto de Descarga y Compresión de URLs

Este proyecto es una aplicación de consola Java que permite al usuario ingresar URLs, las cuales se descargarán y comprimirán en un archivo ZIP.

## Estructura del Proyecto

El proyecto consta de las siguientes clases:

- `Main`: Esta es la clase principal que inicia la aplicación. Crea una instancia de la clase `ObtenerUrls` y llama al método `pedirUrls()`.

- `ObtenerUrls`: Esta clase es responsable de obtener URLs de la entrada del usuario y agregarlas a una ObservableList. También genera una cadena aleatoria para cada URL y asegura su unicidad.

- `DownloaderAndZipper`: Esta clase implementa `ListChangeListener` y es responsable de manejar los cambios en la lista de URLs. Proporciona retroalimentación al usuario sobre el estado de las URLs que se están procesando.

- `Url`: Esta clase representa una URL con una cadena aleatoria asociada.

## Cómo usar

1. Ejecute la aplicación. Se le pedirá que ingrese URLs.

2. Ingrese una URL y presione Enter. La URL se agregará a la lista y se generará una cadena aleatoria única para ella.

3. Repita el paso 2 para todas las URLs que desea descargar y comprimir.

4. Cuando haya terminado de ingresar URLs, escriba 'exit' y presione Enter. La aplicación comenzará a descargar y comprimir las URLs.

## Dependencias

- Java 8 o superior
- Maven
- JavaFX

## Cómo compilar

Este es un proyecto Maven y se puede compilar utilizando el comando `mvn clean install`