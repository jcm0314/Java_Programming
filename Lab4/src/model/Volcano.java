// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package model;

/**
 * 화산 정보를 나타내는 클래스
 * NaturalHazard를 상속받아 화산 특유의 속성을 추가
 * 이름, 국가, 고도, 유형, VEI(화산 폭발 지수) 정보 포함
 */
public class Volcano extends NaturalHazard {
    private String name;
    private String country;
    private int elevation;
    private String type;
    private int vei;  // Volcanic Explosive Index

    public Volcano(int year, int month, int day, String name, String location, String country,
                  double latitude, double longitude, int elevation, String type, int vei) {
        super(year, month, day, location, latitude, longitude);
        this.name = name;
        this.country = country;
        this.elevation = elevation;
        this.type = type;
        this.vei = vei;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getElevation() {
        return elevation;
    }

    public String getType() {
        return type;
    }

    public int getVei() {
        return vei;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVei(int vei) {
        this.vei = vei;
    }

    @Override
    public String toString() {
        return String.format("%s, Name: %s, Country: %s, Elevation: %dm, Type: %s, VEI: %d",
                super.toString(), name, country, elevation, type, vei);
    }
} 