// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package sort;

import model.NaturalHazard;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class NaturalHazardSorter {
    public static <T extends NaturalHazard> void sort(List<T> hazards, Comparator<? super NaturalHazard> comparator) {
        Collections.sort(hazards, comparator);
    }
} 