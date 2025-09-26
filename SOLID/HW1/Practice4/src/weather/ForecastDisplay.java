package weather;

public class ForecastDisplay implements Observer {
    
    @Override
    public void update() {
        System.out.println("Forecast: More of the same");   
    }
