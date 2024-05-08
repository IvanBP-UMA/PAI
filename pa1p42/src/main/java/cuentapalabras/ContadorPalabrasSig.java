package cuentapalabras;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContadorPalabrasSig extends ContadorPalabras{
    private List<String> noSignificativas;

    public ContadorPalabrasSig(){
        super();
        noSignificativas = new ArrayList<>();
    }

    public void leeArrayNoSig(String[] palsNS){
        noSignificativas.clear();
        anyadePalabrasNoSignificativas(palsNS);
    }

    public void leeFicheroNoSig(String filNoSig, String sep) throws IOException {
        try (Scanner scanner = new Scanner(Path.of(filNoSig))){
            noSignificativas.clear();
            while (scanner.hasNextLine()){
                anyadePalabrasNoSignificativas(scanner.nextLine(), sep);
            }
        }
    }

    @Override
    public void incluye(String pal){
        int i = 0;
        while (i<noSignificativas.size() && !noSignificativas.get(i).equalsIgnoreCase(pal)){
            i++;
        }

        if (i>=noSignificativas.size()){
            super.incluye(pal);
        }
    }

    private void anyadePalabrasNoSignificativas(String line, String sep){
        String[] palabras = line.split(sep);
        anyadePalabrasNoSignificativas(palabras);
    }

    private void anyadePalabrasNoSignificativas(String[] palabras){
        for (String pal: palabras){
            if (!pal.isEmpty()) {
                noSignificativas.add(pal.toUpperCase());
            }
        }
    }
}
