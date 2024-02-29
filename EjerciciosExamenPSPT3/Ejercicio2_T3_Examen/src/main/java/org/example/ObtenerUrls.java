package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Esta clase es responsable de obtener URLs de la entrada del usuario y agregarlas a una ObservableList.
 * También genera una cadena aleatoria para cada URL y asegura su unicidad.
 */
public class ObtenerUrls {

    DownloaderAndZipper downloaderAndZipper = new DownloaderAndZipper();
    Scanner scanner = new Scanner(System.in);
    // ObservableList para almacenar objetos Url
    ObservableList<Url> urls = FXCollections.observableArrayList();

    /**
     * Este método solicita al usuario URLs y las agrega a la ObservableList.
     * También genera una cadena aleatoria única para cada URL.
     * El proceso continúa hasta que el usuario escribe 'exit'.
     */
    public void pedirUrls(){
        urls.addListener(downloaderAndZipper);
        System.out.println("Si quieres terminar el programa escribe 'exit'\nSi quieres que se descarguen las urls deja un espacio en blanco y presiona enter");
        String url;
        String cadenaAleatoria;
        do{
            System.out.print("Escribe la url : ");
            url = scanner.nextLine();
            if(!url.equals("exit")){
                cadenaAleatoria = cadenaAleatoria20caracteres();

                while(comprobarSiCadenaAleatoriaExiste(cadenaAleatoria)){
                    cadenaAleatoria = cadenaAleatoria20caracteres();
                }
                urls.add(new Url(url, cadenaAleatoria));
            }
        }while(!url.equals("exit"));
    }

    /**
     * Este método verifica si la cadena aleatoria dada ya existe en la ObservableList.
     * @param cadenaAleatoria La cadena aleatoria a verificar.
     * @return verdadero si la cadena aleatoria existe, falso en caso contrario.
     */
    public boolean comprobarSiCadenaAleatoriaExiste(String cadenaAleatoria){
        for (Url url : urls) {
            if(url.getCadenaAleatoria().equals(cadenaAleatoria)){
                return true;
            }
        }
        return false;

    }

    /**
     * Este método genera una cadena aleatoria de 20 caracteres.
     * @return La cadena aleatoria generada.
     */
    public String cadenaAleatoria20caracteres(){
        String cadena = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String cadenaAleatoria = "";
        for (int x = 0; x < 20; x++) {
            int indiceAleatorio = (int) (Math.random() * cadena.length());
            cadenaAleatoria += cadena.charAt(indiceAleatorio);
        }
        return cadenaAleatoria.toString();
    }

}