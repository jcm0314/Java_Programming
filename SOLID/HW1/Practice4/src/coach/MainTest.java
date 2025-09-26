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
    swimmingCoach.subscribe(o1);
    swimmingCoach.subscribe(o2);
    swimmingCoach.subscribe(o3);
        // update
        swimmingCoach.lesson();
        System.out.println();
        
        // removeObserver
    swimmingCoach.unsubscribe(o2);
        swimmingCoach.swim();
        System.out.println();

    tennisCoach.subscribe(o2);
    tennisCoach.subscribe(o3);
        tennisCoach.match();
        System.out.println();

    tennisCoach.unsubscribe(o2);
        tennisCoach.play();

    }
}