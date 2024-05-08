package notas;

public class PruebaEstudiante {

    public static void main(String[] args) {
        Estudiante est1;
        Estudiante est2;

        try{
            est1 = new Estudiante("22456784F", "Gonzalez Perez, Juan", 5.5);
            est2 = new Estudiante("33456777S", "Gonzalez Perez, Juan", 3.4);
            System.out.println(""+ est1 + est1.getCalificacion());
            System.out.println(""+est2+est2.getCalificacion());
            String iguales = (est1.equals(est2))? "Ambos estudiantes son iguales": "Ambos estudiantes NO son iguales";
            System.out.println(iguales);
        }catch (EstudianteException e){
            System.out.println("Estudiante con datos incorrectos");
        }
    }

}
