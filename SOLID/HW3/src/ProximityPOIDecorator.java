// POI가 근접 반경 내에 있는지 여부를 동적으로 추가하는 데코레이터
public class ProximityPOIDecorator extends POIDecorator {
    private Location currentLocation; // 현재 위치
    private double radiusMeter;       // 근접 반경(미터)

    // 기존 데코레이터 체인, 현재 위치, 반경을 받아 저장
    public ProximityPOIDecorator(IPOI base, Location current, double radiusMeter) {
        super(base);
        this.currentLocation = current;
        this.radiusMeter = radiusMeter;
    }

    // getInformation: 기존 정보 + 근접 여부 정보 추가
    @Override
    public String getInformation() {
        POI poi = POIDecorator.unwrapPOI(decoratedPOI); // 가장 안쪽 POI 객체 추출
        double d = GeoUtil.distanceMeters(currentLocation, poi.location); // 현재 위치와 POI 사이의 거리 계산
        boolean inside = d <= radiusMeter; // 근접 반경 이내인지 여부
        return decoratedPOI.getInformation() + String.format(" | proximity=%s(%.1fm<=%.1fm)", inside, d, radiusMeter); // 정보 반환
    }
}
