
public class Location {
    //위도
    public final double lat;
    //경도
    public final double lon;

    // 생성자: 위도와 경도를 받아 저장
    public Location(double lat, double lon) { 
        this.lat = lat; 
        this.lon = lon; 
    }
    
    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }

    @Override public String toString() { 
        return lat + ", " + lon; 
    }
}
