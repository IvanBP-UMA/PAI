package rutas;

import java.util.ArrayList;
import java.util.List;

public class Ruta {
    private String nombre;
    private List<Lugar> lugares;

    public Ruta(String nom){
        nombre = nom;
        lugares = new ArrayList<>();
    }

    public void agregar(Lugar lugar){
        if (lugar == null){
            throw new RutasException("Lugar nulo");
        }
        lugares.add(lugar);
    }

    public void agregar(String infoLugar){
        
    }


}
