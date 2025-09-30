import java.util.List;

/**
 * ProximityLogger 클래스
 * 근접 이벤트를 받아서 로그로 출력하는 클래스
 * ProximityObserver 인터페이스를 구현하여 Observer 패턴의 Observer 역할 수행
 */
public class ProximityLogger implements ProximityObserver {
    /**
     * 가장 가까운 POI 목록이 변경되었을 때 호출되는 메서드
     * Top-K POI 목록 변화를 로그로 출력
     * @param nearestSorted 거리순으로 정렬된 가장 가까운 POI 목록
     */
    @Override 
    public void onNearestChanged(List<POI> nearestSorted) {
        System.out.println("[LOG] nearestChanged-> " + nearestSorted);
    }
    
    /**
     * 근접 반경에 진입했을 때 호출되는 메서드
     * 근접 진입 이벤트를 로그로 출력
     * @param poi 진입한 POI 객체
     * @param d 현재 위치에서 POI까지의 거리 (미터)
     */
    @Override 
    public void onEnter(POI poi, double d) {
        System.out.printf("[LOG] enter %s @ %.2fm%n", poi.name, d);
    }
    
    /**
     * 근접 반경에서 이탈했을 때 호출되는 메서드
     * 근접 이탈 이벤트를 로그로 출력
     * @param poi 이탈한 POI 객체
     * @param d 현재 위치에서 POI까지의 거리 (미터)
     */
    @Override 
    public void onExit(POI poi, double d) {
        System.out.printf("[LOG] exit %s @ %.2fm%n", poi.name, d);
    }
}