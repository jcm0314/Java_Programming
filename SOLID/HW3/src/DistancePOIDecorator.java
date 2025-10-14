public class DistancePOIDecorator extends POIDecorator {
    private Location currentLocation;

    // POI와 현재 위치 간의 거리를 동적으로 추가하는 데코레이터
    public DistancePOIDecorator(IPOI base, Location current) {
        super(base);
        // 현재 위치 저장
        this.currentLocation = current;
    }

    // getInformation: 기존 정보 + 거리 정보 추가
    @Override
    public String getInformation() {
        POI poi = POIDecorator.unwrapPOI(decoratedPOI); // POI 객체 추출
        double d = GeoUtil.distanceMeters(currentLocation, poi.location); // 현재 위치와 POI 사이의 거리 계산
        return decoratedPOI.getInformation() + String.format(" | distance=%.1fm", d); // 거리 정보 추가
    }
}