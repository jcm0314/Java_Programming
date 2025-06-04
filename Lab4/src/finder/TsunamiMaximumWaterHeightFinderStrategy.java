// LAB5, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package finder;

import model.Tsunami;

public class TsunamiMaximumWaterHeightFinderStrategy implements IFinderStrategy<Tsunami> {
    private double min;
    private double max;

    public TsunamiMaximumWaterHeightFinderStrategy(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean match(Tsunami item) {
        double height = item.getMaximumWaterHeight();
        return height >= min && height <= max;
    }
} 