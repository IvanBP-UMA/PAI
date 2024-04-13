package libreria;

import libreria.Libreria;
import libreria.Libro;

import java.util.Arrays;

public class LibreriaOferta extends Libreria{
    private double porcDescuento;
    private String[] autoresOferta;

    public LibreriaOferta(double porcDescuento, String[] autoresOferta){
        super();
        this.porcDescuento = porcDescuento;
        this.autoresOferta = autoresOferta;
    }

    public void setOferta(double porcDescuento, String[] autoresOferta){
        this.porcDescuento = porcDescuento;
        this. autoresOferta = autoresOferta;
    }

    public String[] getOferta(){
        return autoresOferta;
    }

    public double getDescuento() {
        return porcDescuento;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        boolean onSale = false;
        Libro libro;
        for (int i = 0; i< autoresOferta.length; i++){
            if (autoresOferta[i].equalsIgnoreCase(autor)){
                onSale = true;
                break;
            }
        }
        libro = (onSale)? new LibroOferta(autor,titulo,precioBase, getDescuento()) : new Libro(autor,titulo,precioBase);
        anyadirLibro(libro);
    }

    @Override
    public String toString(){
        return ""+this.getDescuento()+"%"+ Arrays.toString(this.getOferta()) +"\n"+super.toString();
    }
}
