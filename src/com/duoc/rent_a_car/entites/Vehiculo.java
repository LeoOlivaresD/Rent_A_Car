package com.duoc.rent_a_car.entites;


public abstract class Vehiculo {
    private String patente;
    private Integer capacidadPasajeros;
    private String marca;
    private String anio;
    private String modelo;

    public Vehiculo() {
    }

    public Vehiculo(String patente, Integer capacidadPasajeros, String marca, String anio, String modelo) {
        this.patente = patente;
        this.capacidadPasajeros = capacidadPasajeros;
        this.marca = marca;
        this.anio = anio;
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(Integer capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", capacidadPasajeros=" + capacidadPasajeros + ", marca=" + marca + ", anio=" + anio + ", modelo=" + modelo + '}';
    }
    
    //Metodo abstracto
    public abstract void showDataCar();
}
