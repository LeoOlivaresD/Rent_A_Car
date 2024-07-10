package com.duoc.rent_a_car.entites.client;

import com.duoc.rent_a_car.entites.cars.Vehiculo;
import java.util.Map;

public class Cliente {
    private Integer idCliente;
    private String nombreCliente;
    private Vehiculo vehiculo;
    private Map<String,Vehiculo> listaVehiculos;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombreCliente, Vehiculo vehiculo, Map<String, Vehiculo> listaVehiculos) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.vehiculo = vehiculo;
        this.listaVehiculos = listaVehiculos;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Map<String, Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(Map<String, Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", vehiculo=" + vehiculo + ", listaVehiculos=" + listaVehiculos + '}';
    }
    
}
