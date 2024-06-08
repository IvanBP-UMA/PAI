package ex2305;

import java.util.Objects;
import java.util.StringJoiner;

public class Solicitud implements Comparable<Solicitud>{
    private String asignatura;
    private int diaSem;
    private int franja;
    private int lab;

    public Solicitud(String nombre, int dia, int fra){
        asignatura = nombre;
        setDiaSem(dia);
        setFranja(fra);
        lab = -1;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public int getDiaSem() {
        return diaSem;
    }

    public int getFranja() {
        return franja;
    }

    public int getLab() {
        return lab;
    }

    public void setDiaSem(int diaSem) {
        if (diaSem < 1 || diaSem > 7){
            throw new LabException("Argumentos erróneos");
        }
        this.diaSem = diaSem;
    }

    public void setFranja(int franja) {
        if (franja < 1 || franja > 3){
            throw new LabException("Argumentos erróneos");
        }
        this.franja = franja;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "(", ")");
        return sj.add(asignatura).add(Integer.toString(diaSem)).add(Integer.toString(franja)).add(Integer.toString(lab)).toString();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Solicitud s) && s.franja == franja && s.diaSem == diaSem && s.asignatura.equalsIgnoreCase(asignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(franja, diaSem, asignatura.toLowerCase());
    }

    @Override
    public int compareTo(Solicitud s) {
        int res = Integer.compare(diaSem, s.diaSem);
        res = (res == 0)? Integer.compare(franja, s.franja) : res;
        res = (res == 0)? asignatura.toLowerCase().compareTo(s.asignatura.toLowerCase()) : res;

        return res;
    }
}
