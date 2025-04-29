// 2025/04/24 컴퓨터공학과 32203919 장천명
public class BoundingBox {
    private Point min;  // 경계 상자의 최소 좌표 (왼쪽 아래)
    private Point max;  // 경계 상자의 최대 좌표 (오른쪽 위)
    
    /**
     * 기본 생성자
     */
    public BoundingBox() {
    }

    /**
     * 최소 좌표와 최대 좌표를 받아 BoundingBox를 생성
     */
    public BoundingBox(Point min, Point max) {
        this.min = min;
        this.max = max;
    }

    // getter setter

    /**
     * 최소 좌표를 반환
     * @return 최소 좌표 Point 객체
     */
    public Point getMin() {
        return this.min;
    }

    /**
     * 최소 좌표를 설정
     * @param min 설정할 최소 좌표
     */
    public void setMin(Point min) {
        this.min = min;
    }

    /**
     * 최대 좌표를 반환
     * @return 최대 좌표 Point 객체
     */
    public Point getMax() {
        return this.max;
    }

    /**
     * 최대 좌표를 설정
     * @param max 설정할 최대 좌표
     */
    public void setMax(Point max) {
        this.max = max;
    }


    // toString
    @Override
    public String toString() {
        return "{min='" + min + ", max='" + max + " }";
    }
}