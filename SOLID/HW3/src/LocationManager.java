import java.util.ArrayList;
import java.util.List;

/**
 * LocationManager 클래스
 * 위치 변화를 감지하고 관리하는 핵심 클래스
 * LocationSubject 인터페이스를 구현하여 Observer 패턴의 Subject 역할 수행
 * 스로틀링 기능을 통해 의미있는 위치 변화만 Observer들에게 알림
 */
public class LocationManager implements LocationSubject {
    /** 위치 변화를 관찰하는 Observer들의 목록 */
    private List<LocationObserver> observers = new ArrayList<>();
    
    /** 마지막으로 알림을 보낸 위치 */
    private Location last = null;
    
    /** 마지막 업데이트 시간 (밀리초) */
    private long lastTsMs = 0;
    
    /** 거리 임계값 (미터) - 이 거리 이상 이동해야 알림 */
    private double distanceThresholdMeters;
    
    /** 최소 업데이트 간격 (밀리초) - 이 시간 이상 지나야 알림 */
    private long minUpdateIntervalsMs;

    /**
     * LocationManager 생성자
     * @param distanceThresholdMeters 거리 임계값 (미터)
     * @param minUpdateIntervalsMs 최소 업데이트 간격 (밀리초)
     */
    public LocationManager(double distanceThresholdMeters, long minUpdateIntervalsMs) {
        this.distanceThresholdMeters = distanceThresholdMeters;
        this.minUpdateIntervalsMs = minUpdateIntervalsMs;
    }

    /**
     * 위치 변화를 관찰할 Observer 추가
     * @param observer 추가할 Observer 객체
     */
    @Override
    public void addObserver(LocationObserver observer) {
        observers.add(observer);
    }

    /**
     * 위치 변화 관찰을 중단할 Observer 제거
     * @param observer 제거할 Observer 객체
     */
    @Override
    public void removeObserver(LocationObserver observer) {
        observers.remove(observer);
    }

    /**
     * 새로운 위치로 업데이트 (스로틀링 적용)
     * 스로틀링 조건: 거리 >= 임계값 OR 시간 >= 간격
     * @param newLocation 새로운 위치 정보
     */
    @Override
    public void updateLocation(Location newLocation) {
        // 첫 번째 위치 업데이트는 무조건 알림
        if (last == null || lastTsMs == 0) {
            last = newLocation;
            lastTsMs = System.currentTimeMillis();
            notifyObservers(newLocation);
            return;
        }

        // 스로틀링 체크: 거리와 시간 조건 확인
        double distance = GeoUtil.distanceMeters(last, newLocation);
        long timeDiff = System.currentTimeMillis() - lastTsMs;
    
        // 의미있는 변화인지 체크 (거리 또는 시간 조건 만족)
        if (distance >= distanceThresholdMeters || timeDiff >= minUpdateIntervalsMs) {
            last = newLocation;
            lastTsMs = System.currentTimeMillis();
            notifyObservers(newLocation);
        }
        // 의미없는 변화면 Observer들에게 알림하지 않음 (스로틀링)
    }

    /**
     * 모든 Observer들에게 위치 변화 알림
     * @param location 새로운 위치 정보
     */
    private void notifyObservers(Location location) {
        observers.forEach(observer -> observer.onLocationChanged(location));
    }
}

