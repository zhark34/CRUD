import java.util.ArrayList;
import java.util.Scanner;

import model.Pedido;
import model.Articulo;
import service.ServicePedido;
import service.ServiceArticulo;
import utils.Utils;

public class App {
    static ArrayList<Articulo> articulos = new ArrayList<>();
    static ArrayList<Pedido> pedidos = new ArrayList<>();

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
            mostrarMenu("BIENVENIDO",
                    "1. Artículos",
                    "2. Pedidos",
                    "3. Salir");
            input = Utils.leerEntero(scanner, "Seleccione una opción: ");

            switch (input) {
                case 1:
                    int inputCrud;
                    do {
                        mostrarMenu("CRUD DE ARTÍCULOS",
                                "1. Crear artículo",
                                "2. Listar todos los artículos",
                                "3. Consultar un artículo",
                                "4. Modificar un artículo",
                                "5. Eliminar un artículo",
                                "6. Salir");
                        inputCrud = Utils.leerEntero(scanner, "Ingrese la acción que desea realizar: ");

                        switch (inputCrud) {
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
                        }
                    } while (inputCrud != 6);
                    break;
                case 2:
                    int inputPedidos;
                    do {
                        mostrarMenu("PEDIDOS",
                                "1. Crear pedido",
                                "2. Listar todos los pedidos",
                                "3. Salir",
                                "");
                        inputPedidos = Utils.leerEntero(scanner, "Ingrese la acción que desea realizar: ");

                        switch (inputPedidos) {
                            case 1:
                                ServicePedido.crearPedido(scanner, articulos, pedidos);
                                break;
                            case 2:
                                ServicePedido.listarPedidos(scanner, pedidos);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opción inválida. Intente nuevamente.");
                        }
                    } while (inputPedidos != 3);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (input != 3);
    }
}
