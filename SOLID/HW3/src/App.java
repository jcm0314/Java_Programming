import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        // POI 객체를 JSON 파일에서 불러옵니다.
        List<POI> pois = POIGsonFileLoader.load("NewPOI.json");
        pois.forEach(System.out::println);
        
        // 데코레이터 패턴을 적용한 POI 리스트를 불러옵니다.
        List<IPOI> decoratedBase = POIGsonFileLoader.loadAsDecorated("NewPOI.json");
        System.out.println("== Base decorated (from JSON) ==");
        decoratedBase.forEach(d -> System.out.println(" - " + d.getInformation()));

        // DescriptionPOIDecorator 예시 출력
        System.out.println("\n== Description Decorator Example ==");
        if (!decoratedBase.isEmpty()) {
            IPOI descPOI = new DescriptionPOIDecorator(decoratedBase.get(0), "간단한 설명 예시");
            System.out.println(" - " + descPOI.getInformation());
        }

        // 경로를 따라가며 거리/근접 데코레이터 적용 결과 출력
        Location[] path = new Location[] {
            new Location(37.5779, 126.9760), 
            new Location(37.5784, 126.9766), 
            new Location(37.5789, 126.9772), 
            new Location(37.5795, 126.9787),
            new Location(37.5797, 126.9794), 
            new Location(37.5800, 126.9800) 
        };
        System.out.println("\n== Along path ==");
        for (Location cur : path) { 
            System.out.printf("\n-- step @ (%.5f, %.5f)%n", cur.getLat(), cur.getLon());
            for (IPOI baseChain : decoratedBase) {
                // 현재 위치 기준으로 거리/근접 데코레이터 적용
                IPOI decorated = new DistancePOIDecorator(baseChain, cur);
                decorated = new ProximityPOIDecorator(decorated, cur, 50.0); // 반경 50m 예시
                System.out.println(" - " + decorated.getInformation());
            }
        }
    }
}