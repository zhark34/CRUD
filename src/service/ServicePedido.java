package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Pedido;
import model.Producto;
import utils.Utils;

public class ServicePedido {
    private static void mostrarCabecera(String titulo) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("          " + titulo);
        System.out.println("========================================");
    }

    public static void crearPedido(Scanner scanner, ArrayList<Producto> productos, ArrayList<Pedido> pedidos){
        mostrarCabecera("CREAR PEDIDO");

        if(productos.isEmpty()){
            System.out.println("[INFO] No hay productos cargados.");
            return;
        }

        int idProducto = Utils.leerEntero(scanner, "Ingrese el ID del producto: ");
        Producto producto = Utils.buscarProductoPorId(productos, idProducto);

        if (producto == null) {
            System.out.println("[ERROR] El producto no existe.");
            return;
        }

        int idPedido = Utils.leerEntero(scanner, "Ingrese el ID del pedido: ");
        Pedido checkPedido = Utils.buscarPedidoPorId(pedidos, idPedido);

        if (checkPedido != null) {
            System.out.println("[ERROR] Ya hay un pedido con el ID ingresado.");
            return;
        }

        int cantidad = Utils.leerEntero(scanner, "Ingrese la cantidad de unidades: ");

        if(cantidad > producto.getStock()){
            System.out.println("[ERROR] La orden supera el stock disponible.");
            return;
        }

        producto.setStock(producto.getStock()-cantidad);
        Pedido pedido = new Pedido(idPedido, cantidad, producto);
        pedidos.add(pedido);

        System.out.println("[OK] Pedido creado correctamente.");
    }

    public static void listarPedidos(Scanner scanner, ArrayList<Pedido> pedidos){
        mostrarCabecera("LISTADO DE PEDIDOS");

        if(pedidos.isEmpty()){
            System.out.println("[INFO] No hay pedidos cargados.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }
}
