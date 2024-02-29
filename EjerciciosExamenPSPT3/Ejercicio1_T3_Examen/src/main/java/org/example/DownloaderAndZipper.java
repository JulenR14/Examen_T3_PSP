package org.example;

import javafx.collections.ListChangeListener;

/**
 * Esta clase implementa ListChangeListener y es responsable de manejar los cambios en la lista de URLs.
 * Proporciona retroalimentación al usuario sobre el estado de las URLs que se están procesando.
 */
public class DownloaderAndZipper implements ListChangeListener<Url> {

    /**
     * Este método se llama cada vez que ocurre un cambio en la lista de URLs.
     * Proporciona retroalimentación al usuario sobre el estado de las URLs que se están procesando.
     * Si la última URL en la lista es un espacio, indica que el usuario desea proceder con la descarga y compresión de los archivos.
     * De lo contrario, indica que la URL ha sido encolada para su procesamiento.
     * @param change El cambio que ha ocurrido en la lista.
     */
    @Override
    public void onChanged(Change<? extends Url> change) {

        if(change.getList().get(change.getList().size()-1).getUrl().equals(" ")){
            System.out.println("Se va a proceder a descargar y comprimir los ficheros");
        }else{
            System.out.println(change.getList().get(change.getList().size()-1).getUrl() + " encolado como " + change.getList().get(change.getList().size()-1).getCadenaAleatoria());
        }
    }

}