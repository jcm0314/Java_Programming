// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.NaturalHazard;

public class NaturalHazardYearFinderStrategy implements IFinderStrategy<NaturalHazard> {
    private int min;
    private int max;

    public NaturalHazardYearFinderStrategy(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean match(NaturalHazard item) {
        int year = item.getYear();
        return year >= min && year <= max;
    }
} 