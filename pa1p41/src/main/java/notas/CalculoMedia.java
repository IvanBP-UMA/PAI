package notas;

import java.util.ArrayList;

public interface CalculoMedia {
    double calcula(ArrayList<Estudiante> estudiantes) throws EstudianteException;
}
