// yourcode 데코레이터 패턴 하나더 추가하기

public class DescriptionPOIDecorator extends POIDecorator {
    private String description;

        // POI에 설명 정보를 추가하는 데코레이터
    public DescriptionPOIDecorator(IPOI base, String description) {
            // 기본 POI와 설명 정보를 받음
        super(base);
        this.description = description;
    }

    @Override
    public String getInformation() {
        // 설명 정보를 포함하여 POI 정보를 반환
        return decoratedPOI.getInformation() + " [Description: " + description + "]";
    }
}
