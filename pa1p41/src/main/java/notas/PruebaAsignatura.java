package notas;

import java.util.List;

public class PruebaAsignatura {
    public static void main(String[] args) {
        Asignatura PA1 = new Asignatura("PA1", new String[]{"12455666F;Lopez Perez, Pedro;6.7", "33678999D; Merlo Gomez, Isabel;5.8", "23555875G;Martinez Herrera, Lucia;9.1"});
        try {
            System.out.println("Media de calificaciones: "+PA1.getMedia());
            List<Estudiante> estudiantes = PA1.getEstudiantes();
            for (int i = 0; i<estudiantes.size(); i++){
                System.out.println(estudiantes.get(i).getDni());
            }
            System.out.println(PA1.getCalificacion(new Estudiante("12455666F", "Lopez Lopez, Pedro")));
        } catch (EstudianteException e) {
            System.out.println("Error : "+e.getMessage());;
        }
    }
}
