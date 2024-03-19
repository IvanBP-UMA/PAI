import jarras.Mesa;

public class EjemploUsoMesa1 {

	public static void main(String[] args) {
		Mesa mesa = new Mesa(7, 5);
		mesa.llena(Mesa.Posicion.Derecha);
		System.out.println(mesa.toString());
		mesa.llenaDesde(Mesa.Posicion.Derecha);
		System.out.println(mesa.toString());
		mesa.llena(Mesa.Posicion.Derecha);
		System.out.println(mesa.toString());
		mesa.llenaDesde(Mesa.Posicion.Derecha);
		System.out.println(mesa.toString());
		mesa.vacia(Mesa.Posicion.Izquierda);
		System.out.println(mesa.toString());
		mesa.llenaDesde(Mesa.Posicion.Derecha);
		System.out.println(mesa.toString());
		mesa.llena(Mesa.Posicion.Derecha);
		System.out.println(mesa.toString());
		mesa.llenaDesde(Mesa.Posicion.Derecha);
		System.out.println(mesa.toString());

	}

}
