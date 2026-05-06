package Service;

import Modelos.Cliente;
import Modelos.Pedido;
import Modelos.Producto;
import java.util.List;

public class Cajero {
    private String nombre;
    private Cliente clienteActual;

    // Constructor vacío
    public Cajero() {}

    // Constructor con parámetros
    public Cajero(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }

    // Comportamiento
    public void recibirPedido(Cliente cliente, List<Producto> productosDeseados, Cocina cocina) {
        this.setClienteActual(cliente); // Usando setter

        System.out.println("\n--- PASO 2: Cajero registra el pedido ---");
        System.out.println("[Cajero " + this.getNombre() + "] Atendiendo a " + this.getClienteActual().getNombre());

        Pedido nuevoPedido = new Pedido();
        for (Producto p : productosDeseados) {
            nuevoPedido.agregarProducto(p);
        }

        enviarACocina(nuevoPedido, cocina);
    }

    public void enviarACocina(Pedido pedido, Cocina cocina) {
        System.out.println("\n--- PASO 3: Cajero envía el pedido a cocina ---");
        System.out.println("[Cajero " + this.getNombre() + "] Transfiriendo orden a preparación.");

        cocina.prepararPedido(pedido, this);
    }

    public void notificarPedidoListo() {
        System.out.println("\n[Cajero " + this.getNombre() + "] Recibió alerta de la cocina.");
        notificarCliente();
    }

    public void notificarCliente() {
        System.out.println("\n--- PASO 5: Cajero notifica al cliente ---");
        System.out.println("[Cajero " + this.getNombre() + "] Llamando por altavoz a " + this.getClienteActual().getNombre() + "...");

        this.getClienteActual().recibirNotificacion("¡Su pedido está listo para recoger en barra!");
    }
}