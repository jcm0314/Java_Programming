
public class POI implements IPOI{
   // 관심지점 이름
    public final String name;
    // 관심지점의 위치 정보
    public final Location location;

    // 이름과 위치 정보를 받아 저장
    public POI(String name, Location location) {
        this.name = name; 
        this.location = location;
    }

    @Override
    public String getInformation() {
        return name + " @ " + location;
    }

    @Override
    public String toString() {
        return name + " @ " + location.lat + ", " + location.lon;
    }
}

