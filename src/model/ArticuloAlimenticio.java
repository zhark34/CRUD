package model;
public class ArticuloAlimenticio extends Articulo {
    private int diasVencimiento;

    public ArticuloAlimenticio(int id, String nombre, double precio, int stock, int diasVencimiento) {
        super(id, nombre, precio, stock);
        this.diasVencimiento = diasVencimiento;
    }

    public int getDiasVencimiento (){
        return diasVencimiento;
    }

    public void setDiasVencimiento (int diasVencimiento){
        this.diasVencimiento = diasVencimiento;
    }

    @Override public String getTipoArticulo(){
        return "Alimenticio";
    }

    @Override public void getDetalleArticulo(){
        super.getDetalleArticulo();
        System.out.println("Días hasta el vencimiento: " + getDiasVencimiento());
    }

    @Override public String toString(){
        return super.toString() + " | Dias hasta el vencimiento: " + diasVencimiento;
    }

}
