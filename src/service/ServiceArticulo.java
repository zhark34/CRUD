package service;
import java.util.ArrayList;
import java.util.Scanner;

import model.Articulo;
import utils.Utils;
import model.ArticuloAlimenticio;
import model.ArticuloElectronico;
import model.Categoria;

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

    public static void agregarArticulo(Scanner scanner, ArrayList<Articulo> articulos, ArrayList<Categoria> categorias){
        mostrarCabecera("INGRESAR ARTÍCULO");

        int codigo = Utils.leerEntero(scanner, "Ingrese el código del artículo: ");

        if (Utils.buscarArticuloPorCodigo(articulos, codigo) != null) {
            System.out.println("[ERROR] Ya existe un artículo con ese código.");
            return;
        }

        String nombre = Utils.leerTextoNoVacio(scanner, "Ingrese el nombre del artículo: ");

        double precio = Utils.leerDoubleNoNegativo(scanner, "Ingrese el precio del artículo: ");

        Categoria categoria = Utils.elegirCategoria(scanner, categorias);

        if(categoria == null){
            System.out.println("Operacion cancelada, volviendo al menu principal...");
            return;
        }

        Articulo articulo = Utils.crearArticulo(codigo, nombre, precio, scanner, "Ingrese qué tipo de artículo quiere agregar", categoria);

        articulos.add(articulo);

        System.out.println("[OK] Artículo ingresado correctamente.");

        System.out.println(articulo.toString());

    }

    public static void listaArticulos(ArrayList<Articulo> articulos){
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

        int codigo = Utils.leerEntero(scanner, "Ingrese el código del artículo a consultar: ");
        Articulo articulo = Utils.buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("[ERROR] El artículo no existe.");
            return;
        }

        System.out.println("[INFO] Artículo encontrado:");
        System.out.println(articulo);
    }

    public static void modificarArticulo(Scanner scanner, ArrayList<Articulo> articulos, ArrayList<Categoria> categorias){
        mostrarCabecera("MODIFICAR ARTÍCULO");

        if(articulos.isEmpty()){
            System.out.println("[INFO] No hay artículos cargados.");
            return;
        }

        int codigo = Utils.leerEntero(scanner, "Ingrese el código del artículo a modificar: ");
        
        Articulo articulo = Utils.buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("[ERROR] El artículo no existe.");
            return;
        }

        if(articulo instanceof ArticuloElectronico){
            ArticuloElectronico electronico = (ArticuloElectronico) articulo;
            int inputElectronico;
            do {
                mostrarOpciones("ACTUALIZAR ELECTRÓNICO",
                        "1-Nombre: " + electronico.getNombre(),
                        "2-Precio: " + electronico.getPrecio(),
                        "3-Categoria: " + electronico.getCategoria().getNombre(),
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
                        for(Categoria categoria : categorias){
                            System.out.print("\n"+categoria.toString());
                        }
                        
                        System.out.print("\nEscribe el codigo de la categoria que quieres elegir: ");
                        int opcionCategoria = Integer.parseInt(scanner.nextLine());
                        Categoria categoria = Utils.buscarCategoriaPorCodigo(categorias, opcionCategoria);
                        if(categoria == null){
                            break;
                        }
                        electronico.setCategoria(categoria);
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
        }else if(articulo instanceof ArticuloAlimenticio){
            ArticuloAlimenticio alimenticeo = (ArticuloAlimenticio) articulo;
            int inputAlimenticio;
            do {
                mostrarOpciones("ACTUALIZAR ALIMENTICIO",
                        "1- " + alimenticeo.getNombre(),
                        "2- " + alimenticeo.getPrecio(),
                        "3- " + alimenticeo.getDiasVencimiento(),
                        "4- Salir");

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
                        int diasVencimiento = Utils.leerEntero(scanner, "Ingrese los nuevos días de vencimiento: ");
                        alimenticeo.setDiasVencimiento(diasVencimiento);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("[ERROR] Opción inválida.");
                        break;
                }


                if (inputAlimenticio == 5) {
                    break;
                }
            } while (inputAlimenticio != 5);
        }
    }

    public static void eliminarArticulo(Scanner scanner, ArrayList<Articulo> articulos){
        mostrarCabecera("ELIMINAR ARTÍCULO");

        if(articulos.isEmpty()){
            System.out.println("[INFO] No hay artículos cargados.");
            return;
        }

        int codigo = Utils.leerEntero(scanner, "Ingrese el código del artículo a eliminar: ");
        Articulo articulo = Utils.buscarArticuloPorCodigo(articulos, codigo);

        if (articulo == null) {
            System.out.println("[ERROR] El artículo no existe.");
            return;
        }

        articulos.remove(articulo);

        System.out.println("[OK] Artículo eliminado correctamente.");
    }

    public static void listarCategorias(ArrayList<Categoria> categorias){

        mostrarCabecera("LISTA DE CATEGORIAS");

        if(categorias.isEmpty()){
            System.out.println("[INFO] No hay categorias cargadas.");
            return;
        }

        for(Categoria categoria : categorias){
            System.out.print("\n"+categoria.toString());
        }

    }
}
