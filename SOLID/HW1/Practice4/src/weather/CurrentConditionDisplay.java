package weather;

// Observer 1
public class CurrentConditionDisplay implements Observer {      

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Current condition: temperature = " + temperature + " humidity = " + humidity + " pressure = " + pressure);
    }

}