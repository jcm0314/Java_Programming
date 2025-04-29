// 2025/04/24 컴퓨터공학과 32203919 장천명

/**
 * x, y 좌표를 가지며, 점들 간의 거리, 각도, 평행 여부 등을 계산하는 유틸리티 메소드를 제공
 */
public class Point {
    private int x;  // x 좌표 instance member field
    private int y;  // y 좌표 instance member field

    /**
     * 기본 생성자 - (0,0) 좌표에 점을 생성합니다.
     */
    public Point() {
        this(0, 0);
    }

    /**
     * x, y 좌표를 지정하여 점을 생성
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // getter , setter
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

    // toString override
    @Override
    public String toString() {
        return "{x=" + x + " y=" + y + "}";
    }

    /**
     * 두 점 사이의 유클리드 거리를 계산
     * @return 두 점 사이의 거리
     */
    public static double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    /**
     * 세 점으로 이루어진 각을 계산
     * @return 각도 (도 단위)
     */
    public static double getAngle(Point a, Point b, Point c) {
        double dot = ((b.x - a.x) * (c.x - b.x)) + ((b.y - a.y) * (c.y - b.y));
        double magAB = getDistance(a, b);
        double magBC = getDistance(b, c);
        return Math.toDegrees(Math.acos(dot / (magAB * magBC)));
    }

    /**
     * 두 선분이 평행한지 확인
     * @return 두 선분이 평행하면 true, 아니면 false
     */
    public static boolean areParallel(Point a, Point b, Point c, Point d) {
        double slopeAB = (b.y - a.y) / (double)(b.x - a.x);
        double slopeCD = (d.y - c.y) / (double)(d.x - c.x);
        return Math.abs(slopeAB - slopeCD) < 1e-6;  // 기울기가 같으면 평행
    }
}
