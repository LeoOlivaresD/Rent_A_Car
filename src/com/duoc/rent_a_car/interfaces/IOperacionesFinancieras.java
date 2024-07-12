package com.duoc.rent_a_car.interfaces;
import com.duoc.rent_a_car.entites.client.OperacionesCliente;

public interface IOperacionesFinancieras {

    public void arrendarVehiculo(int idCliente, OperacionesCliente operacionesCliente);

    public void calcularIva();

    public void aplicarDescuento();

    public void mostrarDetalleBoleta();
}
