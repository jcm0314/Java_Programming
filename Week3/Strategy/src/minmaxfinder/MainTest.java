package minmaxfinder;

public class MainTest {

    public MainTest() {
        double[] numbers = { -20.5, 87.3, 12.3, 2.5, -5.7, 65.4 };

        System.out.println("Finding Minimum:");
        MinMaxFinder finder = new MinMaxFinder(new NaturalNumComparator());
        double max = finder.findMax(numbers);
        System.out.println("Maximum value: " + max);
        double min = finder.findMin(numbers);
        System.out.println("Minimum value: " + min);

        System.out.println("\nFinding Minimum by absolute value:");
        finder.setComparator(new AbsNumComparator());
        max = finder.findMax(numbers);
        System.out.println("Maximum value by absolute: " + max);
        min = finder.findMin(numbers);
        System.out.println("Minimum value by absolute: " + min);
    }
}