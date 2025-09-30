import java.util.List;

/**
 * yourcode(yourclass?) 옵저버 하나 더 추가
 * SoundAlarm 클래스
 * 근접 이벤트를 받아서 소리 알림을 출력하는 클래스
 * ProximityObserver 인터페이스를 구현하여 Observer 패턴의 Observer 역할 수행
 */
public class SoundAlarm implements ProximityObserver {

    /**
     * 가장 가까운 POI 목록이 변경되었을 때 호출되는 메서드
     * 소리 알림은 진입/이탈 이벤트만 처리하므로 여기서는 아무것도 하지 않음
     * @param nearest 거리순으로 정렬된 가장 가까운 POI 목록
     */
    @Override
    public void onNearestChanged(List<POI> nearest) {
        // 소리 알림은 진입/이탈 이벤트만 처리
    }

    /**
     * 근접 반경에 진입했을 때 호출되는 메서드
     * 사용자에게 근접 진입 소리 알림을 출력
     * @param poi 진입한 POI 객체
     * @param distance 현재 위치에서 POI까지의 거리 (미터)
     */
    @Override
    public void onEnter(POI poi, double distance) {
        System.out.println("(SOUNDALARM) BEEP! 근접 진입 알림: " + poi.name + " (거리: " + String.format("%.1f", distance) + "m)");
    }

    /**
     * 근접 반경에서 이탈했을 때 호출되는 메서드
     * 사용자에게 근접 이탈 소리 알림을 출력
     * @param poi 이탈한 POI 객체
     * @param distance 현재 위치에서 POI까지의 거리 (미터)
     */
    @Override
    public void onExit(POI poi, double distance) {
        System.out.println("(SOUNDALARM) 근접 이탈 알림: " + poi.name + " (거리: " + String.format("%.1f", distance) + "m)");
    }
}
