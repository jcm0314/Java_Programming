// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Earthquake;
import java.util.ArrayList;

public class EarthquakeMagnitudeFinder implements IEarthquakeFinder {
    private double min;
    private double max;

    public EarthquakeMagnitudeFinder(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Earthquake[] find(Earthquake[] earthquakes) {
        ArrayList<Earthquake> result = new ArrayList<>();
        
        for (Earthquake earthquake : earthquakes) {
            double magnitude = earthquake.getMagnitude();
            if (magnitude >= min && magnitude <= max) {
                result.add(earthquake);
            }
        }
        
        return result.toArray(new Earthquake[0]);
    }
} 