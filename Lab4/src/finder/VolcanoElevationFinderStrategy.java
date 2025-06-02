// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;

public class VolcanoElevationFinderStrategy implements IFinderStrategy<Volcano> {
    private int min;
    private int max;

    public VolcanoElevationFinderStrategy(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean match(Volcano item) {
        int elevation = item.getElevation();
        return elevation >= min && elevation <= max;
    }
} 