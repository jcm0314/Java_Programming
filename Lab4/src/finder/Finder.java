// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import java.util.ArrayList;
import java.util.List;

public class Finder<T> {
    private IFinderStrategy<T> strategy;

    public Finder(IFinderStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public List<T> find(List<T> items) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (strategy.match(item)) {
                result.add(item);
            }
        }
        return result;
    }
} 