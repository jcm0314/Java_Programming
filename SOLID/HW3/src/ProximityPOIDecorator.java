public class ProximityPOIDecorator extends POIDecorator {
    private Location currentLocation;
    private double radiusMeter;
    
    public ProximityPOIDecorator(IPOI base, Location current, double radiusMeter) {
        super(base); this.currentLocation = current; this.radiusMeter = radiusMeter;
    }
    @Override public String getInformation() {
        POI poi = POIDecorator.unwrapPOI(decoratedPOI);
        double d = GeoUtil.distanceMeters(currentLocation, poi.location);
        boolean inside = d <= radiusMeter;
        return decoratedPOI.getInformation() + String.format(" | proximity=%s(%.1fm<=%.1fm)", inside, d, radiusMeter);
    }
}
