package com.duoc.rent_a_car.entites;


public abstract class Vehiculo {
    private String patente;
    private Integer capacidadPasajeros;
    private String marca;
    private String categoria;
    private Integer valorArriendo;
    
    public Vehiculo() {
    }

    public Vehiculo(String patente, Integer capacidadPasajeros, String marca, String categoria, Integer valorArriendo) {
        this.patente = patente;
        this.capacidadPasajeros = capacidadPasajeros;
        this.marca = marca;
        this.categoria = categoria;
        this.valorArriendo = valorArriendo;
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

    public Integer getValorArriendo() {
        return valorArriendo;
    }

    public void setValorArriendo(Integer valorArriendo) {
        this.valorArriendo = valorArriendo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", capacidadPasajeros=" + capacidadPasajeros + ", marca=" + marca + ", categoria=" + categoria + ", valorArriendo=" + valorArriendo + '}';
    }

    //Metodo abstracto
    public abstract void showDataCar();
}
