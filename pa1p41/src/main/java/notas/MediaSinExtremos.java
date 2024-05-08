package notas;

import java.util.ArrayList;

public class MediaSinExtremos implements CalculoMedia{
    double min;
    double max;
    public MediaSinExtremos(double minimo, double maximo){
        min = minimo;
        max = maximo;
    }
    @Override
    public double calcula(ArrayList<Estudiante> estudiantes) throws EstudianteException {
        int inRange = 0;
        double suma = 0;
        for (Estudiante est: estudiantes){
            if (est.getCalificacion() >= min && est.getCalificacion()<=max){
                inRange++;
                suma += est.getCalificacion();
            }
        }
        if (inRange == 0){
            throw new EstudianteException("No hay estudiantes");
        }
        return suma/inRange;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
