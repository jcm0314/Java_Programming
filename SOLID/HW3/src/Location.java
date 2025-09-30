/**
 * Location 클래스
 * 위도와 경도 정보를 담는 데이터 클래스
 * 위치 기반 서비스에서 사용되는 기본 위치 정보
 */
public class Location {
    /** 위도 (latitude) */
    public final double lat;
    /** 경도 (longitude) */
    public final double lon;

    /**
     * Location 생성자
     * @param lat 위도
     * @param lon 경도
     */
    public Location(double lat, double lon) { 
        this.lat = lat; 
        this.lon = lon; 
    }

    /**
     * Location 객체의 문자열 표현
     * @return "위도, 경도" 형태의 문자열
     */
    @Override public String toString() { 
        return lat + ", " + lon; 
    }
}
