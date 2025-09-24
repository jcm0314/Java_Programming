package coach;

import java.util.ArrayList;
import java.util.List;

// Subject1
public class SwimmingCoach implements Coach {
    List<Member> members = new ArrayList<>();
    
    public void swim() {
        notifyObservers("free swimming~~");
    }

    public void lesson() {
        notifyObservers("swimming lesson~~");
    }

    @Override
    public void subscribeObserver(Member m) {
        members.add(m);
    }

    @Override
    public void unsubscribeObserver(Member m) {
        members.remove(m);
    }

    @Override
    public void notifyObservers(String message) {
        members.forEach(m -> m.update(message));
    }

}