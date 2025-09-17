package minmaxfinder;

public class AbsNumComparator implements IComparator {

    @Override
    public boolean isLesser(double o1, double o2) {
        return Math.abs(o1) < Math.abs(o2);
    }
}