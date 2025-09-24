// Coach 인터페이스는 옵저버 패턴의 'Subject' 역할입니다.
// 즉, 알림을 받을 객체(Member)를 등록/제거/알림하는 기능을 정의합니다.
public interface Coach {
    // 옵저버(회원)를 등록합니다.
    void subscribe(Member m);
    // 옵저버(회원)를 제거합니다.
    void unsubscribe(Member m);
    // 모든 옵저버에게 메시지를 알립니다.
    void notifyObservers(String message);
}
