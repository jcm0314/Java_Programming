// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;
import model.VolcanicExplosivityIndex;
import java.util.ArrayList;

public class VolcanoVeiFinder implements IVolcanoFinder {
    private VolcanicExplosivityIndex vei;

    public VolcanoVeiFinder(VolcanicExplosivityIndex vei) {
        this.vei = vei;
    }

    @Override
    public Volcano[] find(Volcano[] volcanoes) {
        ArrayList<Volcano> result = new ArrayList<>();
        
        for (Volcano volcano : volcanoes) {
            if (volcano.getVei() == vei.getValue()) {
                result.add(volcano);
            }
        }
        
        return result.toArray(new Volcano[0]);
    }
} 