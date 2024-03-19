import libreria.Libreria;
import libreria.Libro;

public class PruebaLibreria {

	public static void main(String[] args) {

		Libreria libreria = new Libreria();
		libreria.addLibro("george orwell", "1984", 8.20);
		libreria.addLibro("Philip K. Dick","¿Sueñan los androides con ovejas eléctricas?", 3.50);
		libreria.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
		libreria.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		libreria.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		libreria.addLibro("Isaac Asimov", "La Fundacion", 7.30);
		libreria.addLibro("William Gibson", "Neuromante", 8.30);
		libreria.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
		libreria.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		libreria.addLibro("George Orwell", "1984", 6.20);
		libreria.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);

		System.out.println(libreria +"\n");

		libreria.remLibro("George Orwell", "1984");
		libreria.remLibro("Aldous Huxley", "Un Mundo Feliz");
		libreria.remLibro("Isaac Newton", "Arithmetica Universalis");

		System.out.println(libreria +"\n");

		System.out.println(libreria.getPrecioFinalString("Philip K. Dick","¿Sueñan los androides con ovejas eléctricas?"));
		System.out.println(libreria.getPrecioFinalString("isaac asimov","fundación e imperio"));
		System.out.println(libreria.getPrecioFinalString("Ray Bradbury","Fahrenheit 451"));
		System.out.println(libreria.getPrecioFinalString("Isaac Asimov","La Fundacion"));
		System.out.println(libreria.getPrecioFinalString("william gibson","neuromante"));
		System.out.println(libreria.getPrecioFinalString("Isaac Asimov","Segunda Fundación"));
		System.out.println(libreria.getPrecioFinalString("Isaac Newton", "Arithmetica Universalis"));

	}

}
