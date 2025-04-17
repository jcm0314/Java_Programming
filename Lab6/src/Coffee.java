/**
 * 커피를 나타내는 클래스
 * 원산지(Origin)와 로스팅 정도(Roast)를 포함
 */
public class Coffee { // Coffee has Origin and Roast
    // 커피의 원산지를 저장하는 private 필드
    private Origin origin;
    // 커피의 로스팅 정도를 저장하는 private 필드
    private Roast roast;

    /**
     * Coffee 생성자
     * @param origin 커피의 원산지
     * @param roast 커피의 로스팅 정도
     */
    public Coffee(Origin origin, Roast roast) {
        this.origin = origin;
        this.roast = roast;
    }

    /**
     * 현재 설정된 원산지 반환
     * @return Origin 객체
     */
    public Origin getOrigin() {
        return this.origin;
    }

    /**
     * 원산지 설정
     * @param origin 새로운 Origin 객체
     */
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    /**
     * 현재 설정된 로스팅 정도 반환
     * @return Roast 객체
     */
    public Roast getRoast() {
        return this.roast;
    }

    /**
     * 로스팅 정도 설정
     * @param roast 새로운 Roast 객체
     */
    public void setRoast(Roast roast) {
        this.roast = roast;
    }

    /**
     * 객체의 문자열 표현을 반환
     * @return "{ origin='원산지', roast='로스팅정도' }" 형식의 문자열
     */
    @Override
    public String toString() {
        return "{" +
            " origin='" + getOrigin() + "'" +
            ", roast='" + getRoast() + "'" +
            "}";
    }

}
