import java.util.ArrayList;
import java.util.Scanner;

import model.Articulo;
import model.Categoria;
import service.ServiceArticulo;
import utils.Utils;

public class App {
    static ArrayList<Articulo> articulos = new ArrayList<>();
    static ArrayList<Categoria> categorias = new ArrayList<>();

    public static void precargarCategorias(ArrayList<Categoria> categorias) {
        categorias.add(new Categoria(
            1,
            "Electrónica",
            "Productos tecnológicos y electrónicos"
        ));

        categorias.add(new Categoria(
            2,
            "Periféricos",
            "Accesorios para computadora"
        ));

        categorias.add(new Categoria(
            3,
            "Alimentos",
            "Productos alimenticios"
        ));

        categorias.add(new Categoria(
            4,
            "Limpieza",
            "Artículos de limpieza del hogar"
        ));
    }

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
        precargarCategorias(categorias);
        int input;
        Scanner scanner = null;
        try{
            scanner = new Scanner(System.in);
            do {
                mostrarMenu("CRUD DE ARTÍCULOS",
                        "1. Crear artículo",
                        "2. Listar todos los artículos",
                        "3. Consultar un artículo",
                        "4. Modificar un artículo",
                        "5. Eliminar un artículo",
                        "6. Listar todas las categorías",
                        "0. Salir");
                input = Utils.leerEntero(scanner, "Ingrese la acción que desea realizar: ");

                switch (input) {
                    case 1:
                        ServiceArticulo.agregarArticulo(scanner, articulos, categorias);
                        break;
                    case 2:
                        ServiceArticulo.listaArticulos(articulos);
                        break;
                    case 3:
                        ServiceArticulo.consultarArticulo(scanner, articulos);
                        break;
                    case 4:
                        ServiceArticulo.modificarArticulo(scanner, articulos, categorias);
                        break;
                    case 5:
                        ServiceArticulo.eliminarArticulo(scanner, articulos);
                        break;
                    case 6:
                        ServiceArticulo.listarCategorias(categorias);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("[ERROR] Opción inválida. Intente nuevamente.");
                        break;
                }
            } while (input != 0);
        } catch(Exception e){
            System.out.println("[ERROR] Ocurrió un error inesperado.");
        } finally{
            if(scanner != null){
                scanner.close();
            }
        }
    }
}
