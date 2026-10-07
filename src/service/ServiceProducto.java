package service;
import java.util.ArrayList;
import java.util.Scanner;

import model.Producto;
import utils.Utils;
import model.ProductoAlimento;
import model.ProductoElectronico;

public class ServiceProducto {
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

    public static void agregarProducto(Scanner scanner, ArrayList<Producto> productos){
        mostrarCabecera("INGRESAR ARTÍCULO");

        int id = Utils.leerEntero(scanner, "Ingrese el ID del producto: ");

        if (Utils.buscarProductoPorId(productos, id) != null) {
            System.out.println("[ERROR] Ya existe un artículo con ese ID.");
            return;
        }

        String nombre = Utils.leerTextoNoVacio(scanner, "Ingrese el nombre del producto: ");
        double precio = Utils.leerDoubleNoNegativo(scanner, "Ingrese el precio del producto: ");
        int stock = Utils.leerEntero(scanner, "Ingrese el stock del producto: ");

        Producto producto = Utils.crearProducto(id, nombre, precio, stock, scanner, "Ingrese qué tipo de producto quiere agregar");
        productos.add(producto);

        System.out.println("[OK] Artículo ingresado correctamente.");
    }

    public static void listaProductos(Scanner scanner, ArrayList<Producto> productos){
        mostrarCabecera("LISTA DE PRODUCTOS");

        if(productos.isEmpty()){
            System.out.println("[INFO] No hay productos cargados.");
            return;
        }

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public static void consultarProducto(Scanner scanner, ArrayList<Producto> productos){
        mostrarCabecera("CONSULTAR PRODUCTO");

        if(productos.isEmpty()){
            System.out.println("[INFO] No hay productos cargados.");
            return;
        }

        int id = Utils.leerEntero(scanner, "Ingrese el ID del producto a consultar: ");
        Producto producto = Utils.buscarProductoPorId(productos, id);

        if (producto == null) {
            System.out.println("[ERROR] El producto no existe.");
            return;
        }

        System.out.println("[INFO] Producto encontrado:");
        System.out.println(producto);
    }

    public static void modificarProducto(Scanner scanner, ArrayList<Producto> productos){
        mostrarCabecera("MODIFICAR PRODUCTO");

        if(productos.isEmpty()){
            System.out.println("[INFO] No hay productos cargados.");
            return;
        }

        int id = Utils.leerEntero(scanner, "Ingrese el ID del producto a modificar: ");
        Producto producto = Utils.buscarProductoPorId(productos, id);

        if (producto == null) {
            System.out.println("[ERROR] El producto no existe.");
            return;
        }

        String tipoProducto = producto.getTipoProducto();

        switch (tipoProducto) {
            case "Electronico":
                ProductoElectronico electronico = (ProductoElectronico) producto;
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
                            String nombre = Utils.leerTextoNoVacio(scanner, "Ingrese el nuevo nombre del producto: ");
                            electronico.setNombre(nombre);
                            break;
                        case 2:
                            double precio = Utils.leerDoubleNoNegativo(scanner, "Ingrese el nuevo precio del producto: ");
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
                ProductoAlimento alimenticeo = (ProductoAlimento) producto;
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

    public static void eliminarProducto(Scanner scanner, ArrayList<Producto> productos){
        mostrarCabecera("ELIMINAR PRODUCTO");

        if(productos.isEmpty()){
            System.out.println("[INFO] No hay productos cargados.");
            return;
        }

        int id = Utils.leerEntero(scanner, "Ingrese el ID del producto a eliminar: ");
        Producto producto = Utils.buscarProductoPorId(productos, id);

        if (producto == null) {
            System.out.println("[ERROR] El artículo no existe.");
            return;
        }

        productos.remove(producto);
        System.out.println("[OK] Artículo eliminado correctamente.");
    }
}
