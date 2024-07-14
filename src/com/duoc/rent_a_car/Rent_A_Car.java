package com.duoc.rent_a_car;

import com.duoc.rent_a_car.entites.cars.OperacionesVehiculo;
import com.duoc.rent_a_car.entites.client.Finanzas;
import com.duoc.rent_a_car.entites.client.OperacionesCliente;
import com.duoc.rent_a_car.inputs.ClientPersistentInput;
import com.duoc.rent_a_car.inputs.VehiclePersistentInput;
import com.duoc.rent_a_car.outputs.ClientPersistentOutput;
import com.duoc.rent_a_car.outputs.VehiclePersistentOuput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Rent_A_Car {

    static ClientPersistentOutput clientPersistent = new ClientPersistentOutput();
    static ClientPersistentInput clientPersistentInput = new ClientPersistentInput();
    static VehiclePersistentInput input = new VehiclePersistentInput();
    static VehiclePersistentOuput ouput = new VehiclePersistentOuput();
    static OperacionesCliente operacionesCliente = new OperacionesCliente();
    static OperacionesVehiculo operacionesVehiculo = new OperacionesVehiculo();
    static Finanzas finanzas = new Finanzas();
    static Scanner sc = new Scanner(System.in);
    static int opcionMenu = 0;
    static boolean romperBucle = false;
    static String archivo = "lista_clientes.txt";

    public static void main(String[] args) {
        clientPersistentInput.cargarClienteDesdeTxt(operacionesCliente, archivo);
        menu();
    }

    public static void menu() {
        do {
            try {
                System.out.println("====================================================================================================");
                System.out.println("|                  BriefDrive                                                                      |");
                System.out.println("====================================================================================================");
                System.out.println("| Elige alguna de las siguientes opciones, escribiendo el numero segun corresponda                   |");
                System.out.println("| 1: Registrar usuario (selecciona esta opcion para poder arrendar vehiculos.)                     |");
                System.out.println("| 2: Mostrar tarifas de arriendo.                                                                  |");
                System.out.println("| 3: Arrendar vehiculo.                                                                            |");
                System.out.println("| 4: Ver listado de vehiculos arrendados.                                                          |");
                System.out.println("| 5: Ver vehiculos arrendados por mas de una semana.                                               |");
                System.out.println("| 6: Sair del sistema.                                                                             |");
                System.out.println("====================================================================================================");

                opcionMenu = sc.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("ERROR, debe ingresar un NUMERO para validar la opcion ingresada");
                sc.next(); //limpio el buffer
            }
            switch (opcionMenu) {
                //REGISTRO USUARIO
                case 1:
                    operacionesCliente.registrarUsuario(clientPersistent);
                    break;

                //MOSTRAR TARIFAS DE ARRIENDO
                case 2:

                    break;

                //ARRENDAR VEHICULO
                case 3:
                    operacionesCliente.mostrarClientes(); //muestro los clientes registradoss
                    System.out.println("Ingrese el id del usuario que desea arrendar un vehiculo");
                    int idClienteSeleccionado = sc.nextInt();
                    operacionesVehiculo.arrendarVehiculo(idClienteSeleccionado, operacionesCliente, ouput);
                    break;

                //VER LISTADO DE VEHICULOS ARRENDADOS
                case 4:
                    operacionesVehiculo.listarTodosVehiculos();
                    break;
                //VER ARRIENDOS DE MAS DE UNA SEMANA
                case 5:
                    String patente;
                    System.out.println("Buscando un auto por patente, ingrese patente");
                    patente = sc.nextLine();
                    operacionesVehiculo.buscarVehiculoPorPatente(patente);
                    break;
                //SALIR
                case 6:
                    System.out.println("Ingrese el id del cliente deseaado para generar boleta");
                    int idCliente = sc.nextInt();
                    operacionesCliente.generarBoleta(idCliente, finanzas, operacionesVehiculo);
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
