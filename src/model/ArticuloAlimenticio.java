package model;
public class ArticuloAlimenticio extends Articulo {
    private int diasVencimiento;

    public ArticuloAlimenticio(int codigo, String nombre, double precio, Categoria categoria, int diasVencimiento) {
        super(codigo, nombre, precio, categoria);
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

    @Override public String getDetalleEspecifico(){
        return "Días para vencimiento: " + diasVencimiento;
    }

    @Override public String toString(){
        return super.toString() + 
        "\nDías para vencimiento=" + getDetalleEspecifico()+
        "\n}"+ " [subtipo alimenticio]";
    }

}
