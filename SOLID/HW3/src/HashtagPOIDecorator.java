public class HashtagPOIDecorator extends POIDecorator {
    private String tags;

    public HashtagPOIDecorator(IPOI base, String tags) {
        super(base);
        this.tags = tags;
    }

    @Override
    public String getInformation() {
        return decoratedPOI.getInformation() + " [Category: " + tags + "]";
    }
}
