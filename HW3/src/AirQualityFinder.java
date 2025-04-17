import java.util.ArrayList;

/**
 * 대기질 데이터를 검색하는 클래스
 */
public class AirQualityFinder {
    /**
     * PM2.5 농도 범위에 해당하는 대기질 데이터를 검색
     * @param data 검색할 대기질 데이터 배열
     * @param min 최소 PM2.5 농도
     * @param max 최대 PM2.5 농도
     * @return 검색된 대기질 데이터 배열
     */
    public static AirQuality[] findByPm25(AirQuality[] data, double min, double max) {
        ArrayList<AirQuality> list = new ArrayList<>();
        for (AirQuality aq : data) {
            if (aq.getPm25() >= min && aq.getPm25() <= max) {
                list.add(aq);
            }
        }
        return list.toArray(new AirQuality[0]);
    }

    /**
     * PM10 농도 범위에 해당하는 대기질 데이터를 검색
     * @param data 검색할 대기질 데이터 배열
     * @param min 최소 PM10 농도
     * @param max 최대 PM10 농도
     * @return 검색된 대기질 데이터 배열
     */
    public static AirQuality[] findByPm10(AirQuality[] data, double min, double max) {
        ArrayList<AirQuality> list = new ArrayList<>();
        for (AirQuality aq : data) {
            if (aq.getPm10() >= min && aq.getPm10() <= max) {
                list.add(aq);
            }
        }
        return list.toArray(new AirQuality[0]);
    }

    /**
     * PM2.5와 PM10 농도 범위에 모두 해당하는 대기질 데이터를 검색
     * @param data 검색할 대기질 데이터 배열
     * @param minPm25 최소 PM2.5 농도
     * @param maxPm25 최대 PM2.5 농도
     * @param minPm10 최소 PM10 농도
     * @param maxPm10 최대 PM10 농도
     * @return 검색된 대기질 데이터 배열
     */
    public static AirQuality[] find(AirQuality[] data, double minPm25, double maxPm25, double minPm10, double maxPm10) {
        ArrayList<AirQuality> list = new ArrayList<>();
        for (AirQuality aq : data) {
            if (aq.getPm25() >= minPm25 && aq.getPm25() <= maxPm25 &&
                aq.getPm10() >= minPm10 && aq.getPm10() <= maxPm10) {
                list.add(aq);
            }
        }
        return list.toArray(new AirQuality[0]);
    }
}
