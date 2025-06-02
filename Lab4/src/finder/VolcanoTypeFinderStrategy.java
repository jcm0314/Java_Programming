// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;

public class VolcanoTypeFinderStrategy implements IFinderStrategy<Volcano> {
    private String type;

    public VolcanoTypeFinderStrategy(String type) {
        this.type = type;
    }

    @Override
    public boolean match(Volcano item) {
        return item.getType().equals(type);
    }
} 