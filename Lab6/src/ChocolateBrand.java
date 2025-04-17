
public class ChocolateBrand {
    private String name;
    private String country;

    public ChocolateBrand(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }

}
