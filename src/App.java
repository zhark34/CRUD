import java.util.ArrayList;
import java.util.Scanner;

import model.Articulo;
import service.ServiceArticulo;
import utils.Utils;

public class App {
    static ArrayList<Articulo> articulos = new ArrayList<>();

    private static void mostrarMenu(String titulo, String... opciones) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("        " + titulo);
        System.out.println("========================================");
        for (String opcion : opciones) {
            System.out.println(opcion);
        }
        System.out.println("========================================");
    }

    public static void main(String[] args) throws Exception {
        int input;
        Scanner scanner = new Scanner(System.in);

        do {
            mostrarMenu("CRUD DE ARTÍCULOS",
                    "1. Crear artículo",
                    "2. Listar todos los artículos",
                    "3. Consultar un artículo",
                    "4. Modificar un artículo",
                    "5. Eliminar un artículo",
                    "6. Salir");
            input = Utils.leerEntero(scanner, "Ingrese la acción que desea realizar: ");

            switch (input) {
                case 1:
                    ServiceArticulo.agregarArticulo(scanner, articulos);
                    break;
                case 2:
                    ServiceArticulo.listaArticulos(scanner, articulos);
                    break;
                case 3:
                    ServiceArticulo.consultarArticulo(scanner, articulos);
                    break;
                case 4:
                    ServiceArticulo.modificarArticulo(scanner, articulos);
                    break;
                case 5:
                    ServiceArticulo.eliminarArticulo(scanner, articulos);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (input != 6);
    }
}
