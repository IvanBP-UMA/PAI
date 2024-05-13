import elecciones.Candidata;
import elecciones.EleccionesException;

public class PruebaCandidata {
    public static void main(String[] args) {
        Candidata cand1 = new Candidata("Wonder Woman", "00012345A", 800, "La liga de la justicia");
        Candidata cand2 = new Candidata("WONDER WOMAN", "00012345a", 810, null);

        if (cand1.equals(cand2)){
            System.out.println("Los candidatos son iguales");
        }

        try {
            Candidata cand3 = new Candidata("Spiderman", "8888888S", 17, "Los Vengadores");
        }catch (EleccionesException e){
            System.out.println(e.getMessage());
        }

    }
}
