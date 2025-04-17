/**
 * Lab5 클래스
 * 온도 변환기, 산술 계산기, 통계 분석 기능을 포함하는 메인 프로그램
 */
import java.util.Random;

public class Lab5 {
    // 랜덤 숫자 생성을 위한 Random 객체
    private static Random random = new Random();

    /**
     * 정규 분포를 따르는 랜덤 숫자 배열 생성
     * @param length 생성할 배열의 길이
     * @return 정규 분포를 따르는 랜덤 숫자 배열
     */
    public static double[] assignArray(int length) {
        double[] arr = new double[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextGaussian(); // 정규 분포를 따르는 랜덤 숫자 생성
        }
        return arr;
    }

    /**
     * 프로그램의 메인 메소드
     * @param args 명령행 인자
     * @throws Exception 예외 발생 시
     */
    public static void main(String[] args) throws Exception {
        // 1. 온도 변환기 실행
        System.out.println("TemperatureConverter!");
        System.out.print("Please select 1. CELSIUS_TO_FAHRENHEIT, 2. FAHRENHEIT_TO_CELSIUS: ");
        int choice = UserInput.getIntegerBetween(1, 2); // 사용자로부터 1 또는 2 입력 받기
        TemperatureConverterType type = TemperatureConverterType.valueOf(choice); // 변환 타입 설정
        System.out.println("TemperatureConverterType=" + type);
        System.out.print("Please enter temperature:");
        float temperature = UserInput.getFloat(); // 온도 값 입력 받기
        TemperatureConverter converter = new TemperatureConverter(type, temperature); // 변환기 객체 생성
        System.out.println(converter); // 변환 결과 출력

        // 2. 산술 계산기 실행
        System.out.println("ArithmeticCalculator!");        
        System.out.print("Please enter the first number: ");
        int x = UserInput.getInteger(); // 첫 번째 숫자 입력
        System.out.print("Please enter the second number: ");
        int y = UserInput.getInteger(); // 두 번째 숫자 입력
        char op = UserInput.getUserInputOp(); // 연산자 입력
        ArithmeticCalculator calc = new ArithmeticCalculator(x, y, op); // 계산기 객체 생성
        System.out.println(calc); // 계산 결과 출력

        // 3. 미리 정의된 계산기 예제 실행
        ArithmeticCalculator[] calculators = {
            new ArithmeticCalculator(10, 20, '+'), // 덧셈 예제
            new ArithmeticCalculator(550, 50, '/'), // 나눗셈 예제
            new ArithmeticCalculator(50, 150, '*'), // 곱셈 예제
            new ArithmeticCalculator(255, 10, '-'), // 뺄셈 예제
            new ArithmeticCalculator(553, 30, '%')  // 나머지 연산 예제
        };
        // 각 계산기의 결과 출력
        for (var calculator : calculators) {
            System.out.println(calculator);
        }

        // 4. 통계 분석 실행
        double[] data = assignArray(1000); // 1000개의 랜덤 데이터 생성
        SimpleStatistics statistics = new SimpleStatistics(data); // 통계 분석 객체 생성
        statistics.descriptiveStatistics(); // 기술 통계(평균, 중앙값, 범위, 표준편차) 계산 및 출력
    }
}
