/**
 * GeoUtil 클래스
 * 지리적 계산을 위한 유틸리티 클래스
 * Haversine 공식을 사용하여 두 지점 간의 거리를 계산
 */
public final class GeoUtil {
    /**
     * Haversine 공식을 사용하여 두 지점 간의 거리를 계산
     * 지구를 구로 가정하고 위도와 경도를 이용해 실제 거리를 계산
     * @param a 첫 번째 지점의 위치
     * @param b 두 번째 지점의 위치
     * @return 두 지점 간의 거리 (미터)
     */
    public static double distanceMeters(Location a, Location b) {
        // 지구의 반지름 (미터)
        final double R = 6371000.0;
        
        // 위도와 경도 차이를 라디안으로 변환
        double dLat = Math.toRadians(b.lat - a.lat);
        double dLon = Math.toRadians(b.lon - a.lon);
        double la1 = Math.toRadians(a.lat);
        double la2 = Math.toRadians(b.lat);
        
        // Haversine 공식 적용
        double h = Math.sin(dLat/2) * Math.sin(dLat/2) + 
                   Math.cos(la1) * Math.cos(la2) * 
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1-h));
        
        // 최종 거리 계산 (미터)
        return R * c;
    }
}
   