package com.duoc.rent_a_car.entites.client;
//EN ESTA CLASE ALMACENARE MIS CONSTANSTES PARA REALIZAR CALCULOS

import com.duoc.rent_a_car.entites.cars.Vehiculo;
import java.util.Map.Entry;

public class Finanzas {

    private final Double IVA = 0.19;
    private final Double DESCUENTO_CLIENTE_NUEVO = 0.10;

    //METODO PARA APLICAR IVA SOBRE EL VALOR BASE DEL ARRIENDO DE UN AUTO
    public int aplicarIVA(int valorArriendo) {
        int valorConIva = (int) ((valorArriendo * IVA) + valorArriendo);
        return valorConIva;
    }

    //METODO QUE APLICARA DESCUENTOS A CLIENTES NUEVOS
    public int aplicarDescuentoClienteNuevo(int valorArriendo) {
        int valorConDescuento = (int) (valorArriendo - (valorArriendo * DESCUENTO_CLIENTE_NUEVO));
        return valorConDescuento;
    }
    
    public int calcularTotalServicio(int idCliente, OperacionesCliente operacionesCliente) {
        int valorTotalServicio = 0;
        //POR MEDIO DEL ID DETECTO EL CLIENTE ESPECIFICO DEL CUAL SE CALCULARA EL TOTAL DE SUS SERVICIOS 
        Cliente clienteEncontrado = operacionesCliente.obtenerClientePorId(idCliente);
        for(Entry<String, Vehiculo> vehiculoDetectado : clienteEncontrado.getListaVehiculos().entrySet()){
        valorTotalServicio += vehiculoDetectado.getValue().getValorArriendo();
        }
        
        return valorTotalServicio ;
    }

}
