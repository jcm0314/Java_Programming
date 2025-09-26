package coach;

// Member 인터페이스는 옵저버 패턴의 'Observer' 역할입니다.
// 즉, Coach(Subject)로부터 알림을 받는 객체의 동작을 정의합니다.
public interface Member {
    // Coach로부터 메시지를 받아 처리합니다.
    void update(String message);
}