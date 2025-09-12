package com.example.infogram.model;

public class Image {
    private String urlImagen;
    private String userName;
    private String cantidadDias;
    private String cantidadMeGusta;

    public Image(String urlImagen, String userName, String cantidadDias, String cantidadMeGusta) {
        this.setUrlImagen(urlImagen);
        this.setUserName(userName);
        this.setCantidadDias(cantidadDias);
        this.setCantidadMeGusta(cantidadMeGusta);
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(String cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public String getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setCantidadMeGusta(String cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }
}
