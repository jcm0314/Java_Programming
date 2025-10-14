public abstract class POIDecorator implements IPOI{
    protected IPOI decoratedPOI;

    //데코레이터가 감싸고 있는 POI 객체
    protected POIDecorator(IPOI decoratedPOI) {
        this.decoratedPOI = decoratedPOI;
    }

    @Override
    public String getInformation() {
        return decoratedPOI.getInformation();
    }


    public static POI unwrapPOI(IPOI node) { // POI 객체를 감싸고 있는 모든 데코레이터를 벗겨내고 POI 객체 반환하는 함수
        if (node instanceof POIDecorator) { // 데코레이터라면 내부의 decoratedPOI로 재귀 호출
            return unwrapPOI(((POIDecorator) node).decoratedPOI); 
        } else {
            return (POI) node; // POI 객체라면 그대로 반환
        }
    }
}
