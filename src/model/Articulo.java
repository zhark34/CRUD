package model;
public abstract class Articulo {
    private int codigo;
    private String nombre;
    private double precio;

    public Articulo(int codigo, String nombre, double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public abstract String getTipoArticulo();

    public void getDetalleArticulo(){
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio: " + getPrecio());
    }

    @Override public String toString(){
        return "Codigo: " + codigo + " | Nombre: " + nombre + " | Precio: " + precio;
    }

}