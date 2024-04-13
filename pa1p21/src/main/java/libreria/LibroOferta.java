package libreria;

import libreria.Libro;

public class LibroOferta extends Libro {
    private double porcDescuento;

    public LibroOferta(String autor, String titulo, Double precioBase, Double porcDescuento){
        super(autor,titulo,precioBase);
        this.porcDescuento = porcDescuento;
    }

    public double getDescuento() {
        return porcDescuento;
    }

    @Override
    protected double getBaseImponible(){
        return this.getPrecioBase() - this.getPrecioBase()*this.getDescuento()/100;
    }

    @Override
    public String toString(){
        return "(" + this.getAutor()+ "; " + this.getTitulo() +"; "+ this.getPrecioBase() +"; " + this.getDescuento() + "%; "+ this.getBaseImponible() +"; " + getIVA() + "%; " + this.getPrecioFinal() + ")";
    }
}
