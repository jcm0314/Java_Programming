/**
 * 간단한 통계 분석을 수행하는 클래스
 * 데이터의 평균, 중앙값, 범위 등을 계산
 */
import java.util.Arrays;

public class SimpleStatistics {
    private double[] data;  // 분석할 데이터 배열

    /**
     * 생성자
     * @param data 분석할 데이터 배열
     */
    public SimpleStatistics(double[] data) {
        this.data = data;
        Arrays.sort(this.data); // 중앙값과 최빈값 계산을 위해 데이터 정렬
    }

    /**
     * 평균 계산
     * @return 데이터의 산술 평균
     */
    public double mean() {
        double sum = 0.0;
        for (double d : data) {
            sum += d;
        }
        return sum/data.length;
    }

    /**
     * 중앙값 계산
     * @return 데이터의 중앙값
     */
    public double median() {
        int n = data.length;
        if (n % 2 == 1) { // 데이터 개수가 홀수인 경우
            return data[n/2];
        } else { // 데이터 개수가 짝수인 경우
            return (data[n/2 -1] + data[n/2])/2.0;
        }
    }

    /**
     * 범위 계산
     * @return 데이터의 범위 (최대값 - 최소값)
     */
    public double range() {
        return data[data.length - 1] - data[0];
    }

    /**
     * 객체의 문자열 표현 반환
     * @return 데이터 배열을 문자열로 변환한 결과
     */
    @Override
    public String toString() {
        return "{" +
            " data='" + Arrays.toString(this.data) + "'" +
            "}";
    }

    /**
     * 기술 통계 정보 출력
     * 데이터, 평균, 중앙값, 범위를 출력
     */
    public void descriptiveStatistics() {
        System.out.println(Arrays.toString(this.data));  // 데이터 출력
        System.out.println("mean=" + mean());           // 평균 출력
        System.out.println("median=" + median());       // 중앙값 출력
        System.out.println("range=" + range());         // 범위 출력
    }
}
