
public class TripleValue {
    private int x;
    private int y;
    private int z;

    // constructor overloading (1)
    public TripleValue(int x, int y, int z) {
        set(x, y, z);
    }
    // constructor overloading (2)
    public TripleValue(TripleValue other) {
        this(other.getX(), other.getY(), other.getZ());
    }
    // constructor overloading (3)
    public TripleValue() {
        this(0, 0, 0);
    }

    public void set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", z='" + getZ() + "'" +
            "}";
    }


}
