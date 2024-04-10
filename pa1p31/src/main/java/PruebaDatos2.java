import datos2.Datos;

import java.util.Arrays;

public class PruebaDatos2 {
	public static void main(String[] args) {
		if (args.length < 3){
			System.out.println("Error, no hay valores suficientes");
			return;
		}
		double[] minmax = new double[2];
		for (int i = 0; i<2; i++){
			try {
				minmax[i] = Double.parseDouble(args[i]);
			}catch (Exception e){
				System.out.println("Error, al convertir un valor a numero real (For input string: \""+args[i]+"\")");
				return;
			}
		}
		Datos datos = new Datos(Arrays.copyOfRange(args, 2, args.length),minmax[0], minmax[1]);
		System.out.println(datos);

		try {
			datos.setRango("0;4");
			System.out.println(datos);
			datos.setRango("15 25");
			System.out.println(datos);
		}catch (Exception e){
			System.out.println("Error en los datos al establecer el rango");
		}
	}
}
