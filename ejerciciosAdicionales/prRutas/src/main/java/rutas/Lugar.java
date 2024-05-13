package rutas;

import java.util.Objects;

public class Lugar {
    private String nombre;
    private double latitud;
    private double longitud;

    public Lugar(String nom, double lat, double lon){
        nombre = nom;
        if (lat<-90 || lat>90){
            throw new RutasException("Latitud fuera de rango [-90,90]");
        }
        latitud = lat;
        if (lon<-180 || lon>180){
            throw new RuntimeException("Longitud fuera de rango [-180, 180]");
        }
        longitud = lon;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double distancia(Lugar lugar){
        return Math.sqrt(Math.pow(lugar.latitud-latitud, 2) + Math.pow(lugar.longitud - longitud, 2));
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Lugar l) && nombre.equalsIgnoreCase(l.nombre) && longitud == l.longitud && latitud == l.latitud;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toUpperCase(), latitud, longitud);
    }

    @Override
    public String toString() {
        return nombre.toUpperCase() +":"+latitud+","+longitud;
    }
}
