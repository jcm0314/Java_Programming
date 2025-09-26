import java.util.List;

public class POIDetailView implements ProximityObserver{

    @Override
    public void onNearestChanged(List<POI> nearest) {
        System.out.println("[UI] Top-K nearest updated:");
        for (int i = 0; i < nearest.size(); i++) {
            POI poi = nearest.get(i);
            System.out.printf(" #%d %s @ %s%n", (i+1), poi.name, poi.location);
        }
    }

    @Override
    public void onEnter(POI poi, double distance) {
        System.out.printf("[UI] ENTER range: %s (%.1fm)%n", poi.name, distance);
    }

    @Override
    public void onExit(POI poi, double distance) {
        System.out.printf("[UI] EXIT range: %s (%.1fm)%n", poi.name, distance);
    }
}
