package rank;

import java.util.Objects;

public class Site implements Comparable<Site>{
    private String name;
    private double rank;
    public Site(String nombre){
        name = nombre;
        rank = 0;
    }

    public double getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public void addRank(double r){
        rank += r;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Site s) && name.equalsIgnoreCase(s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toUpperCase());
    }

    @Override
    public String toString() {
        return name + "("+rank+")";
    }

    @Override
    public int compareTo(Site s) {
        return name.toLowerCase().compareTo(s.name.toLowerCase());
    }
}
