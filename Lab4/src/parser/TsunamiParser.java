// LAB5, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package parser;

import java.util.ArrayList;
import java.util.List;
import model.Tsunami;
import model.TsunamiEventValidity;
import model.TsunamiCauseCode;

public class TsunamiParser implements IParser<Tsunami> {
    @Override
    public List<Tsunami> parse(String[][] tsunamiData) {
        List<Tsunami> tsunamis = new ArrayList<>();
        for (String[] data : tsunamiData) {
                int year = Integer.parseInt(data[0]);
                int month = Integer.parseInt(data[1]);
                int day = data[2].isEmpty() ? 1 : Integer.parseInt(data[2]);
                TsunamiEventValidity validity = TsunamiEventValidity.fromCode(Integer.parseInt(data[3]));
                TsunamiCauseCode causeCode = TsunamiCauseCode.fromCode(Integer.parseInt(data[4]));
                String country = data[5];
                String location = data[6];
                double latitude = Double.parseDouble(data[7]);
                double longitude = Double.parseDouble(data[8]);
                double maxWaterHeight = Double.parseDouble(data[9]);
                int numberOfRunup = Integer.parseInt(data[10]);

                tsunamis.add(new Tsunami(year, month, day, validity, causeCode, country, location, latitude, longitude,
                     maxWaterHeight, numberOfRunup));
        }
            
        return tsunamis;
    }
}

