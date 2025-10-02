public class CategoryPOIDecorator extends POIDecorator {
    private String category;

    public CategoryPOIDecorator(IPOI base, String category) {
        super(base);
        this.category = category;
    }

    @Override
    public String getInformation() {
        return decoratedPOI.getInformation() + " [Category: " + category + "]";
    }
}
