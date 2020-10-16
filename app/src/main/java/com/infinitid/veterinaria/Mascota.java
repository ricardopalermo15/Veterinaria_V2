package com.infinitid.veterinaria;

public class Mascota {

    private int foto;
    private String nombre;
    private String valor;

    public Mascota(int foto, String nombre, String valor) {
        this.foto = foto;
        this.nombre = nombre;
        this.valor = valor;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
