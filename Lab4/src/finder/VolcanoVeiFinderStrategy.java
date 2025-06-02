// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;
import model.VolcanicExplosivityIndex;

public class VolcanoVeiFinderStrategy implements IFinderStrategy<Volcano> {
    private VolcanicExplosivityIndex vei;

    public VolcanoVeiFinderStrategy(VolcanicExplosivityIndex vei) {
        this.vei = vei;
    }

    @Override
    public boolean match(Volcano item) {
        return item.getVei() == vei.getValue();
    }
} 