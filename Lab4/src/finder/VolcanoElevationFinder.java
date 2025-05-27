// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;
import java.util.ArrayList;

public class VolcanoElevationFinder implements IVolcanoFinder {
    private int min;
    private int max;

    public VolcanoElevationFinder(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Volcano[] find(Volcano[] volcanoes) {
        ArrayList<Volcano> result = new ArrayList<>();
        
        for (Volcano volcano : volcanoes) {
            int elevation = volcano.getElevation();
            if (elevation >= min && elevation <= max) {
                result.add(volcano);
            }
        }
        
        return result.toArray(new Volcano[0]);
    }
} 