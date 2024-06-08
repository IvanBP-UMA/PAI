package alturas;

import java.util.Objects;

public class Pais implements Comparable<Pais>{
    private String nombre;
    private String continente;
    private double altura;

    public Pais(String nomb, String cont, double alt){
        nombre = nomb;
        continente = cont;
        altura = alt;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Pais p) && this.nombre.equals(p.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Pais o) {
        return nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return "Pais(" + nombre +"," +continente +"," + altura+")";
    }
}
