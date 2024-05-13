package elecciones;

import java.util.List;

public class Jovenes implements Seleccion{
    private int edadRef;

    public Jovenes(int e){
        edadRef = e;
    }

    @Override
    public List<String> obtenerMiembros(List<Candidata> candidats) {
        return candidats.stream().filter(candidata -> {return (candidata.getEdad() <= edadRef);}).map(candidata -> {return candidata.getNombre();}).toList();
    }
}
