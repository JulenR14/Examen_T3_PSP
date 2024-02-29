# Proyecto de Descarga y Compresión de URLs

Este proyecto está escrito en Java y utiliza Maven como herramienta de construcción. El objetivo principal del proyecto es descargar páginas web a partir de URLs proporcionadas por el usuario, almacenarlas localmente y luego comprimirlas en un archivo zip.

## Clases Principales

El proyecto consta de las siguientes clases principales:

- `Main`: Esta es la clase principal que inicia la ejecución del programa. Crea una instancia de la clase `ObtenerUrls` y llama al método `pedirUrls()`.

- `ObtenerUrls`: Esta clase es responsable de obtener URLs de la entrada del usuario y agregarlas a una ObservableList. También genera una cadena aleatoria para cada URL y asegura su unicidad.

- `Url`: Esta clase representa una URL con una cadena aleatoria asociada. Se utiliza para almacenar las URLs proporcionadas por el usuario y las cadenas aleatorias generadas.

- `DownloaderAndZipper`: Esta clase implementa `ListChangeListener` y es responsable de descargar y comprimir las URLs. Escucha los cambios en la ObservableList de objetos Url y realiza acciones en consecuencia.

## Cómo usar

Para usar este proyecto, simplemente ejecute la clase `Main`. Se le pedirá que ingrese URLs una por una. Después de ingresar cada URL, se generará una cadena aleatoria única y se agregará a la lista junto con la URL. Cuando termine de ingresar URLs, escriba 'exit' para iniciar el proceso de descarga y compresión.

## Dependencias

Este proyecto depende de las siguientes bibliotecas:

- `java.net.http.HttpClient`: para enviar solicitudes HTTP y recibir respuestas.
- `java.nio.file`: para operaciones de archivos y directorios.
- `java.util.zip`: para operaciones de compresión y descompresión.
- `javafx.collections.ObservableList` y `javafx.collections.ListChangeListener`: para almacenar las URLs y escuchar los cambios en la lista.
