package com.duoc.rent_a_car.entites.cars;

import com.duoc.rent_a_car.entites.client.Cliente;
import com.duoc.rent_a_car.entites.client.OperacionesCliente;
import com.duoc.rent_a_car.interfaces.IOperacionesFinancieras;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import com.duoc.rent_a_car.interfaces.IOperacionesVehiculo;
import java.util.Collections;
import java.util.List;

public class OperacionesVehiculo implements IOperacionesFinancieras, IOperacionesVehiculo {
private Map<String,Vehiculo> syncList;

    public OperacionesVehiculo() {
    }


    public OperacionesVehiculo(Map<String, Vehiculo> syncList) {
        this.syncList = syncList;
    }

    @Override
    public String generarPatente() {
        Random numero = new Random();
        int min = 1;
        int max = 1000;
        int patenteNumero = numero.nextInt(max - min + 1) + min;
        String patenteAString = String.valueOf(patenteNumero);
        String patenteGenerada = "FG-" + patenteAString;
        return patenteGenerada;
    }

    @Override
    public void arrendarVehiculo(int idCliente, OperacionesCliente operacionesCliente) {
        //EN ESTA LINEA CAPTURO UN CLIENTE BUSCADO EN LA LISTA DE CLIENTES POR MEDIO DE UN ID
        Cliente clienteActual = operacionesCliente.obtenerClientePorId(idCliente);
        if (clienteActual != null) {
            try {
                System.out.println("Por favor elija la categoria del vehiculo que desea arrendar escribiendo el numero segun corresponda");
                System.out.println("1: Turismo. \n"
                        + "2: Carga pesada. \n"
                        + "3: Auto particular. ");
                Scanner sc = new Scanner(System.in);
                int opcionCategoria = sc.nextInt();
                switch (opcionCategoria) {
                    case 1:
                        Furgon furgon = new Furgon(generarPatente(), 10, "Toyota", "Turismo", 60000, "Furgon");
                        System.out.println("Modelo para arrendar:");
                        System.out.println(furgon.toString());
                        clienteActual.getListaVehiculos().put(furgon.getPatente(), furgon);
                        syncList = Collections.synchronizedMap(clienteActual.getListaVehiculos()); //USO DE LISTA SYNCRONIZADA
                        System.out.println("Imprimiendo lista de vehiculos de cliente " + clienteActual.getNombreCliente());
                        //ITERO SOBRE EL HASHMAP DE VEHICULOS QUE POSEE EL CLIENTE
                        for (Entry<String, Vehiculo> e : clienteActual.getListaVehiculos().entrySet()) {
                            System.out.println(e);
                        }
                        System.out.println("ITERANDO SOBRE LISTA SINCRONIZADA");
                        for (Entry<String, Vehiculo> e : syncList.entrySet()) {
                            System.out.println(e);
                        }
                        break;
                    case 2:
                        Camion camion = new Camion("8 toneladas ",generarPatente(), 5, "Mercedez", "Carga pesada", 120000, "Camion");
                        System.out.println("Modelo para arrendar:");
                        System.out.println(camion.toString());
                        clienteActual.getListaVehiculos().put(camion.getPatente(), camion);
                        System.out.println("Imprimiendo lista de vehiculos de cliente " + clienteActual.getNombreCliente());
                        //ITERO SOBRE EL HASHMAP DE VEHICULOS QUE POSEE EL CLIENTE
                        for (Entry<String, Vehiculo> e : clienteActual.getListaVehiculos().entrySet()) {
                            System.out.println(e);
                        }
                        break;
                    case 3:
                        AutoSedan autoSedan = new AutoSedan(generarPatente(), 5, "Kia", "Particular", 50000, "Autmovil");
                        System.out.println("Modelo para arrendar:");
                        System.out.println(autoSedan.toString());
                        clienteActual.getListaVehiculos().put(autoSedan.getPatente(), autoSedan);
                        System.out.println("Imprimiendo lista de vehiculos de cliente " + clienteActual.getNombreCliente());
                        //ITERO SOBRE EL HASHMAP DE VEHICULOS QUE POSEE EL CLIENTE
                        for (Entry<String, Vehiculo> e : clienteActual.getListaVehiculos().entrySet()) {
                            System.out.println(e);
                        }
                        break;
                    default:
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR debe ingresar un numero del 1 al 3");
            }
        } else {
            System.out.println("Lo sentimos, el id ingresado no ha sido encontrado");
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
    public Map<String, Vehiculo> listarVehiculos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo listarVehiculoPorPatente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
