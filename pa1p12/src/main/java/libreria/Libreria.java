package libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private List<Libro> libs;
    public Libreria(){
        libs = new ArrayList<>();
    }

    public void addLibro(String autor, String titulo, double precioBase){
        Libro libro = new Libro(autor, titulo, precioBase);
        anyadirLibro(libro);
    }

    public void remLibro(String autor, String titulo){
        int pos = buscarLibro(autor, titulo);
        if (pos<0){
            throw new RuntimeException("Libro no encontrado ("+autor+", "+titulo+")");
        }
        libs.remove(pos);
    }

    public double getPrecioFinal(String autor, String titulo){
        int pos = buscarLibro(autor, titulo);
        if (pos<0){
            throw new RuntimeException("Libro no encontrado ("+autor+", "+titulo+")");
        }
        return libs.get(pos).getPrecioFinal();
    }

    @Override
    public String toString() {
        String res = "[";
        for (int i = 0; i<libs.size(); i++){
            res += libs.get(i).toString();
            res += (i<libs.size()-1 )? ",\n":"";
        }
        res += "]";
        return res;
    }

    public String getPrecioFinalString(String autor, String titulo){
        return "PrecioFinal("+autor+", "+titulo+"): "+getPrecioFinal(autor, titulo)+"\n";
    }

    protected void anyadirLibro(Libro libro){
        int pos;
        pos = buscarLibro(libro.getAutor(), libro.getTitulo());
        if (pos == -1){
            libs.add(libro);
        }else{
            libs.set(pos, libro);
        }
    }

    private int buscarLibro(String autor, String titulo){
        int pos = -1;
        Libro current;
        for (int i = 0; i<libs.size(); i++){
            current = libs.get(i);
            if (current.getAutor().equalsIgnoreCase(autor) && current.getTitulo().equalsIgnoreCase(titulo)){
                pos = i;
            }
        }
        return pos;
    }

    
}
