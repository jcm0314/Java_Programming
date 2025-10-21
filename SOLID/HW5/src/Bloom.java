public class Bloom {
    private final Season season;
    private final String color;
    private final int durationWeeks;

    public Bloom(Season season, String color, int durationWeeks) {
        this.season = season;
        this.color = color;
        this.durationWeeks = durationWeeks;
    }

    public Season getSeason() {
        return season;
    }

    public String getColor() {
        return color;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    @Override
    public String toString() {
        return "Bloom{season=" + season + ", color='" + color + "', duration=" + durationWeeks + " weeks}";
    }
}
