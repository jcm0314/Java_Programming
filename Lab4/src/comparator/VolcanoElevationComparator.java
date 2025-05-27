// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package comparator;

import java.util.Comparator;
import model.Volcano;

public class VolcanoElevationComparator implements Comparator<Volcano> {
    @Override
    public int compare(Volcano v1, Volcano v2) {
        return Integer.compare(v1.getElevation(), v2.getElevation());
    }
} 