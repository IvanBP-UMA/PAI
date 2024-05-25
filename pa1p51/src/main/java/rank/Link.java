package rank;

import java.util.Objects;

public class Link {
    private String origin;
    private String linked;
    public Link(String org, String lnk){
        origin = org;
        linked = lnk;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLinked() {
        return linked;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Link l) && origin.equalsIgnoreCase(l.origin) && linked.equalsIgnoreCase(l.linked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin.toUpperCase(), linked.toUpperCase());
    }

    @Override
    public String toString() {
        return origin +"->"+ linked;
    }
}
