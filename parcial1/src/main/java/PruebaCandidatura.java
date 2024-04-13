import elecciones.Candidata;
import elecciones.Candidatura;
import elecciones.CandidaturaPartido;


public class PruebaCandidatura {
    public static void main(String[] args) {

        Candidata capitan = new Candidata("Capitán América", "12345678A", Candidata.Sexo.M, "Los Vengadores");
        Candidata superman = new Candidata("Superman", "01234567A", Candidata.Sexo.M, "La liga de la justicia");
        Candidata batman = new Candidata("Batman", "00123456A", Candidata.Sexo.M, "La liga de la justicia");
        Candidata maravilla = new Candidata("Mujer Maravilla", "00012345A", Candidata.Sexo.F, "La liga de la justicia");
        Candidata aquaman = new Candidata("Aquaman", "00001234A", Candidata.Sexo.M, "La liga de la justicia");
        Candidata viuda = new Candidata("Viuda Negra", "00000123A", Candidata.Sexo.F, "Los Vengadores");
        Candidata catwoman = new Candidata("Cat Woman", "00000012A", Candidata.Sexo.F);

        // CANDIDATURA 1. Se crea una candidatura de superhéroes con candidatos de La Liga de la Justicia y Los Vengadores y algún independiente.
        // Candidatura superheroes = new Candidatura("Los Vengadores de la Justicia","El Mundo");

        // CANDIDATURA 2. Se crea una candidatura con algunos de los superhéroes, pero considerando independientes a los que no tengan la afiliación de la candidatura
        Candidatura superheroes = new CandidaturaPartido("Los Vengadores", "El Universo");
        superheroes.agregarMiembro(new Candidata("Iron Man", "00000001A", Candidata.Sexo.M,"Los Vengadores"));

        // Se agregan miembros a la candidatura de superhéroes
        superheroes.agregarMiembro(maravilla);
        superheroes.agregarMiembro(aquaman);
        superheroes.agregarMiembro(viuda);
        superheroes.agregarCabezaLista(capitan);
        superheroes.agregarMiembro(batman);
        superheroes.agregarMiembro(catwoman);
        superheroes.agregarMiembro(superman);


        // Se obtiene información de ambas candidaturas
        System.out.println(superheroes);
        System.out.println();
        System.out.println("La candidatura de superheroes " + (superheroes.esCremallera() ? "es" : "no es") + " cremallera");
        System.out.println("La persona que encabeza la candidatura de superhéroes es: " + superheroes.cabezaLista());
        System.out.println("El número de  independientes en la candidatura de superhéroes es: "+ superheroes.numeroIndependientes());

    }

	/* SALIDA DEL PROGRAMA DE PRUEBAS PARA LA CANDIDATURA 1

	Los Vengadores de la Justicia-EL MUNDO: [CAPITÁN AMÉRICA, MUJER MARAVILLA, AQUAMAN, VIUDA NEGRA, BATMAN, CAT WOMAN (independiente), SUPERMAN]

	La candidatura de superheroes es cremallera
	La persona que encabeza la candidatura de superhéroes es: CAPITÁN AMÉRICA
	El número de  independientes en la candidatura de superhéroes es: 1

	 */


	/* SALIDA DEL PROGRAMA DE PRUEBAS PARA LA CANDIDATURA 2 (tras comentar la línea 16 y quitar comentarios en 19 y 20

	Los Vengadores-EL UNIVERSO: [CAPITÁN AMÉRICA, IRON MAN, MUJER MARAVILLA (independiente), AQUAMAN (independiente), VIUDA NEGRA, BATMAN (independiente), CAT WOMAN (independiente), SUPERMAN (independiente)]

	La candidatura de superheroes no es cremallera
	La persona que encabeza la candidatura de superhéroes es: CAPITÁN AMÉRICA
	El número de  independientes en la candidatura de superhéroes es: 5

	 */

}
