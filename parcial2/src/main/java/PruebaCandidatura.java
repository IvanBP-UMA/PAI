
import elecciones.Candidata;
import elecciones.Candidatura;
import elecciones.EleccionesException;
import elecciones.Seleccion;
import elecciones.AfiliacionPartido;
import elecciones.Jovenes;

public class PruebaCandidatura {
	public static void main(String[] args) {
		String[] personajes = {
				"12345678A:Capitán América:90-Los Vengadores",
				"00123456B:Cat Woman:28",
				"01234567A:Superman:22-La liga de la justicia",
				"00123456A:Batman:26-La liga de la justicia",
				"01234567B:Linterna Verde:39-Guardianes del Universo",
				"00012345A:Mujer Maravilla:800-La liga de la justicia",
				// "00012345A:Mujer Maravilla:80O-La liga de la justicia",
				"00000123A:Viuda Negra:39-Los Vengadores",
				"00000012A:Iron Man:53-Los Vengadores",
				"00000001A:Superlópez:31",
				"12345678B:Ojo de halcón:49-Los Vengadores"
		};

		// CANDIDATURA. Se crea una candidatura con algunos los superhéroes
		Candidatura superheroes = new Candidatura("Marvel & DC", "El Universo");
		try {
			superheroes.agregarMiembros(personajes);
		} catch (EleccionesException ce) {
			System.err.println(ce.getMessage());
		}
		
		// Se añade de nuevo Iron Man, pero con una edad distinta
		superheroes.agregarMiembro(new Candidata("Iron Man","00000012A",35,"Los Vengadores"));
		
		// Se obtiene información de la candidatura
		System.out.println(superheroes);
		System.out.println();
		String grupo = "Los Vengadores";
		// String grupo = "La liga de la justicia";
		int limiteEdad = 35;
		Seleccion selPartido = new AfiliacionPartido(grupo);
		Seleccion selEdad = new Jovenes(limiteEdad);

		System.out.println("Miembros de la coalición " + superheroes.getSiglas() + " que son de " + grupo + ": " +
											superheroes.obtenerAfiliadosAPartido(grupo));
		System.out.println("Miembros de la coalición " + superheroes.getSiglas() + " que son de " + grupo + ": " +
											superheroes.obtenerMiembrosCumpliendo(selPartido));
		System.out.println("Miembros de la coalición " + superheroes.getSiglas() + " que son menores de " + limiteEdad + " años: " +
											superheroes.obtenerMiembrosCumpliendo(selEdad));
	}
	
 /*SALIDA DEL PROGRAMA DE PRUEBAS
	 
	Marvel & DC (EL UNIVERSO): {CAPITÁN AMÉRICA (Los Vengadores)-CAT WOMAN (independiente)-SUPERMAN (La liga de la justicia)-BATMAN (La liga de la justicia)-LINTERNA VERDE (Guardianes del Universo)-MUJER MARAVILLA (La liga de la justicia)-VIUDA NEGRA (Los Vengadores)-IRON MAN (Los Vengadores)-SUPERLÓPEZ (independiente)-OJO DE HALCÓN (Los Vengadores)}

	Miembros de la coalición Marvel & DC que son de Los Vengadores: [Capitán América, Viuda Negra, Iron Man, Ojo de halcón]
	Miembros de la coalición Marvel & DC que son de Los Vengadores: [Capitán América, Viuda Negra, Iron Man, Ojo de halcón]
	Miembros de la coalición Marvel & DC que son menores de 35 años: [Cat Woman, Superman, Batman, Iron Man, Superlópez]
*/



	
}
