package minmaxfinder;

public class NaturalNumComparator implements IComparator {

    @Override
    public boolean isLesser(double o1, double o2) {
        return o1 < o2;
    }
}