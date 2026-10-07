package model;
public class Pedido {
    private int id;
    private int cantidad;
    private Articulo articulo;

    public Pedido(int id, int cantidad, Articulo articulo){
        this.id = id;
        this.cantidad = cantidad;
        this.articulo = articulo;
    }

    public int getId(){
        return id;
    }

    public int getCantidad(){
        return cantidad;
    }

    public Articulo getArticulo(){
        return articulo;
    }

    public double getPrecioTotalPedido(){
        return cantidad * articulo.getPrecio();
    }

    public double getPrecioUnitario(){
        return articulo.getPrecio();
    }

    public void getDetallePedido(){
        System.out.println("ID: " + getId());
        System.out.println("Cantidad: " + getCantidad());
        System.out.println("Artículo: " + getArticulo());
        System.out.println("Precio total del pedido: " + getPrecioTotalPedido());
        System.out.println("Precio unitario: " + getPrecioUnitario());
    }

    public void setId(int id){
        this.id = id;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public void setArticulo(Articulo articulo){
        this.articulo = articulo;
    }

    @Override public String toString(){
        return 
        "ID: "+id+
        " | Nombre: "+this.articulo.getNombre()+
        " | Cantidad: "+cantidad+
        " | Precio unitario: "+this.getPrecioUnitario()+
        " | Precio total: "+this.getPrecioTotalPedido();
    }

}
