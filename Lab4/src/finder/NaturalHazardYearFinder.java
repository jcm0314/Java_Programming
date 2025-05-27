// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.NaturalHazard;
import java.util.ArrayList;

public class NaturalHazardYearFinder implements INaturalHazardFinder {
    private int min;
    private int max;

    public NaturalHazardYearFinder(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public NaturalHazard[] find(NaturalHazard[] hazards) {
        ArrayList<NaturalHazard> result = new ArrayList<>();
        
        for (NaturalHazard hazard : hazards) {
            int year = hazard.getYear();
            if (year >= min && year <= max) {
                result.add(hazard);
            }
        }
        
        return result.toArray(new NaturalHazard[0]);
    }
} 