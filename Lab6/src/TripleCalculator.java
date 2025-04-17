/**
 * 세 개의 값에 대한 다양한 연산을 수행하는 계산기 클래스
 */
public class TripleCalculator {
    // 계산할 세 개의 값을 저장하는 TripleValue 객체
    private TripleValue value;
    // 수행할 연산 유형을 저장하는 TripleOperator 열거형
    private TripleOperator op;

    /**
     * TripleCalculator 생성자
     * @param value 계산할 세 개의 값
     * @param op 수행할 연산 유형
     */
    public TripleCalculator(TripleValue value, TripleOperator op) {
        this.value = value;
        this.op = op;
    }

    /**
     * 현재 설정된 TripleValue 객체 반환
     * @return TripleValue 객체
     */
    public TripleValue getValue() {
        return this.value;
    }

    /**
     * 계산할 TripleValue 객체 설정
     * @param value 새로운 TripleValue 객체
     */
    public void setValue(TripleValue value) {
        this.value = value;
    }

    /**
     * 현재 설정된 연산 유형 반환
     * @return TripleOperator 열거형 값
     */
    public TripleOperator getOp() {
        return this.op;
    }

    /**
     * 수행할 연산 유형 설정
     * @param op 새로운 연산 유형
     */
    public void setOp(TripleOperator op) {
        this.op = op;
    }

    /**
     * 현재 설정된 값과 연산으로 계산 수행
     * @return 계산 결과값
     */
    public int calculate() {
        return calc(value.getX(), value.getY(), value.getZ(), op);
    }

    /**
     * 세 개의 정수와 연산 유형을 받아 계산을 수행하는 정적 메서드
     * @param x 첫 번째 정수
     * @param y 두 번째 정수
     * @param z 세 번째 정수
     * @param op 수행할 연산 유형
     * @return 계산 결과값
     * @throws AssertionError 알 수 없는 연산 유형이 주어진 경우
     */
    public static int calc(int x, int y, int z, TripleOperator op) {
        switch (op) {
            case MIN:       return Math.min(Math.min(x, y), z);
            case MAX:       return Math.max(Math.max(x, y), z);
            case MEDIAN:    return Math.max(Math.min(x,y), Math.min(Math.max(x,y),z));
            case SUM:       return x + y + z;
            case PRODUCT:   return x * y * z;
            default: throw new AssertionError("Unknown operation " + op);
        }
    }

    /**
     * 객체의 문자열 표현을 반환
     * @return "{ value='값', op='연산유형', result='결과값' }" 형식의 문자열
     */
    @Override
    public String toString() {
        return "{" +
            " value='" + getValue() + "'" +
            ", op='" + getOp() + "'" +
            ", result='" + calculate() + "'" +
            " }";
    }
}
