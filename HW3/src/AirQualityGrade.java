// HW2, 자바프로그래밍, 2분반, 2025.04.17, 32203919, 장천명
// yourcode로 대기질 등급을 나타내도록함함
/**
 * 대기질 등급을 나타내는 열거형
 * GOOD: 좋음
 * MODERATE: 보통
 * UNHEALTHY: 나쁨
 */
public enum AirQualityGrade {
    GOOD, MODERATE, UNHEALTHY;

    /**
     * PM2.5 농도에 따른 대기질 등급을 반환
     * @param value PM2.5 농도 (μg/m³)
     * @return 대기질 등급
     */
    public static AirQualityGrade fromPm25(double value) {
        if (value <= 30) return GOOD;
        else if (value <= 80) return MODERATE;
        else return UNHEALTHY;
    }

    /**
     * PM10 농도에 따른 대기질 등급을 반환
     * @param value PM10 농도 (μg/m³)
     * @return 대기질 등급
     */
    public static AirQualityGrade fromPm10(double value) {
        if (value <= 50) return GOOD;
        else if (value <= 100) return MODERATE;
        else return UNHEALTHY;
    }

    /**
     * 오존(O3) 농도에 따른 대기질 등급을 반환
     * @param value 오존 농도 (ppm)
     * @return 대기질 등급
     */
    public static AirQualityGrade fromO3(double value) {
        if (value <= 0.03) return GOOD;
        else if (value <= 0.09) return MODERATE;
        else return UNHEALTHY;
    }

    /**
     * 이산화질소(NO2) 농도에 따른 대기질 등급을 반환
     * @param value 이산화질소 농도 (ppm)
     * @return 대기질 등급
     */
    public static AirQualityGrade fromNo2(double value) {
        if (value <= 0.03) return GOOD;
        else if (value <= 0.06) return MODERATE;
        else return UNHEALTHY;
    }

    /**
     * 일산화탄소(CO) 농도에 따른 대기질 등급을 반환
     * @param value 일산화탄소 농도 (ppm)
     * @return 대기질 등급
     */
    public static AirQualityGrade fromCo(double value) {
        if (value <= 2.0) return GOOD;
        else if (value <= 9.0) return MODERATE;
        else return UNHEALTHY;
    }

    /**
     * 이산화황(SO2) 농도에 따른 대기질 등급을 반환
     * @param value 이산화황 농도 (ppm)
     * @return 대기질 등급
     */
    public static AirQualityGrade fromSo2(double value) {
        if (value <= 0.02) return GOOD;
        else if (value <= 0.05) return MODERATE;
        else return UNHEALTHY;
    }
}
