// LAB4, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package finder;

import model.Tsunami;

public class TsunamiCountryFinderStrategy implements IFinderStrategy<Tsunami> {
    private String country;

    public TsunamiCountryFinderStrategy(String country) {
        this.country = country;
    }

    @Override
    public boolean match(Tsunami item) {
        return item.getCountry().equals(country);
    }
} 