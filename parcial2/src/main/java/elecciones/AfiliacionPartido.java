package elecciones;

import java.util.List;

public class AfiliacionPartido implements Seleccion{
    private String partidoRef;

    public AfiliacionPartido(String p){
        partidoRef = p;
    }

    @Override
    public List<String> obtenerMiembros(List<Candidata> candidats) {
        return candidats.stream().filter(candidata -> {return candidata.getPartido()!=null;}).filter(candidata -> {return (candidata.getPartido().equalsIgnoreCase(partidoRef));}).map(candidata -> {return candidata.getNombre();}).toList();
    }
}
