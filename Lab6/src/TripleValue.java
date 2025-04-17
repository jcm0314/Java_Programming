/**
 * 세 개의 정수 값을 저장하고 관리하는 클래스
 * x, y, z 세 개의 정수 값을 캡슐화하여 관리
 */
public class TripleValue {
    // 세 개의 정수 값을 저장하는 private 필드
    private int x;
    private int y;
    private int z;

    /**
     * 세 개의 정수 값을 매개변수로 받는 생성자
     * @param x 첫 번째 정수 값
     * @param y 두 번째 정수 값
     * @param z 세 번째 정수 값
     */
    public TripleValue(int x, int y, int z) {
        set(x, y, z);
    }

    /**
     * 다른 TripleValue 객체를 복사하는 생성자
     * @param other 복사할 TripleValue 객체
     */
    public TripleValue(TripleValue other) {
        this(other.getX(), other.getY(), other.getZ());
    }

    /**
     * 기본 생성자 - 모든 값을 0으로 초기화
     */
    public TripleValue() {
        this(0, 0, 0);
    }

    /**
     * 세 개의 정수 값을 한 번에 설정하는 메서드
     * @param x 첫 번째 정수 값
     * @param y 두 번째 정수 값
     * @param z 세 번째 정수 값
     */
    public void set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * x 값 반환
     * @return x 값
     */
    public int getX() {
        return this.x;
    }

    /**
     * x 값 설정
     * @param x 설정할 x 값
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * y 값 반환
     * @return y 값
     */
    public int getY() {
        return this.y;
    }

    /**
     * y 값 설정
     * @param y 설정할 y 값
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * z 값 반환
     * @return z 값
     */
    public int getZ() {
        return this.z;
    }

    /**
     * z 값 설정
     * @param z 설정할 z 값
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * 객체의 문자열 표현을 반환
     * @return "{ x='값', y='값', z='값' }" 형식의 문자열
     */
    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", z='" + getZ() + "'" +
            "}";
    }
}
