public class DistancePOIDecorator extends POIDecorator {
    private Location currentLocation;

    public DistancePOIDecorator(IPOI base, Location current) {
        super(base);
        this.currentLocation = current;
    }

    @Override
    public String getInformation() {
        POI poi = POIDecorator.unwrapPOI(decoratedPOI); // POI 객체 추출
        double d = GeoUtil.distanceMeters(currentLocation, poi.location); // 현재 위치와 POI 사이의 거리 계산
        return decoratedPOI.getInformation() + String.format(" | distance=%.1fm", d); // 거리 정보 추가
    }
}