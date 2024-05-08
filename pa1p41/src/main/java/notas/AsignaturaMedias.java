package notas;

import java.util.ArrayList;

public class AsignaturaMedias extends Asignatura{

    public AsignaturaMedias(String nombre, String[] estudiantes) {
        super(nombre, estudiantes);
    }

    public double getMedia(CalculoMedia calc) throws EstudianteException{
        return calc.calcula((ArrayList<Estudiante>) getEstudiantes());
    }
}
