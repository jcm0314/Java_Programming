// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package model;

/**
 * 자연재해의 기본 추상 클래스
 * 모든 자연재해(지진, 화산 등)의 공통 속성을 정의
 */
public abstract class NaturalHazard {
    private int year;
    private int month;
    private int day;
    private String location;
    private double latitude;
    private double longitude;

    public NaturalHazard(int year, int month, int day, String location, double latitude, double longitude) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // Setters
    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("Date: %d-%02d-%02d, Location: %s, Coordinates: (%.3f, %.3f)",
                year, month, day, location, latitude, longitude);
    }
} 