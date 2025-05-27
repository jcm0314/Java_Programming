// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package finder;

import model.NaturalHazard;
import java.util.ArrayList;

public class NaturalHazardElevationFinder implements INaturalHazardFinder {
    private double minLat;
    private double maxLat;
    private double minLon;
    private double maxLon;

    public NaturalHazardElevationFinder(double minLat, double maxLat, double minLon, double maxLon) {
        this.minLat = minLat;
        this.maxLat = maxLat;
        this.minLon = minLon;
        this.maxLon = maxLon;
    }

    @Override
    public NaturalHazard[] find(NaturalHazard[] hazards) {
        ArrayList<NaturalHazard> result = new ArrayList<>();
        
        for (NaturalHazard hazard : hazards) {
            double latitude = hazard.getLatitude();
            double longitude = hazard.getLongitude();
            
            if (latitude >= minLat && latitude <= maxLat &&
                longitude >= minLon && longitude <= maxLon) {
                result.add(hazard);
            }
        }
        
        return result.toArray(new NaturalHazard[0]);
    }
} 