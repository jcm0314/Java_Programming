package coach;

public class MainTest {
    public MainTest() {
        // Subject1
        SwimmingCoach swimmingCoach = new SwimmingCoach();
        // Subject2
        TennisCoach tennisCoach = new TennisCoach();
        // Observer1
        Tom o1 = new Tom();
        // Observer2
        Jerry o2 = new Jerry();
        // Observer3
        Mitty o3 = new Mitty();
        
        // addObserver
        swimmingCoach.subscribeObserver(o1);
        swimmingCoach.subscribeObserver(o2);
        swimmingCoach.subscribeObserver(o3);
        // update
        swimmingCoach.lesson();
        System.out.println();
        
        // removeObserver
        swimmingCoach.unsubscribeObserver(o2);
        swimmingCoach.swim();
        System.out.println();

        tennisCoach.subscribeObserver(o2);
        tennisCoach.subscribeObserver(o3);
        tennisCoach.match();
        System.out.println();

        tennisCoach.unsubscribeObserver(o2);
        tennisCoach.play();

    }
}