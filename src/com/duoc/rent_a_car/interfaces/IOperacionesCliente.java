package com.duoc.rent_a_car.interfaces;

import com.duoc.rent_a_car.entites.client.Cliente;

public interface IOperacionesCliente {

    public void registrarUsuario(Cliente cliente);
    public Cliente obtenerClientePorId(int idCliente);
    
}