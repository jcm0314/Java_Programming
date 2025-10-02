public abstract class POIDecorator implements IPOI{
    protected IPOI decoratedPOI;

    protected POIDecorator(IPOI decoratedPOI) {
        this.decoratedPOI = decoratedPOI;
    }

    public static POI unwrapPOI(IPOI node) {
        // 구현 예정
    }
}
