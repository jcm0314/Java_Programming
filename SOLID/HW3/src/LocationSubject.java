public interface LocationSubject {
    void addObserver(LocationObserver observer);
    void removeObserver(LocationObserver observer);
    void updateLocation(Location latLon);
}
