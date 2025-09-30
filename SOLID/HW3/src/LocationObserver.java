/**
 * LocationObserver 인터페이스
 * 위치 변화를 감지하고 반응하는 Observer의 계약
 * Observer 패턴의 Observer 역할을 담당
 */
public interface LocationObserver {
    /**
     * 위치가 변화했을 때 호출되는 메서드
     * @param newLocation 새로운 위치 정보 (위도, 경도)
     */
    void onLocationChanged(Location newLocation);
}
