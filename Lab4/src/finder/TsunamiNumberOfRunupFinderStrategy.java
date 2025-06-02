// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Tsunami;

public class TsunamiNumberOfRunupFinderStrategy implements IFinderStrategy<Tsunami> {
    private int min;
    private int max;

    public TsunamiNumberOfRunupFinderStrategy(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean match(Tsunami item) {
        int runup = item.getNumberOfRunup();
        return runup >= min && runup <= max;
    }
} 