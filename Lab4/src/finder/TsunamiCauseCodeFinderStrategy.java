// LAB4, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package finder;

import model.Tsunami;
import model.TsunamiCauseCode;

public class TsunamiCauseCodeFinderStrategy implements IFinderStrategy<Tsunami> {
    private TsunamiCauseCode code;

    public TsunamiCauseCodeFinderStrategy(TsunamiCauseCode code) {
        this.code = code;
    }

    @Override
    public boolean match(Tsunami item) {
        return item.getTsunamiCauseCode() == code;
    }
} 