package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // Atributos y Encapsulammiento
    private List<Producto> productos;
    private String estado;

    // Constructor vacío (inicializa la lista y el estado por defecto)
    public Pedido() {
        this.productos = new ArrayList<>();
        this.estado = "Registrado";
    }

    // Getters y Setters
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Métodos de comportamiento
    public void agregarProducto(Producto p) {
        this.productos.add(p);
        // Usamos el getter del producto
        System.out.println("      -> Producto agregado: " + p.getNombre());
    }

    public void cambiarEstado(String nuevoEstado) {
        this.setEstado(nuevoEstado); // Usamos el setter interno
        System.out.println("      [Sistema] Estado del pedido: '" + this.getEstado() + "'");
    }
}