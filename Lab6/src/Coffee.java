
public class Coffee { // Coffee has Origin and Roast
    private Origin origin;
    private Roast roast;

    public Coffee(Origin origin, Roast roast) {
        this.origin = origin;
        this.roast = roast;
    }

    public Origin getOrigin() {
        return this.origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Roast getRoast() {
        return this.roast;
    }

    public void setRoast(Roast roast) {
        this.roast = roast;
    }

    @Override
    public String toString() {
        return "{" +
            " origin='" + getOrigin() + "'" +
            ", roast='" + getRoast() + "'" +
            "}";
    }

}
