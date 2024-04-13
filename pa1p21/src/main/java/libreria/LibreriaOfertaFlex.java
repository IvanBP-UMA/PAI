package libreria;

public class LibreriaOfertaFlex extends Libreria{
    OfertaFlex oferta;

    public LibreriaOfertaFlex(OfertaFlex ofertaFlex){
        oferta = ofertaFlex;
    }

    public void setOferta(OfertaFlex ofertaFlex){
        oferta = ofertaFlex;
    }

    public OfertaFlex getOferta() {
        return oferta;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro;
        double descuento = oferta.getDescuento(new Libro(autor, titulo, precioBase));
        if (descuento >0.1){
            libro = new LibroOferta(autor, titulo, precioBase, descuento);
        }else{
            libro = new Libro(autor, titulo, precioBase);
        }

        anyadirLibro(libro);
    }

    @Override
    public String toString(){
        return oferta + super.toString();
    }
}
