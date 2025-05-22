package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.*;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        Estacionamiento estacionamiento = new Estacionamiento();
        //TO DO test
        String dni = "1234";
        String nombre = "sofi";
        String patente = "4578";
        Vehiculo vehiculo = new Vehiculo(patente, "fiat", Vehiculo.Tipo.AUTO);

        boolean ingreso = estacionamiento.ingresarVehiculo(dni, nombre, vehiculo);
        assertTrue(ingreso);
        Ticket salida = estacionamiento.retirarVehiculo(patente);
        assertNotNull(salida);
        assertEquals(patente, salida.getVehiculo().getPatente());
        assertNotNull(salida.getHoraSalida());

    }


    @Test
    public void testCalcularPrecio() throws Exception {
        // TO DO test
        Cliente cliente = new Cliente("1234","sofi");
        String patente = "4578";
        Vehiculo vehiculo = new Vehiculo(patente, "fiat", Vehiculo.Tipo.AUTO);

        Ticket ticket = new Ticket(cliente, vehiculo);
        ticket.setHoraSalida(LocalDateTime.now().plusMinutes(110));
        double precioFinal = ticket.calcularPrecio();
        assertNotNull(precioFinal);
        assertEquals(200.0, precioFinal);


    }
    @Test
    public void testCalcularPrecio_PICKUP() throws Exception {
        // TO DO test
        Cliente cliente = new Cliente("1234","sofi");
        String patente = "4578";
        Vehiculo vehiculo = new Vehiculo(patente, "fiat", Vehiculo.Tipo.PICKUP);

        Ticket ticket = new Ticket(cliente, vehiculo);
        ticket.setHoraSalida(LocalDateTime.now().plusMinutes(110));
        double precioFinal = ticket.calcularPrecio();
        assertNotNull(precioFinal);
        assertEquals(360.0, precioFinal);


    }
    @Test
    public void testCalcularPrecio_SUV() throws Exception {
        // TO DO test
        Cliente cliente = new Cliente("1234","sofi");
        String patente = "4578";
        Vehiculo vehiculo = new Vehiculo(patente, "fiat", Vehiculo.Tipo.SUV);

        Ticket ticket = new Ticket(cliente, vehiculo);
        ticket.setHoraSalida(LocalDateTime.now().plusMinutes(110));
        double precioFinal = ticket.calcularPrecio();
        assertNotNull(precioFinal);
        assertEquals(260.0, precioFinal);


    }

}