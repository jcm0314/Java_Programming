package minmaxfinder;

public class MinMaxFinder {
    private IComparator comparator = null;

    public MinMaxFinder() {
        this.comparator = new NaturalNumComparator();
    }

    public MinMaxFinder(IComparator comparator) {
        this.comparator = comparator;
    }

    public void setComparator(IComparator comparator) {
        this.comparator = comparator;
    }

    public double findMax(double[] numbers) {
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (comparator.isLesser(max, numbers[i])) {
                max = numbers[i];
            }
        }
        return max; 
    }

    public double findMin(double[] numbers) {
        double min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (comparator.isLesser(numbers[i], min)) {
                min = numbers[i];
            }
        }
        return min; 
    }
}