package alturas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.*;

public class Mundo {
    private List<Pais> paises;

    private Mundo(List<Pais> paises){
        this.paises = paises;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public static Mundo cargar(String fich) throws IOException {
        List<Pais> paises = new ArrayList<>();
        Path path = Path.of(fich);

        try (Scanner scanner = new Scanner(path)){
            while (scanner.hasNextLine()){
                String[] values =scanner.next().split(",");
                Pais pais;
                try{
                    pais = new Pais(values[0], values[1], Double.parseDouble(values[2]));
                }catch (IndexOutOfBoundsException  | NumberFormatException e){
                    pais = null;
                }
                if (pais != null){
                    paises.add(pais);
                }
            }
        }

        return new Mundo(paises);
    }

    public Map<String, Integer> numeroDePaisesPorContinente(){
        SortedMap<String, Integer> map = new TreeMap<>();
        for (Pais pais: paises){
            if (!map.containsKey(pais.getContinente())){
                map.put(pais.getContinente(), 0);
            }else{
                map.put(pais.getContinente(), map.get(pais.getContinente()) + 1);
            }
        }
        return map;
    }

    public Map<Double, List<Pais>> paisesPorAltura(){
        SortedMap<Double, List<Pais>> map = new TreeMap<>();

        for (Pais pais: paises){
            Double altura = pais.getAltura() % 0.1;
            List<Pais> list = map.get(altura);
            if (list == null){
                list = new ArrayList<>();
                map.put(altura, list);
            }
            list.add(pais);
        }

        return map;
    }

    public SortedMap<String, SortedSet<Pais>> paisesPorContinente(){
        SortedMap<String, SortedSet<Pais>> resMap = new TreeMap<>();
        
    }

}
