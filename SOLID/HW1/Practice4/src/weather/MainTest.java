package weather;

public class MainTest {
    public MainTest() {
        // Subject
        WeatherData weatherData = new WeatherData();
        // Observer1
        CurrentConditionDisplay o1 = new CurrentConditionDisplay();
        // Observer2
        ForecastDisplay o2 = new ForecastDisplay();
        // Observer3
        StatisticsDisplay o3 = new StatisticsDisplay();

        // addObserver ...
        weatherData.registerObserver(o1);
        // setMeasurements
        System.out.println();
        weatherData.setMeasurement(80, 65, 30.4f);

        // addObserver2,3 ...
        weatherData.registerObserver(o2);
        weatherData.registerObserver(o3);

        System.out.println();
        weatherData.setMeasurement(70, 60, 34);

        // removeObserver3
        weatherData.removeObserver(o3);

        System.out.println();
        weatherData.setMeasurement(60, 62, 30);
    }
}