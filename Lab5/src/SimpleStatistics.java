import java.util.Arrays;

public class SimpleStatistics {
    private double[] data;

    public SimpleStatistics(double[] data) {
        this.data = data;
        Arrays.sort(this.data); // sort needed to facilitate median and mode
    }

    // mean
    public double mean() {
        double sum = 0.0;
        for (double d : data) {
            sum += d;
        }
        return sum/data.length;
    }

    // median
    public double median() {
        int n = data.length;
        if (n % 2 == 1) { // odd length
            return data[n/2];
        } else { // even length
            return (data[n/2 -1] + data[n/2])/2.0;
        }
    }

    // range
    public double range() {
        return data[data.length - 1] - data[0];
    }

    @Override
    public String toString() {
        return "{" +
            " data='" + Arrays.toString(this.data) + "'" +
            "}";
    }

    public void descriptiveStatistics() {
        System.out.println(Arrays.toString(this.data));
        System.out.println("mean=" + mean());
        System.out.println("median=" + median());
        System.out.println("range=" + range());
    }

}
