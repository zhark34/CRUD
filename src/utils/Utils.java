package utils;
import java.util.ArrayList;
import java.util.Scanner;

import model.Articulo;
import model.ArticuloElectronico;
import model.Categoria;
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

    public static Articulo buscarArticuloPorCodigo(ArrayList<Articulo> articulos, int codigo) {

        for (Articulo articulo : articulos) {
            if (articulo.getCodigo() == codigo) {
                return articulo;
            }
        }

        return null;
    }

    public static Categoria buscarCategoriaPorCodigo(ArrayList<Categoria> categorias, int codigo) {

        for (Categoria categoria : categorias) {
            if (categoria.getCodigo() == codigo) {
                return categoria;
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

    public static Articulo crearArticulo(int codigo, String nombre, double precio, Scanner scanner, String mensaje, Categoria categoria){
        while (true) {
            System.out.print(mensaje);
            System.out.print("\n1-Crear artículo electrónico");
            System.out.print("\n2-Crear artículo alimenticio");

            int valor = leerEntero(scanner, "Ingrese una opcion: ");

            switch (valor) {
                case 1:
                    int garantiaMeses;
                    do{
                        garantiaMeses = leerEntero(scanner, "Ingrese la garantía del artículo: ");
                        if(garantiaMeses<0){
                            System.out.println("Los meses de garantia no pueden ser negativos");
                        }
                    } while (garantiaMeses < 0);
                    Articulo articuloElectronico = new ArticuloElectronico(codigo, nombre, precio, categoria, garantiaMeses);
                    return articuloElectronico;
                case 2:
                    int diasVencimiento;
                    do{
                        diasVencimiento = leerEntero(scanner, "Ingrese el vencimiento del artículo: ");
                        if(diasVencimiento<0){
                            System.out.println("Los dias de vencimiento no pueden ser negativos");
                        }
                    } while (diasVencimiento < 0);
                    if(diasVencimiento<0){
                        System.out.println("Los dias de vencimiento no pueden ser negativos");
                        break;
                    }
                    Articulo articuloAlimenticio = new ArticuloAlimenticio(codigo, nombre, precio, categoria, diasVencimiento);
                    return articuloAlimenticio;
                default:
                    System.out.print("Ingrese una opcion valida");
            }

        }
    }

    public static Categoria elegirCategoria(Scanner scanner, ArrayList<Categoria> categorias){
        System.out.print("--- CATEGORÍAS DISPONIBLES ---");
        for(Categoria categoria : categorias){
            System.out.print("\n"+categoria.getCodigo()+" - "+categoria.getNombre());
        }
        int opcion;
        do{
            System.out.print("\n0-Salir");
            opcion = leerEntero(scanner, "\nEscribe el codigo de la categoria que quieres elegir: ");

            if(opcion == 0){
                return null;
            }

            Categoria categoria = buscarCategoriaPorCodigo(categorias, opcion);

            if(categoria != null){
                return categoria;
            }

            System.out.println("Categoria no encontrada.");

        } while(opcion!=0);

        return null;

    }

}
