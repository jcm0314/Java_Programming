// HW2, 자바프로그래밍, 2분반, 2025.04.17, 32203919, 장천명
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 대기질 정보를 저장하고 관리하는 클래스
 */
public class AirQuality {
    // 측정 시간
    private LocalDateTime measurementDateTime;
    // 측정소 이름
    private String measurementStationName;
    // 미세먼지(PM2.5) 농도
    private double pm25;
    // 미세먼지(PM10) 농도
    private double pm10;
    // 오존(O3) 농도
    private double o3;
    // 이산화질소(NO2) 농도
    private double no2;
    // 일산화탄소(CO) 농도
    private double co;
    // 이산화황(SO2) 농도
    private double so2;

    /**
     * 대기질 정보를 초기화하는 생성자
     * @param measurementDateTime 측정 시간
     * @param measurementStationName 측정소 이름
     * @param pm25 PM2.5 농도
     * @param pm10 PM10 농도
     * @param o3 오존 농도
     * @param no2 이산화질소 농도
     * @param co 일산화탄소 농도
     * @param so2 이산화황 농도
     */
    public AirQuality(LocalDateTime measurementDateTime, String measurementStationName,
                      double pm25, double pm10, double o3, double no2, double co, double so2) {
        this.measurementDateTime = measurementDateTime;
        this.measurementStationName = measurementStationName;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.o3 = o3;
        this.no2 = no2;
        this.co = co;
        this.so2 = so2;
    }

    /**
     * 문자열 배열로부터 대기질 정보를 생성하는 정적 메서드
     * @param row 대기질 정보가 포함된 문자열 배열
     * @return 생성된 AirQuality 객체
     */
    public static AirQuality fromStringArray(String[] row) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return new AirQuality(
            LocalDateTime.parse(row[0], formatter),
            row[1],
            Double.parseDouble(row[2]),
            Double.parseDouble(row[3]),
            Double.parseDouble(row[4]),
            Double.parseDouble(row[5]),
            Double.parseDouble(row[6]),
            Double.parseDouble(row[7])
        );
    }

    /**
     * 대기질 등급 정보를 출력하는 정적 메서드
     * @param aq 출력할 대기질 정보 객체
     */
    public static void printGrades(AirQuality aq) {
        System.out.println("측정소: " + aq.getMeasurementStationName());
        System.out.println("측정시간: " + aq.getMeasurementDateTime());
        System.out.println("PM2.5 등급: " + AirQualityGrade.fromPm25(aq.getPm25()));
        System.out.println("PM10 등급: " + AirQualityGrade.fromPm10(aq.getPm10()));
        System.out.println("O3 등급: " + AirQualityGrade.fromO3(aq.getO3()));
        System.out.println("NO2 등급: " + AirQualityGrade.fromNo2(aq.getNo2()));
        System.out.println("CO 등급: " + AirQualityGrade.fromCo(aq.getCo()));
        System.out.println("SO2 등급: " + AirQualityGrade.fromSo2(aq.getSo2()));
        System.out.println("--------------------------------------------");
    }

    // Getter 메서드들
    public LocalDateTime getMeasurementDateTime() { return measurementDateTime; }
    public String getMeasurementStationName() { return measurementStationName; }
    public double getPm25() { return pm25; }
    public double getPm10() { return pm10; }
    public double getO3() { return o3; }
    public double getNo2() { return no2; }
    public double getCo() { return co; }
    public double getSo2() { return so2; }

    /**
     * 객체의 문자열 표현을 반환하는 메서드
     * @return 대기질 정보를 포함한 문자열
     */
    @Override
    public String toString() {
        return "AirQuality{" +
                "datetime=" + measurementDateTime +
                ", station='" + measurementStationName + '\'' +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", o3=" + o3 +
                ", no2=" + no2 +
                ", co=" + co +
                ", so2=" + so2 +
                '}';
    }
}
