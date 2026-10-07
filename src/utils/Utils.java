package utils;
import java.util.ArrayList;
import java.util.Scanner;

import model.Pedido;
import model.Articulo;
import model.ArticuloElectronico;
import model.ArticuloAlimenticio;

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

    public static Articulo buscarArticuloPorId(ArrayList<Articulo> articulos, int id) {

        for (Articulo articulo : articulos) {
            if (articulo.getId() == id) {
                return articulo;
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

    public static Articulo crearArticulo(int id, String nombre, double precio, int stock, Scanner scanner, String mensaje){
        while (true) {
            System.out.print(mensaje);
            System.out.print("\n1-Crear artículo electrónico");
            System.out.print("\n2-Crear artículo alimenticio");
            System.out.print("\nIngrese una opcion: ");
            int valor = Integer.parseInt(scanner.nextLine());

            switch (valor) {
                case 1:
                    int garantiaMeses = leerEntero(scanner, "Ingrese la garantía del artículo: ");
                    Articulo articuloElectronico = new ArticuloElectronico(id, nombre, precio, stock, garantiaMeses);
                    return articuloElectronico;
                case 2:
                    int diasVencimiento = leerEntero(scanner, "Ingrese el vencimiento del artículo: ");
                    Articulo articuloAlimenticio = new ArticuloAlimenticio(id, nombre, precio, stock, diasVencimiento);
                    return articuloAlimenticio;
                default:
                    System.out.print("Ingrese una opcion valida");
            }

        }
    }

}
