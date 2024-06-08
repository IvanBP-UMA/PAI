package alturas;

import java.util.Comparator;

public class CompAltura implements Comparator<Pais> {

    @Override
    public int compare(Pais p1, Pais p2) {
        return Double.compare(p1.getAltura(), p1.getAltura());
    }
}
