// LAB5, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package finder;

import java.util.ArrayList;
import java.util.List;

public class Finder<T> {
    private IFinderStrategy<T> strategy; // 전략 객체

    public Finder(IFinderStrategy<T> strategy) {
        this.strategy = strategy; // 전략 객체 초기화
    }

    public List<T> find(List<T> items) {
        List<T> result = new ArrayList<>(); // 결과 리스트
        for (T item : items) {
            if (strategy.match(item)) { // 전략에 맞는 아이템 추가
                result.add(item); // 결과 리스트에 추가
            }
        }
        return result;
    }
} 