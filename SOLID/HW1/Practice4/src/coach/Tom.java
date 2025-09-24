package coach;

// Tom 클래스는 Member 인터페이스를 구현한 구체적인 옵저버입니다.
// Coach로부터 알림을 받으면 콘솔에 출력합니다.
public class Tom implements Member {
    @Override
    public void update(String message) {
        System.out.println("Tom received a message: " + message);
    }
}