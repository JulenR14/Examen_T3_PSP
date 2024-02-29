package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Creamos la instancia de la clase que se encargara de pedir las urls
        ObtenerUrls obtenerUrls = new ObtenerUrls();

        //Llamamos al metodo que se encargara de pedir las urls
        obtenerUrls.pedirUrls();
    }
}