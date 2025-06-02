// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package parser;

import java.util.ArrayList;
import java.util.List;
import model.Earthquake;

/**
 * 지진 데이터를 파싱하는 클래스
 * 문자열 배열 형태의 데이터를 Earthquake 객체 배열로 변환
 * 빈 문자열 처리 및 데이터 타입 변환 기능 포함
 */
public class EarthquakeParser implements IParser<Earthquake> {
    @Override
    public List<Earthquake> parse(String[][] earthquakeData) {
        List<Earthquake> earthquakes = new ArrayList<>();
        
        for (String[] data : earthquakeData) {
            
            // 데이터 파싱
            int year = Integer.parseInt(data[0]);
            int month = Integer.parseInt(data[1]);
            int day = data[2].isEmpty() ? 0 : Integer.parseInt(data[2]);  // 빈 문자열 처리
            String location = data[3];
            double latitude = Double.parseDouble(data[4]);
            double longitude = Double.parseDouble(data[5]);
            int depth = Integer.parseInt(data[6]);
            double magnitude = Double.parseDouble(data[7]);
            
            // Earthquake 객체 생성
            earthquakes.add(new Earthquake(year, month, day, location,
                                         latitude, longitude, depth, magnitude));
        }
        
        return earthquakes;
    }
} 