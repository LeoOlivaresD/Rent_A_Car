package com.duoc.rent_a_car;

import com.duoc.rent_a_car.entites.cars.OperacionesVehiculo;
import com.duoc.rent_a_car.entites.client.Cliente;
import com.duoc.rent_a_car.entites.client.OperacionesCliente;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Rent_A_Car {

    static Scanner sc = new Scanner(System.in);
    static int opcionMenu = 0;
    static boolean romperBucle = false;
    static Cliente cliente = new Cliente();
    static OperacionesCliente operacionesCliente = new OperacionesCliente();
    static OperacionesVehiculo operacionesVehiculo = new OperacionesVehiculo();
    public static void main(String[] args) {

        menu();
    }

    public static void menu() {
        do {
            try {
                System.out.println("Elige alguna de las siguientes opciones, escribiendo el numero segun corresponda");
                System.out.println("1: Registrar usuario (selecciona esta opcion para poder arrendar vehiculos.)\n"
                        + "2: Mostrar tarifas de arriendo.\n"
                        + "3: Arrendar vehiculo.\n"
                        + "4: Ver listado de vehiculos arrendados.\n"
                        + "5: Ver vehiculos arrendados por mas de una semana.\n"
                        + "6: Sair del sistema.");
                opcionMenu = sc.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("ERROR, debe ingresar un NUMERO para validar la opcion ingresada");
                sc.next(); //limpio el buffer
            }
            switch (opcionMenu) {
                //REGISTRO USUARIO
                case 1:
                    operacionesCliente.registrarUsuario(cliente);
                    break;
                // MOSTRAR TARIFAS DE ARRIENDO
                case 2:
                    break;
                //ARRENDAR VEHICULO
                case 3:
                    operacionesCliente.mostrarClientes(); //muestro los clientes registradoss
                    System.out.println("Ingrese el id del usuario que desea arrendar un vehiculo");
                    int idClienteSeleccionado = sc.nextInt();
                   operacionesVehiculo.arrendarVehiculo(idClienteSeleccionado, operacionesCliente);
                    break;
                //VER LISTADO DE VEHICULOS ARRENDADOS
                case 4:
                    break;
                //VER ARRIENDOS DE MAS DE UNA SEMANA
                case 5:
                    break;
                //SALIR
                case 6:
                    System.out.println("Saliendo del sistema, gracias por preferir\n"
                            + "Rent a Car Brief Drive.");
                    romperBucle = true;
                    break;
                //ELECCION INCORRECTA
                default:
                    System.out.println("Lo sentimos, la opcion ingresada no existe");
            }
        } while (!romperBucle);
        sc.close();//Se cierra el objeto
    }
}
