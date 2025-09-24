package weather;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer {
    private float min = 999;
    private float max = -999;
    private float avg = 0;
    private List<Float> tlist = new ArrayList<>();

    @Override
    public void update(float temperature, float humidity, float pressure) {
        tlist.add(temperature);
        
        float sum = 0;
        for (float t : tlist) {
            if (t < min) min = t;
            if (t > max) max = t;
            sum += t;
        }
        avg = sum/(int)tlist.size();
        System.out.println("minTemperature = " + min + " maxTemperature = " + max + " avgTemperature = " + avg);
    }
    
}