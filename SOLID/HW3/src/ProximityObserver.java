import java.util.List;



public interface ProximityObserver {
    public void onNearestChanged(List<POI> nearestSorted);
    public void onEnter(POI poi, double d);
    public void onExit(POI poi, double d);
}
