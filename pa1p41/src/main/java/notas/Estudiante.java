package notas;

import java.util.Objects;

public class Estudiante {
    private String dni;
    private String nombre;
    private double nota;

    public Estudiante(String dni, String nombre, double nota) throws EstudianteException {
        this.dni = dni;
        this.nombre = nombre;
        if (nota<0){
            throw new EstudianteException("Calificacion negativa");
        }
        this.nota = nota;
    }

    public Estudiante(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
        nota = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public double getCalificacion() {
        return nota;
    }

    @Override
    public String toString(){
        return getNombre()+" ("+getDni() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Estudiante estudiante)
                && nombre.equals(estudiante.getNombre())
                && dni.equalsIgnoreCase(estudiante.getDni());
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre, dni.toLowerCase());
    }
}
