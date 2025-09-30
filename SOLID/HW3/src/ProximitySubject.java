/**
 * ProximitySubject 인터페이스
 * 근접 이벤트를 관찰하는 Observer들을 관리하는 Subject의 계약
 * Observer 패턴의 Subject 역할을 담당
 */
public interface ProximitySubject {
    /**
     * 근접 이벤트를 관찰할 Observer 추가
     * @param observer 추가할 Observer 객체
     */
    void addObserver(ProximityObserver observer);
    
    /**
     * 근접 이벤트 관찰을 중단할 Observer 제거
     * @param observer 제거할 Observer 객체
     */
    void removeObserver(ProximityObserver observer);
}
