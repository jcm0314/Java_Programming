// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package comparator;

import java.util.Comparator;
import model.Volcano;

public class VolcanoLatitudeComparator implements Comparator<Volcano> {
    @Override
    public int compare(Volcano v1, Volcano v2) {
        return Double.compare(v1.getLatitude(), v2.getLatitude());
    }
} 