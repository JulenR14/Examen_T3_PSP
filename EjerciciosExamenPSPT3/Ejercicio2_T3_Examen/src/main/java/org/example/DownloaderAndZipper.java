package org.example;

import javafx.collections.ListChangeListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Esta clase implementa ListChangeListener y es responsable de descargar y comprimir URLs.
 * Escucha los cambios en la ObservableList de objetos Url y realiza acciones en consecuencia.
 */
public class DownloaderAndZipper implements ListChangeListener<Url> {

    // Directorio donde se almacenarán las páginas web descargadas
    Path directorioWebs = Paths.get("src/webs");

    /**
     * Este método se llama cada vez que se realiza un cambio en la ObservableList de objetos Url.
     * Descarga y comprime las URLs, o las encola para su posterior procesamiento.
     * @param change El cambio que ocurrió.
     */
    @Override
    public void onChanged(Change<? extends Url> change) {

        if(change.getList().get(change.getList().size()-1).getUrl().equals(" ")){
            System.out.println("Se va a proceder a descargar y comprimir los ficheros");
            System.out.println("Se han descargado " + (change.getList().size()-1) + " ficheros");
            change.getList().forEach(url ->{
                if(!url.getUrl().equals(" ")){
                    descargarWeb(url.getUrl(), url.getCadenaAleatoria());
                    try {
                        comprimirCarpeta(new File("src/webs"), "webs", new ZipOutputStream(new FileOutputStream("src/webs.zip")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } );
        }else{
            System.out.println(change.getList().get(change.getList().size()-1).getUrl() + " encolado como " + change.getList().get(change.getList().size()-1).getCadenaAleatoria());
        }
    }

    /**
     * Este método descarga una página web de una URL dada y la guarda en un archivo local.
     * El archivo se nombra con una cadena aleatoria.
     * @param url La URL para descargar.
     * @param cadenaAleatoria La cadena aleatoria para nombrar el archivo.
     */
    public void descargarWeb(String url, String cadenaAleatoria){
        HttpClient client = HttpClient.newHttpClient();

        try {
            if (Files.notExists(directorioWebs)) {
                Files.createDirectory(directorioWebs);
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Path fichero = directorioWebs.resolve(cadenaAleatoria + ".html");

            Files.writeString(fichero, response.body(), StandardCharsets.UTF_8);
        }catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("ALGO HA SALIDO MAL, VUELVE A INTENTARLO");
        }
    }

    /**
     * Este método comprime un directorio dado en un archivo zip.
     * @param fichero1 El directorio a comprimir.
     * @param nombreFichero El nombre del archivo zip.
     * @param zipOut El ZipOutputStream para escribir el archivo zip.
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void comprimirCarpeta(File fichero1, String nombreFichero, ZipOutputStream zipOut) throws IOException {

        if (fichero1.isHidden()){
            return;
        }
        if(nombreFichero.endsWith("/")){
            zipOut.putNextEntry(new ZipEntry(nombreFichero));
            zipOut.closeEntry();
        }else {
            zipOut.putNextEntry(new ZipEntry(nombreFichero + "/"));
            zipOut.closeEntry();
        }
        File[] ficheros = fichero1.listFiles();
        for (File fichero : ficheros){
            FileInputStream fis = new FileInputStream(fichero);
            ZipEntry zipEntry = new ZipEntry(nombreFichero + "/" + fichero.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0){
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
    }
}