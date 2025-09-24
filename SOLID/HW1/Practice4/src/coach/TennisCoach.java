package coach;

import java.util.ArrayList;
import java.util.List;

// TennisCoach 클래스는 Coach 인터페이스를 구현한 구체적인 Subject입니다.
// 회원(옵저버)들을 리스트로 관리하며, 알림을 보낼 수 있습니다.
public class TennisCoach implements Coach {
    List<Member> members = new ArrayList<>();

    // 테니스 경기를 시작할 때 모든 회원에게 알림을 보냅니다.
    public void play() {
        notifyObservers("regular tennis play");
    }

    // 테니스 매치를 시작할 때 모든 회원에게 알림을 보냅니다.
    public void match() {
        notifyObservers("tennis match!!");
    }

    // 회원(옵저버) 등록
    public void subscribe(Member m) {
        members.add(m);
    }

    // 회원(옵저버) 제거
    public void unsubscribe(Member m) {
        members.remove(m);
    }

    // 모든 회원에게 메시지 알림
    public void notifyObservers(String message) {
        members.forEach(m -> m.update(message));
    }
}
