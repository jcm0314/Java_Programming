// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.Volcano;

public class VolcanoCountryFinderStrategy implements IFinderStrategy<Volcano> {
    private String country;

    public VolcanoCountryFinderStrategy(String country) {
        this.country = country;
    }

    @Override
    public boolean match(Volcano item) {
        return item.getCountry().equals(country);
    }
} 