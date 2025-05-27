// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;
import java.util.ArrayList;

public class VolcanoCountryFinder implements IVolcanoFinder {
    private String country;

    public VolcanoCountryFinder(String country) {
        this.country = country;
    }

    @Override
    public Volcano[] find(Volcano[] volcanoes) {
        ArrayList<Volcano> result = new ArrayList<>();
        
        for (Volcano volcano : volcanoes) {
            if (volcano.getCountry().equals(country)) {
                result.add(volcano);
            }
        }
        
        return result.toArray(new Volcano[0]);
    }
} 