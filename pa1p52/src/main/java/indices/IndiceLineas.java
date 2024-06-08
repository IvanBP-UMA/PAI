package indices;

import java.io.PrintWriter;
import java.util.*;

public class IndiceLineas extends IndiceAbstracto{
    private SortedMap<String, Set<Integer>> indice;

    public IndiceLineas(){
        super();
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for (int i = 0; i< texto.size(); i++){
            String[] palabras = texto.get(i).split(delimitadores);
            agregarPalabras(palabras, i+1);
        }
    }

    private void agregarPalabras(String[] palabras, int linea){
        for (String pal: palabras){
            Set<Integer> entrySet = indice.getOrDefault(pal.toLowerCase(), new TreeSet<>());
            entrySet.add(linea);
            indice.put(pal.toLowerCase(), entrySet);
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, Set<Integer>> entry : indice.entrySet()){
            StringBuilder valueSet = new StringBuilder(entry.getValue().toString());
            valueSet.replace(0, 1, "<").replace(valueSet.length()-1, valueSet.length(), ">");
            pw.println(entry.getKey() + "    " + valueSet);

        }
    }
}
