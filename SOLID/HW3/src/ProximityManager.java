import java.util.List;
import java.util.Set;
import java.util.Objects;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * ProximityManager 클래스
 * 위치 기반 근접 이벤트를 관리하는 핵심 클래스
 * LocationObserver와 ProximitySubject를 동시에 구현하여 이중 Observer 패턴의 중간 역할 수행
 * - LocationObserver: LocationManager로부터 위치 변화를 받음
 * - ProximitySubject: POIDetailView, ProximityLogger에게 근접 이벤트를 알림
 */
public class ProximityManager implements LocationObserver, ProximitySubject {
    
    /** 모든 POI 목록 */
    private List<POI> all;
    
    /** 상위 K개 POI 추적 */
    private int topK;
    
    /** 근접 반경 (미터) */
    private double proximityMeters;
    
    /** 근접 이벤트를 관찰하는 Observer들의 목록 */
    private List<ProximityObserver> observers = new ArrayList<>();
    
    /** 이전 Top-K POI 이름들 (변화 감지용) */
    private Set<String> nearestNames = new HashSet<>();
    
    /** 이전 Top-K POI 순서 (변화 감지용) */
    private List<String> nearestOrder = new ArrayList<>();
    
    /** 현재 근접 반경 안에 있는 POI들 */
    private Set<String> inside = new HashSet<>();
    
    /**
     * ProximityManager 생성자
     * @param all 모든 POI 목록
     * @param topK 상위 K개 POI 추적
     * @param proximityMeters 근접 반경 (미터)
     */
    public ProximityManager(List<POI> all, int topK, double proximityMeters) {
        this.all = Objects.requireNonNull(all);
        this.topK = Math.max(1, topK);
        this.proximityMeters = Math.max(0.0, proximityMeters);
    }

    /**
     * 위치 변화를 받아서 근접 이벤트 처리 (LocationObserver 구현)
     * 1. 거리 계산 및 Top-K POI 정렬
     * 2. Top-K 목록 변화 감지 및 알림
     * 3. 근접 반경 진입/이탈 이벤트 감지 및 알림
     * @param here 현재 위치
     */
    @Override 
    public void onLocationChanged(Location here) {
        // 1. 거리 계산 및 정렬 - 모든 POI와의 거리를 계산하여 가까운 순으로 정렬
        List<POI> nearest = all.stream()
            .sorted(Comparator.comparingDouble(poi -> GeoUtil.distanceMeters(here, poi.location)))
            .limit(topK)
            .collect(Collectors.toList());
            
        // 2. 현재 Top-K 목록의 순서 저장 (변화 감지용)
        List<String> currentOrder = nearest.stream()
            .map(poi -> poi.name)
            .collect(Collectors.toList());

        // 3. Top-K 목록 변화 감지 및 알림
        if (!nearestOrder.equals(currentOrder)) {
            observers.forEach(observer -> observer.onNearestChanged(nearest));
            nearestOrder = currentOrder;  // 현재 순서를 이전 순서로 저장
        }
        
        // 4. 근접 반경 진입/이탈 이벤트 처리
        Set<String> newInside = new HashSet<>();
        
        // 현재 Top-K POI들 중 근접 반경 안에 있는 POI들 확인
        nearest.forEach(poi -> {
            double distance = GeoUtil.distanceMeters(here, poi.location);
            if (distance <= proximityMeters) {
                newInside.add(poi.name);
                // 새로 진입한 POI인 경우 ENTER 이벤트 발생
                if (!inside.contains(poi.name)) {
                    observers.forEach(observer -> observer.onEnter(poi, distance));
                }
            }
        });

        // 이전에 근접 반경 안에 있었지만 현재는 밖에 있는 POI들 확인
        inside.forEach(name -> {
            if (!newInside.contains(name)) {
                POI poi = all.stream().filter(p -> p.name.equals(name)).findFirst().orElse(null);
                if (poi != null) {
                    double distance = GeoUtil.distanceMeters(here, poi.location);
                    observers.forEach(observer -> observer.onExit(poi, distance));
                }
            }
        });
        
        // 현재 근접 반경 상태 업데이트
        inside = newInside;
    }

    /**
     * 근접 이벤트를 관찰할 Observer 추가 (ProximitySubject 구현)
     * @param observer 추가할 Observer 객체
     */
    @Override
    public void addObserver(ProximityObserver observer) {
        observers.add(observer);
    }

    /**
     * 근접 이벤트 관찰을 중단할 Observer 제거 (ProximitySubject 구현)
     * @param observer 제거할 Observer 객체
     */
    @Override
    public void removeObserver(ProximityObserver observer) {
        observers.remove(observer);
    }
}