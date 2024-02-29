package org.example;

public class Url {
    String url;
    String cadenaAleatoria;

    public Url(String url, String cadenaAleatoria){
        this.url = url;
        this.cadenaAleatoria = cadenaAleatoria;
    }

    public String getUrl(){
        return url;
    }

    public String getCadenaAleatoria(){
        return cadenaAleatoria;
    }
}
