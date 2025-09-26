import java.util.ArrayList;
import java.util.List;


public class LocationManager implements LocationSubject {
    List<LocationObserver> observers = new ArrayList<>();
    Location last = null; // 마지막 위치
    long lastTsMs = 0; // 마지막 업데이트 시간
    double distanceThresholdMeters; // 거리 임계값 (미터)
    long minUpdateIntervalsMs; // 최소 업데이트 간격 (밀리초)



    public LocationManager(double distanceThresholdMeters, long minUpdateIntervalsMs) {
        this.distanceThresholdMeters = distanceThresholdMeters;
        this.minUpdateIntervalsMs = minUpdateIntervalsMs;
    }

    @Override
    public void addObserver(LocationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(LocationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void updateLocation(Location newLocation) {
        if (last == null || lastTsMs == 0) {
            last = newLocation;
            lastTsMs = System.currentTimeMillis();
            observers.forEach(observer -> observer.onLocationChanged(newLocation)); // notify observers
            return;
        }

        // 거리 계산 (GeoUtil 사용)
        double distance = GeoUtil.distanceMeters(last, newLocation);
        long timeDiff = System.currentTimeMillis() - lastTsMs;
    
    // 의미있는 변화인지 체크
        if (distance >= distanceThresholdMeters || timeDiff >= minUpdateIntervalsMs) {
            last = newLocation;
            lastTsMs = System.currentTimeMillis();
            observers.forEach(observer -> observer.onLocationChanged(newLocation));
        }
    // 의미없는 변화면 아무것도 안 함
    }
}

