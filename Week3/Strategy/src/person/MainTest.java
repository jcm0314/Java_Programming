package person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

    public MainTest() {
        Person[] people = {
            new Person(3000, "Dooly"),
            new Person(30, "Ddochi"),
            new Person(25, "Michol"),
            new Person(20000, "Douner"),
            new Person(3, "Heedong")
        };

        List<Person> pList = new ArrayList<>();
        for (var p : people) {
            System.out.println(p);
            pList.add(p);
        }

        System.out.println("\nsort by default (name)");
        Arrays.sort(people, null);
        for (var p : people) {
            System.out.println(p);
        }

        System.out.println("\nsort by age");
        Arrays.sort(people, new AgeComparator());
        for (var p : people) {
            System.out.println(p);
        }

        System.out.println("\nsort by name");
        Arrays.sort(people, new NameComparator());
        for (var p : people) {
            System.out.println(p);
        }

        System.out.println("\n pList sort by default (name)");
        pList.sort(null);
        pList.forEach(System.out::println);

        System.out.println("\n pList sort by age");
        pList.sort(new AgeComparator());
        pList.forEach(System.out::println);

        System.out.println("\n pList sort by name");
         pList.sort(new NameComparator());
        pList.forEach(System.out::println);
    }

}