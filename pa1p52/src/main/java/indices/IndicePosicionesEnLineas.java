package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndicePosicionesEnLineas extends IndiceAbstracto{
    private SortedMap<String, SortedMap<Integer, Set<Integer>>> indice;

    public IndicePosicionesEnLineas(){
        super();
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for (int i = 0; i<texto.size(); i++){
            String[] palabras = texto.get(i).split(delimitadores);
            agregarPalabra(palabras, i+1);
        }
    }

    private void agregarPalabra(String[] palabras, int linea){
        for (int i = 0; i<palabras.length; i++){
            SortedMap<Integer, Set<Integer>> entryMap = indice.getOrDefault(palabras[i].toLowerCase(), new TreeMap<>());
            Set<Integer> positionSet = entryMap.getOrDefault(linea, new TreeSet<>());
            positionSet.add(i+1);
            entryMap.put(linea, positionSet);
            indice.put(palabras[i].toLowerCase(), entryMap);
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, SortedMap<Integer, Set<Integer>>> entry : indice.entrySet()){
            pw.println(entry.getKey());
            for (Map.Entry<Integer, Set<Integer>> line : entry.getValue().entrySet()){
                StringBuilder valueSet = new StringBuilder(line.getValue().toString());
                valueSet.replace(0, 1, "<").replace(valueSet.length()-1, valueSet.length(), ">");
                pw.println("       " + line.getKey() + " " + valueSet);
            }
        }
    }
}
