
public class Roast {
    private int degree;

    public Roast(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "{" +
            " degree='" + getDegree() + "'" +
            "}";
    }

}
