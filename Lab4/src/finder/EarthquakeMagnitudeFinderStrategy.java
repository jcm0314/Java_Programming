// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Earthquake;

public class EarthquakeMagnitudeFinderStrategy implements IFinderStrategy<Earthquake> {
    private double min;
    private double max;

    public EarthquakeMagnitudeFinderStrategy(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean match(Earthquake item) {
        double magnitude = item.getMagnitude();
        return magnitude >= min && magnitude <= max;
    }
} 