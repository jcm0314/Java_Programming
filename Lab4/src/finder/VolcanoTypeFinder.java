// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;
import java.util.ArrayList;

public class VolcanoTypeFinder implements IVolcanoFinder {
    private String type;

    public VolcanoTypeFinder(String type) {
        this.type = type;
    }

    @Override
    public Volcano[] find(Volcano[] volcanoes) {
        ArrayList<Volcano> result = new ArrayList<>();
        
        for (Volcano volcano : volcanoes) {
            if (volcano.getType().equals(type)) {
                result.add(volcano);
            }
        }
        
        return result.toArray(new Volcano[0]);
    }
} 