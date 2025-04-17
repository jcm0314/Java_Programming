/**
 * 커피 원두의 로스팅 정도를 나타내는 클래스
 * 로스팅 정도는 0에서 10 사이의 정수로 표현
 */
public class Roast {
    // 로스팅 정도를 저장하는 private 필드 (0-10)
    private int degree;

    /**
     * Roast 생성자
     * @param degree 로스팅 정도 (0-10)
     */
    public Roast(int degree) {
        this.degree = degree;
    }

    /**
     * 현재 로스팅 정도 반환
     * @return 로스팅 정도 (0-10)
     */
    public int getDegree() {
        return this.degree;
    }

    /**
     * 로스팅 정도 설정
     * @param degree 새로운 로스팅 정도 (0-10)
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }

    /**
     * 객체의 문자열 표현을 반환
     * @return "{ degree='값' }" 형식의 문자열
     */
    @Override
    public String toString() {
        return "{" +
            " degree='" + getDegree() + "'" +
            "}";
    }
}
