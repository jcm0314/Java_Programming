// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;

public class VolcanoNameFinderStrategy implements IFinderStrategy<Volcano> {
    private String name;

    public VolcanoNameFinderStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean match(Volcano item) {
        return item.getName().equals(name);
    }
} 