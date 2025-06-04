// LAB5, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package finder;

import model.Tsunami;
import model.TsunamiEventValidity;

public class TsunamiEventValidityFinderStrategy implements IFinderStrategy<Tsunami> {
    private TsunamiEventValidity validity;

    public TsunamiEventValidityFinderStrategy(TsunamiEventValidity validity) {
        this.validity = validity;
    }

    @Override
    public boolean match(Tsunami item) {
        return item.getTsunamiEventValidity() == validity;
    }
} 