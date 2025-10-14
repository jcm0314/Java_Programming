
public final class GeoUtil {
    // 두 위치 간의 거리를 미터 단위로 계산하는 함수
    public static double distanceMeters(Location a, Location b) {

        final double R = 6371000.0;
        
        // 위도와 경도 차이를 라디안으로 변환
        double dLat = Math.toRadians(b.lat - a.lat);
        double dLon = Math.toRadians(b.lon - a.lon);
        double la1 = Math.toRadians(a.lat);
        double la2 = Math.toRadians(b.lat);
        

        double h = Math.sin(dLat/2) * Math.sin(dLat/2) + 
                   Math.cos(la1) * Math.cos(la2) * 
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1-h));
        
        // 최종 거리 계산 (미터)
        return R * c;
    }
}
   