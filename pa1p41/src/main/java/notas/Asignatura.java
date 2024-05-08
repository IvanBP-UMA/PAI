package notas;

import java.util.*;

public class Asignatura {
    private String nombre;
    private List<Estudiante> estudiantes;
    private List<String> errores;

    public Asignatura(String nombre, String[] estudiantes){
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        errores = new ArrayList<>();
        procesarEstudiantes(estudiantes);
    }

    public double getCalificacion(Estudiante est) throws EstudianteException{
        int index = buscarEstudiante(est);
        if (index< 0 ){
            throw new EstudianteException("Estudiante "+ est + " no se encuentra");
        }
        return estudiantes.get(index).getCalificacion();
    }

    public double getMedia() throws EstudianteException{
        double suma = 0;
        if (estudiantes.isEmpty()){
            throw new EstudianteException("No hay estudiantes");
        }
        for (Estudiante est: estudiantes){
            suma += est.getCalificacion();
        }
        return suma/estudiantes.size();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<String> getErrores() {
        return errores;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder(getNombre()).append(": { ").append(getEstudiantes()).append(", ").append(getErrores()).append(" }");
        return res.toString();
    }

    protected void procesarEstudiantes(String[] estudiantes){
        String nombreEstudiante, dniEstudiante;
        double notaEstudiante;

        for (int i = 0; i<estudiantes.length; i++) {
            try (Scanner scanner = new Scanner(estudiantes[i])) {
                scanner.useDelimiter(";");
                scanner.useLocale(Locale.ENGLISH);
                dniEstudiante = scanner.next();
                nombreEstudiante = scanner.next();
                notaEstudiante = scanner.nextDouble();
                this.estudiantes.add(new Estudiante(dniEstudiante, nombreEstudiante, notaEstudiante));
            } catch (InputMismatchException e) {
                errores.add("ERROR. Calificacion no numerica: " + estudiantes[i]);
            } catch (NoSuchElementException e) {
                errores.add("ERROR. Faltan datos: " + estudiantes[i]);
            } catch (EstudianteException e) {
                errores.add("ERROR. Calificacion negativa: " + estudiantes[i]);
            }
        }
    }

    protected int buscarEstudiante(Estudiante estudiante){
        int index = -1;
        boolean found = false;

        for (int i = 0; i<estudiantes.size() && !found; i++){
            if (estudiante.equals(estudiantes.get(i))){
                index = i;
                found = true;
            }
        }
        return index;
    }
}
