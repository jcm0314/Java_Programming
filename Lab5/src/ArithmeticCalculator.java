/**
 * 산술 계산을 수행하는 클래스
 * 두 정수에 대한 기본적인 산술 연산을 제공
 */
public class ArithmeticCalculator {
    private int x;        // 첫 번째 피연산자
    private int y;        // 두 번째 피연산자
    private char op;      // 연산자 (+, -, *, /, %)
    private int result;   // 계산 결과

    /**
     * 생성자
     * @param x 첫 번째 피연산자
     * @param y 두 번째 피연산자
     * @param op 연산자
     */
    public ArithmeticCalculator(int x, int y, char op) {
        this.x = x;
        this.y = y;
        this.op = op;
        this.result = calc(x, y, op);  // 계산 수행
    }

    /**
     * 첫 번째 피연산자 반환
     * @return 첫 번째 피연산자
     */
    public int getX() {
        return this.x;
    }

    /**
     * 첫 번째 피연산자 설정
     * @param x 설정할 값
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 두 번째 피연산자 반환
     * @return 두 번째 피연산자
     */
    public int getY() {
        return this.y;
    }

    /**
     * 두 번째 피연산자 설정
     * @param y 설정할 값
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 연산자 반환
     * @return 연산자
     */
    public char getOp() {
        return this.op;
    }

    /**
     * 연산자 설정
     * @param op 설정할 연산자
     */
    public void setOp(char op) {
        this.op = op;
    }

    /**
     * 객체의 문자열 표현 반환
     * @return 계산기 상태를 나타내는 문자열
     */
    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", op='" + getOp() + "'" +
            ", result='" + result + "'" +
            "}";
    }

    /**
     * 산술 연산 수행
     * @param x 첫 번째 피연산자
     * @param y 두 번째 피연산자
     * @param op 연산자
     * @return 계산 결과
     */
    private static int calc(int x, int y, char op) {
        return switch (op) {
            case '+' -> x + y;  // 덧셈
            case '-' -> x - y;  // 뺄셈
            case '*' -> x * y;  // 곱셈
            case '/' -> x / y;  // 나눗셈
            case '%' -> x % y;  // 나머지
            default -> 0;       // 잘못된 연산자
        };
    }
}
