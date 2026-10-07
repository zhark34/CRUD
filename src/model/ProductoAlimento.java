package model;
public class ProductoAlimento extends Producto {
    private int diasVencimiento;

    public ProductoAlimento(int id, String nombre, double precio, int stock, int diasVencimiento) {
        super(id, nombre, precio, stock);
        this.diasVencimiento = diasVencimiento;
    }

    public int getDiasVencimiento (){
        return diasVencimiento;
    }

    public void setDiasVencimiento (int diasVencimiento){
        this.diasVencimiento = diasVencimiento;
    }

    @Override public String getTipoProducto(){
        return "Alimenticio";
    }

    @Override public void getDetalleProducto(){
        super.getDetalleProducto();
        System.out.println("Días hasta el vencimiento: " + getDiasVencimiento());
    }

    @Override public String toString(){
        return super.toString() + " | Dias hasta el vencimiento: " + diasVencimiento;
    }

}
