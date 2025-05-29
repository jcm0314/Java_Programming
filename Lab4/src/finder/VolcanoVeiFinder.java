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
        ArrayList<Volcano> result = new ArrayList<>(); // 동적 크기 배열 생성
        // 크기가 가변적, 추가가 용이, 메모리 효율적적
        for (Volcano volcano : volcanoes) { // 반복문과 조건 검사
            if (volcano.getVei() == vei.getValue()) {
                result.add(volcano);
            }
        }
        
        return result.toArray(new Volcano[0]); // 배열 반환환
    }
} 