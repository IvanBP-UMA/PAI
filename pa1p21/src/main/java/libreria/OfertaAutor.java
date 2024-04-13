package libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex{
    private double porcDecuento;
    private String[] autoresOferta;

    public OfertaAutor(double porcDecuento, String[] autoresOferta){
        this.autoresOferta = autoresOferta;
        this.porcDecuento = porcDecuento;
    }

    @Override
    public double getDescuento(Libro libro) {
        double descuento = 0;
        for (int i = 0; i<autoresOferta.length; i++){
            if (libro.getAutor().equalsIgnoreCase(autoresOferta[i])){
                descuento = porcDecuento;
                break;
            }
        }
        return  descuento;
    }

    @Override
    public String toString(){
        return ""+porcDecuento+"%"+ Arrays.toString(autoresOferta);
    }
}
