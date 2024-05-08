package notas;

import java.util.ArrayList;

public class MediaAritmetica implements CalculoMedia{

    @Override
    public double calcula (ArrayList<Estudiante> estudiantes) throws EstudianteException {
        if (estudiantes.isEmpty()){
            throw new EstudianteException("No hay estudiantes");
        }
        double suma = 0;
        for (Estudiante e: estudiantes){
            suma += e.getCalificacion();
        }
        return suma/estudiantes.size();
    }
}
