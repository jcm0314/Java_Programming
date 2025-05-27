// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package parser;

import model.Volcano;

/**
 * 화산 데이터를 파싱하는 클래스
 * 문자열 배열 형태의 데이터를 Volcano 객체 배열로 변환
 * 빈 문자열 처리 및 데이터 타입 변환 기능 포함
 */
public class VolcanoParser {
    public static Volcano[] parse(String[][] volcanoData) {
        Volcano[] volcanoes = new Volcano[volcanoData.length];
        
        for (int i = 0; i < volcanoData.length; i++) {
            String[] data = volcanoData[i];
            
            // 데이터 파싱
            int year = Integer.parseInt(data[0]);
            int month = Integer.parseInt(data[1]);
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
            volcanoes[i] = new Volcano(year, month, day, name, region, country,
                                     latitude, longitude, elevation, type, vei);
        }
        
        return volcanoes;
    }
} 