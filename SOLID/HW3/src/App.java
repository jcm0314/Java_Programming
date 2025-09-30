import java.util.List;

/**
 * 메인 애플리케이션 클래스
 * Observer 패턴을 이용한 위치 기반 근접 알림 시스템의 실행부
 */
public class App {
    public static void main(String[] args) throws Exception {
        // 1. POI 데이터 로드 - JSON 파일에서 관심지점 정보 읽어오기
        List<POI> pois = POIGsonFileLoader.load("POI.json");

        // 2. 사용자 이동 경로 시뮬레이션 - 경복궁 주변 경로 설정
        Location[] path = new Location[] {
            new Location(37.5779, 126.9760), // 시작점
            new Location(37.5784, 126.9766), // 이동 중
            new Location(37.5789, 126.9772), // 근정전 근접 진입 가능한 위치
            new Location(37.5795, 126.9787), // 이동 중
            new Location(37.5797, 126.9794), // 향원정 근접 진입 가능한 위치
            new Location(37.5800, 126.9800)  // 향원정 이탈 가능한 위치
        };

        // 3. Observer 패턴 구성요소 생성
        LocationManager lm = new LocationManager(5.0, 500);      // 위치 관리자 (Subject)
        ProximityManager pm = new ProximityManager(pois, 2, 100.0); // 근접 관리자 (Subject & Observer)
        POIDetailView ui = new POIDetailView();                  // UI 표시기 (Observer)
        ProximityLogger log = new ProximityLogger();             // 로그 출력기 (Observer)
        SoundAlarm sound = new SoundAlarm();                     // 소리 알림기 (Observer)
        
        // 4. Observer 패턴 연결 설정 - 이중 Observer 패턴 구성
        lm.addObserver(pm);  // LocationManager → ProximityManager (위치 변화 알림)
        pm.addObserver(ui); // ProximityManager → POIDetailView (근접 이벤트 알림)
        pm.addObserver(log); // ProximityManager → ProximityLogger (근접 이벤트 로그)
        pm.addObserver(sound); // ProximityManager → SoundAlarm (근접 이벤트 소리 알림)

        // 5. 위치 업데이트 시뮬레이션 실행
        for (Location g : path) {
            System.out.println("locationManager.updateLocation(" + g + ")");
            lm.updateLocation(g);  // 위치 업데이트 → Observer 패턴 연쇄 실행
            Thread.sleep(600);     // 0.6초 대기 (실시간 시뮬레이션)
        }
    }
}