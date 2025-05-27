// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package model;

/**
 * 지진 정보를 나타내는 클래스
 * NaturalHazard를 상속받아 지진 특유의 속성(깊이, 규모)을 추가
 */
public class Earthquake extends NaturalHazard {
    private int depth;
    private double magnitude;

    public Earthquake(int year, int month, int day, String location, 
                     double latitude, double longitude, int depth, double magnitude) {
        super(year, month, day, location, latitude, longitude);
        this.depth = depth;
        this.magnitude = magnitude;
    }

    // Getters
    public int getDepth() {
        return depth;
    }

    public double getMagnitude() {
        return magnitude;
    }

    // Setters
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public String toString() {
        return String.format("%s, Depth: %dkm, Magnitude: %.1f",
                super.toString(), depth, magnitude);
    }
} 