import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // POI 목록 로드
        List<POI> pois = POIGsonFileLoader.load("POI.json");

        // 사용자 이동 시뮬레이션 경로
        Location[] path = new Location[] {
            new Location(37.5779, 126.9760),
            new Location(37.5784, 126.9766),
            new Location(37.5789, 126.9772), // 근정전 근접 진입 가능
            new Location(37.5795, 126.9787),
            new Location(37.5797, 126.9794), // 향원정 근접 진입 가능
            new Location(37.5800, 126.9800)  // 향원정 이탈 가능
        };

        // Observer 패턴 설정
        LocationManager lm = new LocationManager(5.0, 500);
        ProximityManager pm = new ProximityManager(pois, 2, 100.0);
        POIDetailView ui = new POIDetailView();
        ProximityLogger log = new ProximityLogger();
        
        // 연결 설정
        lm.addObserver(pm);  // LocationManager → ProximityManager
        pm.addObserver(ui); // ProximityManager → POIDetailView
        pm.addObserver(log); // ProximityManager → ProximityLogger

        // 위치 업데이트 시뮬레이션
        for (Location g : path) {
            lm.updateLocation(g);
            Thread.sleep(600);
        }
    }
}