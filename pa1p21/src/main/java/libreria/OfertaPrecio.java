package libreria;

public class OfertaPrecio implements OfertaFlex{
    private double porcDescuento;
    private double umbralPrecio;

    public OfertaPrecio(double porcDescuento, double umbralPrecio){
        this.porcDescuento = porcDescuento;
        this.umbralPrecio = umbralPrecio;
    }

    @Override
    public double getDescuento(Libro libro) {
        double descuento = 0;
        if (libro.getPrecioBase() >= umbralPrecio){
            descuento = porcDescuento;
        }
        return descuento;
    }

    @Override
    public String toString(){
        return ""+porcDescuento+"%("+umbralPrecio+")";
    }
}
