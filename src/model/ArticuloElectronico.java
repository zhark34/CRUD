package model;
public class ArticuloElectronico extends Articulo {
    private int garantiaMeses;

    public ArticuloElectronico(int id, String nombre, double precio, int stock, int garantiaMeses) {
        super(id, nombre, precio, stock);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses(){
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses){
        this.garantiaMeses = garantiaMeses;
    }

    @Override public String getTipoArticulo(){
        return "Electronico";
    }

    @Override public void getDetalleArticulo(){
        super.getDetalleArticulo();
        System.out.println("Meses de garantía: " + getGarantiaMeses());
    }

    @Override public String toString(){
        return super.toString() + " | Meses de garantia: " + garantiaMeses;
    }

}
