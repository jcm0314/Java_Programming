// LAB5, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package finder;

import model.NaturalHazard;

public class NaturalHazardLatitudeLongitudeFinderStrategy implements IFinderStrategy<NaturalHazard> {
    private double minLat;
    private double maxLat;
    private double minLon;
    private double maxLon;

    public NaturalHazardLatitudeLongitudeFinderStrategy(double minLat, double maxLat, double minLon, double maxLon) {
        this.minLat = minLat;
        this.maxLat = maxLat;
        this.minLon = minLon;
        this.maxLon = maxLon;
    }

    @Override
    public boolean match(NaturalHazard item) {
        double latitude = item.getLatitude();
        double longitude = item.getLongitude();
        return latitude >= minLat && latitude <= maxLat &&
               longitude >= minLon && longitude <= maxLon;
    }
} 