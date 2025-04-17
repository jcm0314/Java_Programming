import java.util.Random;

public class Lab5 {
    private static Random random = new Random();
    public static double[] assignArray(int length) {
        double[] arr = new double[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextGaussian(); // normal distribution
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("TemperatureConverter!");
        System.out.print("Please select 1. CELSIUS_TO_FAHRENHEIT, 2. FAHRENHEIT_TO_CELSIUS: ");
		TemperatureConverterType type = TemperatureConverterType.valueOf(UserInput.getIntegerBetween(1, 2));
        System.out.println("TemperatureConverterType=" + type);
        System.out.print("Please enter temperature:");
		float temperature = UserInput.getFloat();
        TemperatureConverter converter = new TemperatureConverter(type, temperature);
        System.out.println(converter);

        System.out.println("ArithmeticCalculator!");		
        System.out.print("Please enter the first number: ");
		int x = UserInput.getInteger();
		System.out.print("Please enter the second number: ");
		int y = UserInput.getInteger();
		char op = UserInput.getUserInputOp();
		ArithmeticCalculator calc = new ArithmeticCalculator(x, y, op);
		System.out.println(calc);

        // Example array of objects based on the provided data
        ArithmeticCalculator[] calculators = {
            new ArithmeticCalculator(10, 20, '+'),
            new ArithmeticCalculator(550, 50, '/'),
            new ArithmeticCalculator(50, 150, '*'),
            new ArithmeticCalculator(255, 10, '-'),
            new ArithmeticCalculator(553, 30, '%')
        };
        for (var calculator : calculators) {
            System.out.println(calculator);
        }

        double[] data = assignArray(1000);
        SimpleStatistics statistics = new SimpleStatistics(data);
        statistics.descriptiveStatistics(); // data, mean, median, range, standard deviation

    }
}
