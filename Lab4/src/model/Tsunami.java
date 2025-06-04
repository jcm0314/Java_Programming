// LAB4, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명

package model;

public class Tsunami extends NaturalHazard { 
    private TsunamiEventValidity tsunamiEventValidity;
    private TsunamiCauseCode tsunamiCauseCode;
    private String country;
    private double maximumWaterHeight;
    private int numberOfRunup;


    public Tsunami(int year, int month, int day, 
                    TsunamiEventValidity tsunamiEventValidity, 
                    TsunamiCauseCode tsunamiCauseCode, String country, 
                    String location, double latitude, double longitude, 
                    double maximumWaterHeight, int numberOfRunup) {
        super(year, month, day, location, latitude, longitude);
        this.tsunamiEventValidity = tsunamiEventValidity;
        this.tsunamiCauseCode = tsunamiCauseCode;
        this.country = country;
        this.maximumWaterHeight = maximumWaterHeight;
        this.numberOfRunup = numberOfRunup;
    }




    public TsunamiEventValidity getTsunamiEventValidity() {
        return this.tsunamiEventValidity;
    }

    public void setTsunamiEventValidity(TsunamiEventValidity tsunamiEventValidity) {
        this.tsunamiEventValidity = tsunamiEventValidity;
    }

    public TsunamiCauseCode getTsunamiCauseCode() {
        return this.tsunamiCauseCode;
    }

    public void setTsunamiCauseCode(TsunamiCauseCode tsunamiCauseCode) {
        this.tsunamiCauseCode = tsunamiCauseCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMaximumWaterHeight() {
        return this.maximumWaterHeight;
    }

    public void setMaximumWaterHeight(double maximumWaterHeight) {
        this.maximumWaterHeight = maximumWaterHeight;
    }

    public int getNumberOfRunup() {
        return this.numberOfRunup;
    }

    public void setNumberOfRunup(int numberOfRunup) {
        this.numberOfRunup = numberOfRunup;
    }

    @Override
    public String toString() {
        return "{" +
            " tsunamiEventValidity='" + getTsunamiEventValidity() + "'" +
            ", tsunamiCauseCode='" + getTsunamiCauseCode() + "'" +
            ", country='" + getCountry() + "'" +
            ", maximumWaterHeight='" + getMaximumWaterHeight() + "'" +
            ", numberOfRunup='" + getNumberOfRunup() + "'" +
            "}";
    }

}
