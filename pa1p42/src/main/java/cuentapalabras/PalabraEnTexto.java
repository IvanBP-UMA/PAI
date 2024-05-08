package cuentapalabras;

import java.util.Objects;

public class PalabraEnTexto {
    private String palabra;
    private int veces;
    public PalabraEnTexto(String p){
        palabra = p.toUpperCase();
        veces = 1;
    }

    public void incrementa(){
        veces++;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof PalabraEnTexto p) && palabra.equals(p.palabra);
    }

    @Override
    public int hashCode(){
        return Objects.hash(palabra);
    }

    @Override
    public String toString() {
        return palabra + ": "+veces;
    }
}
