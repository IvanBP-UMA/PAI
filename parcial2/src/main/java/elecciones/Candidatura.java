package elecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Candidatura {
    private String siglas;
    private String circunscripcion;
    private List<Candidata> candidatos;

    public Candidatura(String nom, String circs){
        siglas = nom;
        circunscripcion = circs;
        candidatos = new ArrayList<>();
    }

    public String getSiglas() {
        return siglas;
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public void agregarMiembro(Candidata cand){
        int index = buscarMiembro(cand);
        if (index>=0){
            candidatos.set(index, cand);
        }else{
            candidatos.add(cand);
        }
    }

    public void agregarMiembros(String[] candidats){
        List<Candidata> nuevosCands = new ArrayList<>();
        for (String candData: candidats){
            nuevosCands.add(createCandidatoFromString(candData));
        }
        for (Candidata nuevoCand: nuevosCands){
            agregarMiembro(nuevoCand);
        }
    }

    public List<String> obtenerAfiliadosAPartido(String partido){
        return candidatos.stream().filter(candidata -> candidata.getPartido() != null).filter(candidata -> candidata.getPartido().equalsIgnoreCase(partido)).map(candidata -> candidata.getNombre()).toList();
    }

    public List<String> obtenerMiembrosCumpliendo(Seleccion sel){
        return sel.obtenerMiembros(candidatos);
    }

    @Override
    public String toString(){
        StringJoiner listaCandidatos = new StringJoiner("-","{", "}");
        for (Candidata cand: candidatos){
            listaCandidatos.add(cand.toString());
        }
        StringBuilder res = new StringBuilder();
        res.append(siglas).append(" (").append(circunscripcion.toUpperCase()).append("): ").append(listaCandidatos);
        return res.toString();
    }

    private Candidata createCandidatoFromString(String data){
        Candidata cand;
        String[] params = data.split(":");
        try {
            String partido;
            String[] edadPartido = params[2].split("-");
            partido = (edadPartido.length == 2)?edadPartido[1]:null;
            cand = new Candidata(params[1], params[0], Integer.parseInt(edadPartido[0]), partido);
        }catch (IndexOutOfBoundsException e){
            throw new EleccionesException("Formato incorrecto (faltan datos): "+ data);
        }catch (NumberFormatException e){
            throw new EleccionesException("Formato incorrecto (edad no numérica): " + data);
        }catch (EleccionesException e){
            throw new EleccionesException("Formato incorrecto (menor de 18): " + data);
        }
        return cand;
    }

    private int buscarMiembro(Candidata cand){
        int i = 0;
        while (i<candidatos.size() && !candidatos.get(i).equals(cand)){
            i++;
        }
        return (i>=candidatos.size())?-1:i;
    }
}
