
public class Chocolate { // Chocolate has ChocolateBrand and ChocolateType
    private ChocolateBrand brand;
    private ChocolateType type;

    public Chocolate(ChocolateBrand brand, ChocolateType type) {
        this.brand = brand;
        this.type = type;
    }

    public ChocolateBrand getBrand() {
        return this.brand;
    }

    public void setBrand(ChocolateBrand brand) {
        this.brand = brand;
    }

    public ChocolateType getType() {
        return this.type;
    }

    public void setType(ChocolateType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
            " brand='" + getBrand() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

}
