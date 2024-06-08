package indices;

import java.io.PrintWriter;

public interface Indice {
    void agregarFrase(String frase);
    void resolver(String delimitadores);
    void presentarIndice(PrintWriter pw);
    default void presentarIndiceConsola(){
        presentarIndice(new PrintWriter(System.out, true));
    }
}
