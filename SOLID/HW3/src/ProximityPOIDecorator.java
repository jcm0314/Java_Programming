public class ProximityPOIDecorator extends POIDecorator {
    private Location currentLocation;
    private double radiusMeter;
    
    public ProximityPOIDecorator(IPOI base, Location current, double radiusMeter) {
        super(base); this.currentLocation = current; this.radiusMeter = radiusMeter;
    }
    @Override public String getInformation() {
        POI poi = POIDecorator.unwrapPOI(decoratedPOI); // POI 객체 추출
        double d = GeoUtil.distanceMeters(currentLocation, poi.location); // 현재 위치와 POI 사이의 거리 계산
        boolean inside = d <= radiusMeter; // 거리가 근접 반경 이내인지 확인
        return decoratedPOI.getInformation() + String.format(" | proximity=%s(%.1fm<=%.1fm)", inside, d, radiusMeter); // 근접 반경 정보 추가
    }
}
