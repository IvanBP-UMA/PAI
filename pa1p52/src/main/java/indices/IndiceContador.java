package indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class IndiceContador extends IndiceAbstracto{
    private SortedMap<String, Integer> indice;

    public IndiceContador(){
        super();
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for (String frase: texto){
            String[] palabras = frase.split(delimitadores);
            agregarPalabras(palabras);
        }
    }

    private void agregarPalabras(String[] palabras){
        for (String pal: palabras){
            indice.put(pal.toLowerCase(), indice.getOrDefault(pal.toLowerCase(),0)+1);
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, Integer> entry: indice.entrySet()){
            pw.println(entry.getKey() + "     " + entry.getValue());
        }
    }
}
