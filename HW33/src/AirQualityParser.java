/**
 * 대기질 데이터를 파싱하는 클래스
 */
public class AirQualityParser {
    /**
     * 2차원 문자열 배열로부터 대기질 데이터를 파싱하여 AirQuality 객체 배열로 변환
     * @param data 대기질 데이터가 포함된 2차원 문자열 배열
     * @return 파싱된 AirQuality 객체 배열
     */
    public static AirQuality[] parse(String[][] data) {
        AirQuality[] result = new AirQuality[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = AirQuality.fromStringArray(data[i]);
        }
        return result;
    }
}
