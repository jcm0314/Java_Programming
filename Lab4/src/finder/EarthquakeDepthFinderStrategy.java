// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Earthquake;

public class EarthquakeDepthFinderStrategy implements IFinderStrategy<Earthquake> {
    private int min;
    private int max;

    public EarthquakeDepthFinderStrategy(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean match(Earthquake item) {
        int depth = item.getDepth();
        return depth >= min && depth <= max;
    }
} 