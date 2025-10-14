public class CategoryPOIDecorator extends POIDecorator {
    private String category;

        // POI에 카테고리 정보를 추가하는 데코레이터
    public CategoryPOIDecorator(IPOI base, String category) {
             기본 POI와 카테고리 정보를 받음
        super(base);
        this.category = category;
    }

    @Override
    public String getInformation() {
            // 카테고리 정보를 포함하여 POI 정보를 반환
        return decoratedPOI.getInformation() + " [Category: " + category + "]";
    }
}
