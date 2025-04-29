// 2025/04/24 컴퓨터공학과 32203919 장천명

import java.util.Arrays;

/**
 * Figure 클래스는 2D 공간에서의 사각형 도형을 나타내는 클래스
 * 네 개의 점으로 구성되며, 변의 길이, 각도, 도형의 종류 등을 계산
 */
public class Figure {
    private Point[] points;  // 도형을 구성하는 네 개의 점
    private double[] sides;  // 네 변의 길이
    private double[] angles; // 네 각의 크기

    /**
     * 기본 생성자
     */
    public Figure() {
    }

    /**
     * 네 개의 점으로 도형을 생성

     */
    public Figure(Point[] points) {
        this.points = Arrays.copyOf(points, points.length);
        sides = new double[4];
        angles = new double[4];
        for (int i = 0; i < 4; i++) {
            sides[i] = Point.getDistance(points[i], points[(i + 1) % 4]);
            angles[i] = Point.getAngle(points[(i + 3) % 4], points[i], points[(i + 1) % 4]);
        }
    }

    // getter setter

    public Point[] getPoints() {
        return this.points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public double[] getSides() {
        return this.sides;
    }

    public void setSides(double[] sides) {
        this.sides = sides;
    }

    public double[] getAngles() {
        return this.angles;
    }

    public void setAngles(double[] angles) {
        this.angles = angles;
    }

    /**
     * (5) 네 변이 모두 같은지
     * 모든 변의 길이가 같은지 확인
     * @return 모든 변의 길이가 같으면 true, 아니면 false
     */
    public boolean allEqualSides() {
        return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
    }

    /**
     * (5) 대변이 같은지
     * 마주보는 변의 길이가 같은지 확인
     * @return 마주보는 변의 길이가 같으면 true, 아니면 false
     */
    public boolean oppositeEqualSides() {
        return sides[0] == sides[2] && sides[1] == sides[3];
    }

    /**
     * (6) 네 각이 모두 직각
     * 모든 각이 직각인지 확인
     * @return 모든 각이 직각이면 true, 아니면 false
     */
    public boolean allRightAngles() {
        return Math.abs(angles[0] - 90.0) < 1e-6 &&
               Math.abs(angles[1] - 90.0) < 1e-6 &&
               Math.abs(angles[2] - 90.0) < 1e-6 &&
               Math.abs(angles[3] - 90.0) < 1e-6;
    }

    /**
     * (6) 대각이 같은지
     * 마주보는 각의 크기가 같은지 확인
     * @return 마주보는 각의 크기가 같으면 true, 아니면 false
     */
    public boolean oppositeEqualAngles() {
        return Math.abs(angles[0] - angles[2]) < 1e-6 && Math.abs(angles[1] - angles[3]) < 1e-6;
    }

    /**
     * 두 쌍의 대변이 모두 평행한지 확인
     * @return 두 쌍의 대변이 모두 평행하면 true, 아니면 false
     */
    public boolean bothPairsParallel() {
        return Point.areParallel(points[0], points[1], points[2], points[3]) &&
               Point.areParallel(points[1], points[2], points[3], points[0]);
    }

    /**
     * 한 쌍의 대변이 평행한지 확인(사다리꼴에서 사용용)
     * @return 한 쌍의 대변이 평행하면 true, 아니면 false
     */
    public boolean onePairParallel() {
        return Point.areParallel(points[0], points[1], points[2], points[3]) ||
               Point.areParallel(points[1], points[2], points[3], points[0]);
    }

    /**
     * (7)
     * 도형의 종류를 판별
     * @return 도형의 종류 (FigureType)
     */
    public FigureType getFigureType() {
        if (allRightAngles() && allEqualSides()) {
            return FigureType.SQUARE;
        } else if (allRightAngles() && oppositeEqualSides()) {
            return FigureType.RECTANGLE;
        } else if (allEqualSides() && oppositeEqualAngles()) {
            return FigureType.RHOMBUS;
        } else if (bothPairsParallel() && oppositeEqualAngles() && oppositeEqualSides()) {
            return FigureType.PARALLELOGRAM;
        } else if (onePairParallel()) {
            return FigureType.TRAPEZOID;
        } else {
            return null;
        }
    }

    /**
     * (8)
     * 도형을 감싸는 최소 경계 상자를 반환
     * @return BoundingBox 객체
     */
    public BoundingBox getBoundingBox() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (Point p : points) {
            //if (p.getX() < minX) minX = p.getX(); 
            //if (p.getX() > maxX) maxX = p.getX();  
            //if (p.getY() < minY) minY = p.getY();
            //if (p.getY() > maxY) maxY = p.getY();
            minX = Math.min(p.getX(), minX);
            minY = Math.min(p.getY(), minY);
            maxX = Math.max(p.getX(), maxX);
            maxY = Math.max(p.getY(), maxY);
        }
        return new BoundingBox(new Point(minX, minY), new Point(maxX, maxY));
    }

    /**
     * (9)
     * 도형의 둘레를 계산
     * @return 둘레의 길이
     */
    public double getPerimeter() {
        return sides[0] + sides[1] + sides[2] + sides[3];
    }

    // (10) 영역
    public double getArea(){
        switch(this.getFigureType()){
        case FigureType.SQUARE :
            return sides[0] * sides[0]; // 밑변 * 밑변

        case FigureType.RECTANGLE :
            return sides[0] * sides[1]; // 밑변 * 높이

        case FigureType.RHOMBUS : // horizontalDiagonal * verticalDiagonal / 2.0
            return Point.getDistance(points[0], points[2]) *
                    Point.getDistance(points[1], points[3]) / 2.0;
        
        case FigureType.PARALLELOGRAM: // 밑변 * 높이
            return sides[0] * (points[3].getY() - points[0].getY());
        
        case FigureType.TRAPEZOID : // (윗변 + 밑변) * 높이 / 2.0
            return (sides[0] + sides[2]) * 
            (points[3].getY() - points[0].getY()) / 2.0 ;   

        default :
            return 0.0; 
        }
    }


    @Override
    public String toString() {
        return "{\n" +
               " points='" + Arrays.toString(getPoints()) + "\n" +
               " sides=" + Arrays.toString(getSides()) + "\n" +
               " angles=" + Arrays.toString(getAngles()) + "\n" +
               " type=" + getFigureType() + "\n" +
               " Bounding Box=" + getBoundingBox() + "\n" +
               " Perimeter=" + getPerimeter() + "\n" +
               " Area=" + getArea() + "\n" +
               "}";
    }
}
