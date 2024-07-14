package com.duoc.rent_a_car.interfaces;

import com.duoc.rent_a_car.entites.cars.Vehiculo;
import com.duoc.rent_a_car.entites.client.OperacionesCliente;
import java.util.Map;

public interface IOperacionesVehiculo {
    public String generarPatente();
    public void arrendarVehiculo(int idCliente, OperacionesCliente operacionesCliente);
    public Map<String,Vehiculo> listarTodosVehiculos();
    public Vehiculo buscarVehiculoPorPatente(String patente);
}
