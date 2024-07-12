package com.duoc.rent_a_car.entites.cars;

import com.duoc.rent_a_car.entites.client.Cliente;
import com.duoc.rent_a_car.entites.client.OperacionesCliente;
import com.duoc.rent_a_car.interfaces.IGenerarPatenteVehiculo;
import com.duoc.rent_a_car.interfaces.IOperacionesFinancieras;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class OperacionesVehiculo implements IOperacionesFinancieras , IGenerarPatenteVehiculo{

    @Override
    public void arrendarVehiculo(int idCliente, OperacionesCliente operacionesCliente) {
        //EN ESTA LINEA CAPTURO UN CLIENTE BUSCADO EN LA LISTA DE CLIENTES POR MEDIO DE UN ID
        Cliente clienteActual = operacionesCliente.obtenerClientePorId(idCliente);
        try {
            System.out.println("Por favor elija la categoria del vehiculo que desea arrendar escribiendo el numero segun corresponda");
            System.out.println("1: Turismo. \n"
                    + "2: Carga pesada. \n"
                    + "3: Auto particular. ");
            Scanner sc = new Scanner(System.in);
            int opcionCategoria = sc.nextInt();
            switch (opcionCategoria) {
                case 1:
                    Furgon furgon = new Furgon(generarPatente(), 10 , "Toyota", "Turismo", 60000, "Furgon");
                    System.out.println("Modelo para arrendar:");
                    System.out.println(furgon.toString());
                    clienteActual.getListaVehiculos().put(furgon.getPatente(), furgon);
                    System.out.println("Imprimiendo lista de vehiculos de cliente " + clienteActual.getNombreCliente());
                    //ITERO SOBRE EL HASHMAP DE VEHICULOS QUE POSEE EL CLIENTE
                    for (Entry<String,Vehiculo> e : clienteActual.getListaVehiculos().entrySet()){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                default:
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR debe ingresar un numero del 1 al 3");
        }

    }

    @Override
    public void calcularIva() {

    }

    @Override
    public void aplicarDescuento() {

    }

    @Override
    public void mostrarDetalleBoleta() {

    }

    @Override
    public String generarPatente() {
        Random numero = new Random();
        int min = 1;
        int max = 1000;
        int patenteNumero = numero.nextInt(max - min + 1)+ min;
        String patenteAString = String.valueOf(patenteNumero);
        String patenteGenerada = "FG-" + patenteAString;
        return patenteGenerada;
    }

}
