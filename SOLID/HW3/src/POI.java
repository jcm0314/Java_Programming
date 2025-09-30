/**
 * POI (Point of Interest) 클래스
 * 관심지점 정보를 담는 데이터 클래스
 * 이름과 위치 정보를 포함
 */
public class POI {
    /** 관심지점 이름 */
    public final String name;
    /** 관심지점의 위치 정보 */
    public final Location location;

    /**
     * POI 생성자
     * @param name 관심지점 이름
     * @param location 관심지점의 위치
     */
    public POI(String name, Location location) {
        this.name = name; 
        this.location = location;
    }

    /**
     * POI 객체의 문자열 표현
     * @return "이름 @ 위치" 형태의 문자열
     */
    @Override 
    public String toString() { 
        return name + " @ " + location; 
    }
}
