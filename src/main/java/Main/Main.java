package Main;

import Modelos.Cliente;
import Modelos.Producto;
import Service.Cajero;
import Service.Cocina;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println(" SISTEMA DE GESTIÓN DE CAFETERÍA");
        System.out.println("=============================================\n");

        // 1. Configuración de la Infraestructura
        System.out.print("Ingrese el nombre del Cajero en turno: ");
        String nombreCajero = scanner.nextLine();

        // Uso de constructor vacío y setter
        Cajero cajero = new Cajero();
        cajero.setNombre(nombreCajero);

        Cocina cocina = new Cocina();

        // 2. Base de datos simulada (Menú disponible)
        List<Producto> menu = new ArrayList<>();
        menu.add(new Producto("Café Americano", 2.50));
        menu.add(new Producto("Latte Vainilla", 3.20));
        menu.add(new Producto("Sándwich de Pavo", 4.00));
        menu.add(new Producto("Croissant", 1.80));

        boolean sistemaActivo = true;

        // 3. Bucle principal del sistema (Punto de entrada continuo)
        while (sistemaActivo) {
            System.out.println("\n--- NUEVO PEDIDO ---");
            System.out.print("Ingrese el nombre del Cliente (o escriba 'salir' para apagar el sistema): ");
            String nombreCliente = scanner.nextLine();

            if (nombreCliente.equalsIgnoreCase("salir")) {
                sistemaActivo = false;
                System.out.println("Apagando el sistema. ¡Buen turno, " + cajero.getNombre() + "!");
                continue;
            }

            // Instancia dinámica del cliente usando setter
            Cliente cliente = new Cliente();
            cliente.setNombre(nombreCliente);

            List<Producto> productosDeseados = new ArrayList<>();
            boolean tomandoOrden = true;

            // 4. Lógica de selección de productos
            while (tomandoOrden) {
                System.out.println("\nMenú Disponible:");
                for (int i = 0; i < menu.size(); i++) {
                    System.out.println((i + 1) + ". " + menu.get(i).getNombre() + " - $" + menu.get(i).getPrecio());
                }
                System.out.println("0. Terminar orden y procesar");
                System.out.print("Seleccione el número del producto: ");

                try {
                    int opcion = Integer.parseInt(scanner.nextLine());

                    if (opcion == 0) {
                        tomandoOrden = false;
                    } else if (opcion > 0 && opcion <= menu.size()) {
                        Producto productoSeleccionado = menu.get(opcion - 1);
                        productosDeseados.add(productoSeleccionado);
                        System.out.println("  [+] " + productoSeleccionado.getNombre() + " añadido a la bandeja.");
                    } else {
                        System.out.println("  [!] Opción inválida. Seleccione un número del menú.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("  [!] Error: Por favor, ingrese un número válido.");
                }
            }

            // 5. Disparador del flujo de mensajes
            if (!productosDeseados.isEmpty()) {
                System.out.println("\n=============================================");
                System.out.println("        EJECUTANDO FLUJO DE PASO DE MENSAJES ");
                System.out.println("=============================================\n");

                // Aquí es donde el Main actúa como orquestador y delega el trabajo a los objetos
                cliente.hacerPedido(cajero, productosDeseados, cocina);

                System.out.println("\n=============================================");
            } else {
                System.out.println("\n[Sistema] El cliente " + cliente.getNombre() + " no ordenó ningún producto y se retiró.");
            }
        }

        scanner.close();
    }
}