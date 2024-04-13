package elecciones;

import java.util.ArrayList;
import java.util.List;

public class Candidatura {
    private String partido;
    private String circunscripición;
    private List<Candidata> candidatura;

    public Candidatura(String partido, String circunscripición){
        this.partido = partido;
        this.circunscripición = circunscripición;
        candidatura = new ArrayList<>();
    }

    public String getPartido() {
        return partido;
    }

    public String getCircunscripición() {
        return circunscripición;
    }

    public void agregarMiembro(Candidata cand){
        boolean alreadyIn = false;
        for (int i = 0; i< candidatura.size() && !alreadyIn; i++){
            if (cand.getDNI().equalsIgnoreCase(candidatura.get(i).getDNI())){
                candidatura.set(i, cand);
                alreadyIn = true;
            }
        }
        if (!alreadyIn){
            candidatura.add(cand);
        }
    }

    public void eliminarMiembro(Candidata cand){
        int pos = buscarDNI(cand.getDNI());
        if (pos<0){
            throw new RuntimeException("No existe ningun candidato con ese DNI");
        }
        candidatura.remove(pos);
    }

    private int buscarDNI(String dni){
        int index = -1;
        for (int i = 0; i<candidatura.size() && index<0; i++){
            if (candidatura.get(i).getDNI().equalsIgnoreCase(dni)){
                index = i;
            }
        }
        return  index;
    }

    public void agregarCabezaLista(Candidata cand){
        candidatura.add(0, cand);
    }

    public Candidata cabezaLista(){
        if (candidatura.isEmpty()){
            throw new RuntimeException("No hay candidatos en la lista");
        }
        return candidatura.get(0);
    }

    public int numeroIndependientes(){
        int independientes = 0;
        for (int i = 0; i<candidatura.size(); i++){
            if (candidatura.get(i).esIndependiente()){
                independientes++;
            }
        }
        return independientes;
    }

    public boolean esCremallera(){
        boolean zip = true;
        for (int i = 0; i< candidatura.size()-1 && zip; i++){
            if (candidatura.get(i).getSexo() == candidatura.get(i+1).getSexo()){
                zip = false;
            }
        }
        return zip;
    }

    @Override
    public String toString(){
        String res = partido+"-"+circunscripición.toUpperCase()+":[ ";
        for (int i = 0; i< candidatura.size(); i++){
            res += candidatura.get(i);
            if (i != candidatura.size()-1){
                res += ", ";
            }
        }
        res +="]";
        return res;
    }
}
