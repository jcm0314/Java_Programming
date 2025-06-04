// LAB5, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package parser;

import java.util.ArrayList;
import java.util.List;
import model.Volcano;

/**
 * 화산 데이터를 파싱하는 클래스
 * 문자열 배열 형태의 데이터를 Volcano 객체 배열로 변환
 * 빈 문자열 처리 및 데이터 타입 변환 기능 포함
 */
public class VolcanoParser implements IParser<Volcano> { // IParser 인터페이스를 구현하는 VolcanoParser 클래스
    @Override // 문자열 배열을 파싱하여 Volcano 객체 리스트로 반환
    public List<Volcano> parse(String[][] volcanoData) { // 문자열 배열을 파싱하여 Volcano 객체 리스트로 반환
        List<Volcano> volcanoes = new ArrayList<>(); // 빈 리스트 생성
        for (String[] data : volcanoData) { // 문자열 배열을 순회하며 각 데이터를 파싱
            
            
            // 데이터 파싱
            int year = Integer.parseInt(data[0]);
            int month = Integer.parseInt(data[1]); // parseInt는 문자열을 숫자로 변환하는 Java의 정적 메서드
            int day = data[2].isEmpty() ? 0 : Integer.parseInt(data[2]);  // 빈 문자열 처리
            String name = data[3];
            String region = data[4];  // 지역 정보 추가
            String country = data[5];
            double latitude = Double.parseDouble(data[6]);
            double longitude = Double.parseDouble(data[7]);
            int elevation = Integer.parseInt(data[8]);
            String type = data[9];
            int vei = Integer.parseInt(data[10]);
            
            // Volcano 객체 생성
            volcanoes.add(new Volcano(year, month, day, name, region, country,
                                     latitude, longitude, elevation, type, vei));
        }
        
        return volcanoes;
    }
} 