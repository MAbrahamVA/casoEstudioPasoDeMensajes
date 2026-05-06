package Modelos;

import Service.Cajero;
import Service.Cocina;
import java.util.List;

public class Cliente {
    private String nombre;

    // Constructor vacío
    public Cliente() {}

    // Constructor con parámetros
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Comportamiento
    public void hacerPedido(Cajero cajero, List<Producto> productosDeseados, Cocina cocina) {
        System.out.println("--- PASO 1: Cliente realiza pedido ---");
        System.out.println("[Cliente " + this.getNombre() + "] Hola, quiero hacer un pedido.");

        cajero.recibirPedido(this, productosDeseados, cocina);
    }

    public void recibirNotificacion(String mensaje) {
        System.out.println("[Cliente " + this.getNombre() + "] Escucha: '" + mensaje + "' -> Va a recoger su pedido.");
    }
}