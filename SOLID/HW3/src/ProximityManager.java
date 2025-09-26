import java.util.List;
import java.util.Set;
import java.util.Objects;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashSet;




public class ProximityManager implements LocationObserver, ProximitySubject {
    
    private List<POI> all;
    private int topK;
    private double proximityMeters;
    private List<ProximityObserver> observers = new ArrayList<>();
    private Set<String> nearestNames = new HashSet<>();
    private List<String> nearestOrder = new ArrayList<>();
    private Set<String> inside = new HashSet<>();
    
    
    
    
    
    public ProximityManager(List<POI> all, int topK, double proximityMeters) {
        this.all = Objects.requireNonNull(all);
        this.topK = Math.max(1, topK);
        this.proximityMeters = Math.max(0.0, proximityMeters);
        }

    @Override 
    public void onLocationChanged(Location here) {
    // 거리 계산(GeoUtil사용) 및 정렬
        List<POI> nearest = all.stream()
            .sorted(Comparator.comparingDouble(poi -> GeoUtil.distanceMeters(here, poi.location)))
            .limit(topK)
            .collect(Collectors.toList());
        // 가장 근접한 Top-K 목록 작성
        List<String> currentOrder = nearest.stream()
            .map(poi -> poi.name)
            .collect(Collectors.toList());

        // 변화가 있으면 onNearestChanged 통지
        if (!nearestOrder.equals(currentOrder)) {
            observers.forEach(observer -> observer.onNearestChanged(nearest));
            nearestOrder = currentOrder;  // 현재를 저장
            }
        // 근접 반경 enter/exit 통지
        Set<String> newInside = new HashSet<>();
        nearest.forEach(poi -> {
            double distance = GeoUtil.distanceMeters(here, poi.location);
            if (distance <= proximityMeters) {
                newInside.add(poi.name);
                if (!inside.contains(poi.name)) {
                    observers.forEach(observer -> observer.onEnter(poi, distance));
                }
            }
        });

        inside.forEach(name -> {
            if (!newInside.contains(name)) {
                POI poi = all.stream().filter(p -> p.name.equals(name)).findFirst().orElse(null);
                if (poi != null) {
                    double distance = GeoUtil.distanceMeters(here, poi.location);
                    observers.forEach(observer -> observer.onExit(poi, distance));
                }
            }
        });
        inside = newInside;
    }

        

    @Override
    public void addObserver(ProximityObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ProximityObserver observer) {
        observers.remove(observer);
    }
    
}