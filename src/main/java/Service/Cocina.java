package Service;

import Modelos.Pedido;

public class Cocina {

    // Constructor vacío implícito (es buena práctica declararlo)
    public Cocina() {}

    public void prepararPedido(Pedido pedido, Cajero cajero) {
        System.out.println("\n--- PASO 4: Cocina procesa el pedido ---");
        System.out.println("[Cocina] Recibiendo ticket de pedido...");

        pedido.cambiarEstado("En preparación");
        pedido.cambiarEstado("Listo");

        cajero.notificarPedidoListo();
    }
}