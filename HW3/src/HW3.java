/**
 * 대기질 데이터를 처리하고 출력하는 메인 클래스
 */
public class HW3 {
    /**
     * 프로그램의 진입점
     * @param args 명령행 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        // AirQualityData enum에서 모든 데이터 가져오기
        String[][] data = AirQualityData.getAllData();

        // 데이터 파싱
        AirQuality[] parsed = AirQualityParser.parse(data);

        // 전체 데이터 출력
        System.out.println("== 전체 데이터 출력 ==");
        for (AirQuality aq : parsed) {
            System.out.println(aq);
        }

        // PM2.5와 PM10 농도 범위에 따른 데이터 검색 및 출력
        System.out.println("\n== PM25 20~50, PM10 40~60 조건 검색 ==");
        AirQuality[] filtered = AirQualityFinder.find(parsed, 20, 50, 40, 60);
        for (AirQuality aq : filtered) {
            System.out.println(aq);
        }

        // PM2.5 농도만을 기준으로 검색 (20~50)
        System.out.println("\n== PM25 20~50 조건 검색 ==");
        AirQuality[] filteredByPm25 = AirQualityFinder.findByPm25(parsed, 20, 50);
        for (AirQuality aq : filteredByPm25) {
            System.out.println(aq);
        }

        // PM10 농도만을 기준으로 검색 (40~60)
        System.out.println("\n== PM10 40~60 조건 검색 ==");
        AirQuality[] filteredByPm10 = AirQualityFinder.findByPm10(parsed, 40, 60);
        for (AirQuality aq : filteredByPm10) {
            System.out.println(aq);
        }

        // 각 측정소의 대기질 등급 출력
        System.out.println("\n== 각 측정소 등급 출력 ==");
        for (AirQuality aq : parsed) {
            AirQuality.printGrades(aq);
        }
    }
}
