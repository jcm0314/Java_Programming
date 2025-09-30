/**
 * LocationSubject 인터페이스
 * 위치 변화를 관찰하는 Observer들을 관리하는 Subject의 계약
 * Observer 패턴의 Subject 역할을 담당
 */
public interface LocationSubject {
    /**
     * 위치 변화를 관찰할 Observer 추가
     * @param observer 추가할 Observer 객체
     */
    void addObserver(LocationObserver observer);
    
    /**
     * 위치 변화 관찰을 중단할 Observer 제거
     * @param observer 제거할 Observer 객체
     */
    void removeObserver(LocationObserver observer);
    
    /**
     * 새로운 위치로 업데이트
     * @param latLon 새로운 위치 정보 (위도, 경도)
     */
    void updateLocation(Location latLon);
}
