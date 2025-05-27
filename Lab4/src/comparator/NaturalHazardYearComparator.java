// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package comparator;

import java.util.Comparator;
import model.NaturalHazard;

public class NaturalHazardYearComparator implements Comparator<NaturalHazard> {
    @Override
    public int compare(NaturalHazard h1, NaturalHazard h2) {
        return Integer.compare(h1.getYear(), h2.getYear());
    }
} 