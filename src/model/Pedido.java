package model;
public class Pedido {
    private int id;
    private int cantidad;
    private Producto producto;

    public Pedido(int id, int cantidad, Producto producto){
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getId(){
        return id;
    }

    public int getCantidad(){
        return cantidad;
    }

    public Producto getProducto(){
        return producto;
    }

    public double getPrecioTotalPedido(){
        return cantidad * producto.getPrecio();
    }

    public double getPrecioUnitario(){
        return producto.getPrecio();
    }

    public void getDetallePedido(){
        System.out.println("ID: " + getId());
        System.out.println("Cantidad: " + getCantidad());
        System.out.println("Producto: " + getProducto());
        System.out.println("Precio total del pedido: " + getPrecioTotalPedido());
        System.out.println("Precio unitario: " + getPrecioUnitario());
    }

    public void setId(int id){
        this.id = id;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto){
        this.producto = producto;
    }

    @Override public String toString(){
        return 
        "ID: "+id+
        " | Nombre: "+this.producto.getNombre()+
        " | Cantidad: "+cantidad+
        " | Precio unitario: "+this.getPrecioUnitario()+
        " | Precio total: "+this.getPrecioTotalPedido();
    }

}
