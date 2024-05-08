package notas;

import java.util.ArrayList;

public class MediaArmonica implements CalculoMedia{
    @Override
    public double calcula(ArrayList<Estudiante> estudiantes) throws EstudianteException {
        int mayoresQueCero = 0;
        double suma = 0;
        for (Estudiante e: estudiantes){
            if (e.getCalificacion()>0){
                mayoresQueCero++;
                suma += 1/e.getCalificacion();
            }
        }
        if (mayoresQueCero == 0){
            throw new EstudianteException("No hay estudiantes");
        }
        return mayoresQueCero/suma;
    }
}
