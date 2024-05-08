package cuentapalabras;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ContadorPalabras {
    List<PalabraEnTexto> palabras;

    public ContadorPalabras(){
        palabras = new ArrayList<>();
    }

    private int esta(String pal){
        PalabraEnTexto buscada = new PalabraEnTexto(pal);
        int i=0;
        while(i<palabras.size() && !palabras.get(i).equals(buscada)){
            i++;
        }
        return i>= palabras.size()?-1:i;
    }

    protected void incluye(String pal){
        if (!pal.isEmpty()){
            int index = esta(pal);
            if (index<0){
                palabras.add(new PalabraEnTexto(pal));
            }else{
                palabras.get(index).incrementa();
            }
        }
    }

    private void incluyeTodas(String linea, String del){
        String[] pals = linea.split(del);
        for (int i = 0; i<pals.length; i++){
            incluye(pals[i]);
        }
    }

    public void incluyeTodas(String[] texto, String del){
        for (int i = 0; i<texto.length; i++){
            incluyeTodas(texto[i], del);
        }
    }

    public void incluyeTodasFichero(String nomFich, String del) throws IOException {
        try (Scanner scanner = new Scanner(Path.of(nomFich))){
            while (scanner.hasNextLine()){
                incluyeTodas(scanner.nextLine(), del);
            }
        }
    }

    public PalabraEnTexto encuentra(String pal){
        int index = esta(pal);
        if (index < 0){
            throw new NoSuchElementException("No existe la palabra "+pal);
        }
        return palabras.get(index);
    }

    public void presentaPalabras(String fichero) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(fichero)){
            for (PalabraEnTexto palabra: palabras){
                pw.println(palabra.toString());
            }
        }
    }

    public void presentaPalabras(PrintWriter pw){
        for (PalabraEnTexto palabra: palabras) {
            pw.println(palabra.toString());
        }
        pw.close();
    }

    @Override
    public String toString(){
        StringJoiner res = new StringJoiner(" - ", "[", "]");
        for (PalabraEnTexto palabra: palabras){
            res.add(palabra.toString());
        }
        return res.toString();
    }
}
