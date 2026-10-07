package service;
import java.util.ArrayList;
import java.util.Scanner;

import model.Articulo;
import utils.Utils;
import model.ArticuloAlimenticio;
import model.ArticuloElectronico;

public class ServiceArticulo {
    private static void mostrarCabecera(String titulo) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("          " + titulo);
        System.out.println("========================================");
    }

    private static void mostrarOpciones(String titulo, String... opciones) {
        mostrarCabecera(titulo);
        for (String opcion : opciones) {
            System.out.println(opcion);
        }
        System.out.println("========================================");
    }

    public static void agregarArticulo(Scanner scanner, ArrayList<Articulo> articulos){
        mostrarCabecera("INGRESAR ARTÍCULO");

        int id = Utils.leerEntero(scanner, "Ingrese el ID del artículo: ");

        if (Utils.buscarArticuloPorId(articulos, id) != null) {
            System.out.println("[ERROR] Ya existe un artículo con ese ID.");
            return;
        }

        String nombre = Utils.leerTextoNoVacio(scanner, "Ingrese el nombre del artículo: ");
        double precio = Utils.leerDoubleNoNegativo(scanner, "Ingrese el precio del artículo: ");
        int stock = Utils.leerEntero(scanner, "Ingrese el stock del artículo: ");

        Articulo articulo = Utils.crearArticulo(id, nombre, precio, stock, scanner, "Ingrese qué tipo de artículo quiere agregar");
        articulos.add(articulo);

        System.out.println("[OK] Artículo ingresado correctamente.");
    }

    public static void listaArticulos(Scanner scanner, ArrayList<Articulo> articulos){
        mostrarCabecera("LISTA DE ARTÍCULOS");

        if(articulos.isEmpty()){
            System.out.println("[INFO] No hay artículos cargados.");
            return;
        }

        for (Articulo articulo : articulos) {
            System.out.println(articulo);
        }
    }

    public static void consultarArticulo(Scanner scanner, ArrayList<Articulo> articulos){
        mostrarCabecera("CONSULTAR ARTÍCULO");

        if(articulos.isEmpty()){
            System.out.println("[INFO] No hay artículos cargados.");
            return;
        }

        int id = Utils.leerEntero(scanner, "Ingrese el ID del artículo a consultar: ");
        Articulo articulo = Utils.buscarArticuloPorId(articulos, id);

        if (articulo == null) {
            System.out.println("[ERROR] El artículo no existe.");
            return;
        }

        System.out.println("[INFO] Artículo encontrado:");
        System.out.println(articulo);
    }

    public static void modificarArticulo(Scanner scanner, ArrayList<Articulo> articulos){
        mostrarCabecera("MODIFICAR ARTÍCULO");

        if(articulos.isEmpty()){
            System.out.println("[INFO] No hay artículos cargados.");
            return;
        }

        int id = Utils.leerEntero(scanner, "Ingrese el ID del artículo a modificar: ");
        Articulo articulo = Utils.buscarArticuloPorId(articulos, id);

        if (articulo == null) {
            System.out.println("[ERROR] El artículo no existe.");
            return;
        }

        String tipoArticulo = articulo.getTipoArticulo();

        switch (tipoArticulo) {
            case "Electronico":
                ArticuloElectronico electronico = (ArticuloElectronico) articulo;
                int inputElectronico;
                do {
                    mostrarOpciones("ACTUALIZAR ELECTRÓNICO",
                            "1-Nombre: " + electronico.getNombre(),
                            "2-Precio: " + electronico.getPrecio(),
                            "3-Stock: " + electronico.getStock(),
                            "4-Meses de garantia: " + electronico.getGarantiaMeses(),
                            "5-Salir");

                    inputElectronico = Utils.leerEntero(scanner, "Ingrese el campo a modificar: ");

                    switch (inputElectronico) {
                        case 1:
                            String nombre = Utils.leerTextoNoVacio(scanner, "Ingrese el nuevo nombre del artículo: ");
                            electronico.setNombre(nombre);
                            break;
                        case 2:
                            double precio = Utils.leerDoubleNoNegativo(scanner, "Ingrese el nuevo precio del artículo: ");
                            electronico.setPrecio(precio);
                            break;
                        case 3:
                            int stock = Utils.leerEntero(scanner, "Ingrese el nuevo stock: ");
                            electronico.setStock(stock);
                            break;
                        case 4:
                            int garantiaMeses = Utils.leerEntero(scanner, "Ingrese la nueva duración de la garantía: ");
                            electronico.setGarantiaMeses(garantiaMeses);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("[ERROR] Opción inválida.");
                            break;
                    }
                } while (inputElectronico != 5);
                break;
            case "Alimenticio":
                ArticuloAlimenticio alimenticeo = (ArticuloAlimenticio) articulo;
                int inputAlimenticio;
                do {
                    mostrarOpciones("ACTUALIZAR ALIMENTICIO",
                            "1- " + alimenticeo.getNombre(),
                            "2- " + alimenticeo.getPrecio(),
                            "3- " + alimenticeo.getStock(),
                            "4- " + alimenticeo.getDiasVencimiento(),
                            "5- Salir");

                    inputAlimenticio = Utils.leerEntero(scanner, "Ingrese el campo a modificar: ");

                    switch (inputAlimenticio) {
                        case 1:
                            String nombre = Utils.leerTextoNoVacio(scanner, "Ingrese el nuevo nombre del artículo: ");
                            alimenticeo.setNombre(nombre);
                            break;
                        case 2:
                            double precio = Utils.leerDoubleNoNegativo(scanner, "Ingrese el nuevo precio del artículo: ");
                            alimenticeo.setPrecio(precio);
                            break;
                        case 3:
                            int stock = Utils.leerEntero(scanner, "Ingrese el nuevo stock: ");
                            alimenticeo.setStock(stock);
                            break;
                        case 4:
                            int diasVencimiento = Utils.leerEntero(scanner, "Ingrese los nuevos días de vencimiento: ");
                            alimenticeo.setDiasVencimiento(diasVencimiento);
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("[ERROR] Opción inválida.");
                            break;
                    }

                    if (inputAlimenticio == 5) {
                        break;
                    }
                } while (inputAlimenticio != 5);
                break;
            default:
                break;
        }
    }

    public static void eliminarArticulo(Scanner scanner, ArrayList<Articulo> articulos){
        mostrarCabecera("ELIMINAR ARTÍCULO");

        if(articulos.isEmpty()){
            System.out.println("[INFO] No hay artículos cargados.");
            return;
        }

        int id = Utils.leerEntero(scanner, "Ingrese el ID del artículo a eliminar: ");
        Articulo articulo = Utils.buscarArticuloPorId(articulos, id);

        if (articulo == null) {
            System.out.println("[ERROR] El artículo no existe.");
            return;
        }

        articulos.remove(articulo);
        System.out.println("[OK] Artículo eliminado correctamente.");
    }
}
