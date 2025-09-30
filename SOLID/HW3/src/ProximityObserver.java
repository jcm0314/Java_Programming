import java.util.List;

/**
 * ProximityObserver 인터페이스
 * 근접 이벤트를 감지하고 반응하는 Observer의 계약
 * Observer 패턴의 Observer 역할을 담당
 */
public interface ProximityObserver {
    /**
     * 가장 가까운 POI 목록이 변경되었을 때 호출되는 메서드
     * @param nearestSorted 거리순으로 정렬된 가장 가까운 POI 목록
     */
    public void onNearestChanged(List<POI> nearestSorted);
    
    /**
     * 근접 반경에 진입했을 때 호출되는 메서드
     * @param poi 진입한 POI 객체
     * @param d 현재 위치에서 POI까지의 거리 (미터)
     */
    public void onEnter(POI poi, double d);
    
    /**
     * 근접 반경에서 이탈했을 때 호출되는 메서드
     * @param poi 이탈한 POI 객체
     * @param d 현재 위치에서 POI까지의 거리 (미터)
     */
    public void onExit(POI poi, double d);
}
