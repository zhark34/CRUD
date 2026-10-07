package utils;
import java.util.ArrayList;
import java.util.Scanner;

import model.Pedido;
import model.Producto;
import model.ProductoElectronico;
import model.ProductoAlimento;

public class Utils {
    public static int leerEntero(Scanner scanner, String mensaje){
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    public static Producto buscarProductoPorId(ArrayList<Producto> productos, int id) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    public static Pedido buscarPedidoPorId(ArrayList<Pedido> pedidos, int id) {

        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }

        return null;
    }

    public static String leerTextoNoVacio(Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();

            if (!texto.trim().isEmpty()) {
                return texto.trim();
            }

            System.out.println("Error: el texto no puede estar vacío.");
        }
    }

    public static double leerDoubleNoNegativo(Scanner scanner, String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                double valor = Double.parseDouble(scanner.nextLine());

                if (valor < 0) {
                    System.out.println("Error: el precio no puede ser negativo.");
                    continue;
                }

                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número decimal válido.");
            }
        }
    }

    public static Producto crearProducto(int id, String nombre, double precio, int stock, Scanner scanner, String mensaje){
        while (true) {
            System.out.print(mensaje);
            System.out.print("\n1-Crear producto electronico");
            System.out.print("\n2-Crear producto alimenticio");
            System.out.print("\nIngrese una opcion: ");
            int valor = Integer.parseInt(scanner.nextLine());

            switch (valor) {
                case 1:
                    int garantiaMeses = leerEntero(scanner, "Ingrese la garantia del producto: ");
                    Producto productoElectronico = new ProductoElectronico(id, nombre, precio, stock, garantiaMeses);
                    return productoElectronico;
                case 2:
                    int diasVencimiento = leerEntero(scanner, "Ingrese el vencimiento del producto: ");
                    Producto productoAlimento = new ProductoAlimento(id, nombre, precio, stock, diasVencimiento);
                    return productoAlimento;
                default:
                    System.out.print("Ingrese una opcion valida");
            }

        }
    }

}
