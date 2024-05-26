package rank;

import java.util.Comparator;

public class RankOrder implements Comparator<Site> {

    @Override
    public int compare(Site s1, Site s2) {
        int res = 0;
        if (s1.getRank() == s2.getRank()){
            res = s1.compareTo(s2);
        }else{
            res = Double.compare(s2.getRank(), s1.getRank());
        }
        return res;
    }
}
