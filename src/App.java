import java.util.ArrayList;
import java.util.Scanner;

import model.Pedido;
import model.Producto;
import service.ServicePedido;
import service.ServiceProducto;
import utils.Utils;

public class App {
    static ArrayList<Producto> productos = new ArrayList<>();
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
                    "1. Productos",
                    "2. Pedidos",
                    "3. Salir");
            input = Utils.leerEntero(scanner, "Seleccione una opción: ");

            switch (input) {
                case 1:
                    int inputCrud;
                    do {
                        mostrarMenu("CRUD DE PRODUCTOS",
                                "1. Crear producto",
                                "2. Listar todos los productos",
                                "3. Consultar un producto",
                                "4. Modificar un producto",
                                "5. Eliminar un producto",
                                "6. Salir");
                        inputCrud = Utils.leerEntero(scanner, "Ingrese la acción que desea realizar: ");

                        switch (inputCrud) {
                            case 1:
                                ServiceProducto.agregarProducto(scanner, productos);
                                break;
                            case 2:
                                ServiceProducto.listaProductos(scanner, productos);
                                break;
                            case 3:
                                ServiceProducto.consultarProducto(scanner, productos);
                                break;
                            case 4:
                                ServiceProducto.modificarProducto(scanner, productos);
                                break;
                            case 5:
                                ServiceProducto.eliminarProducto(scanner, productos);
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
                                ServicePedido.crearPedido(scanner, productos, pedidos);
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
