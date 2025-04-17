import java.util.Random;

/**
 * Lab6 클래스 - 다양한 객체 생성과 사용을 테스트하는 메인 클래스
 */
public class Lab6 {
    /**
     * 프로그램의 진입점
     * TripleValue, TripleCalculator, Coffee, Chocolate 클래스의 사용 예시를 보여줌
     * @param args 명령행 인수 (사용되지 않음)
     * @throws Exception 예외 발생 시
     */
    public static void main(String[] args) throws Exception {
        // TripleValue 객체 생성 및 사용 예시
        System.out.println("(1) value~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // (1) 세 개의 정수로 TripleValue 객체 생성
        TripleValue value1 = new TripleValue(1, 2, 3);
        System.out.println("value1=" + value1);
        // (2) 다른 TripleValue 객체를 복사하여 생성
        TripleValue value2 = new TripleValue(value1);
        System.out.println("value2=" + value2); 
        // (3) 기본 생성자로 TripleValue 객체 생성 (모든 값이 0)
        TripleValue value3 = new TripleValue();
        System.out.println("value3=" + value3);
        // (4) 참조 복사
        TripleValue value4 = value1; 
        System.out.println("value4=" + value4);
        // value4의 값을 변경하면 value1도 변경됨 (같은 객체를 참조)
        value4.set(-1,-2,-3);
        System.out.println("value1=" + value1);
        System.out.println("value2=" + value2);
        System.out.println("value3=" + value3);
        System.out.println("value4=" + value4);

        // TripleCalculator 사용 예시
        Random rand = new Random();
        // 모든 TripleOperator에 대해 계산 수행
        for (TripleOperator op : TripleOperator.values()) {
            // 랜덤한 세 개의 정수로 TripleValue 생성
            TripleValue value = new TripleValue(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));  
            TripleCalculator calc = new TripleCalculator(value, op);
            System.out.println("calc=" + calc);
        }

        // Coffee 객체 생성 및 사용 예시
        Coffee coffee = new Coffee(new Origin("Costa Rica"), new Roast(2));
        System.out.println(coffee);
        coffee = new Coffee(new Origin("Brazil"), new Roast(3));
        System.out.println(coffee);
        // Coffee 객체 배열 생성 및 출력
        Coffee[] coffees = {
            new Coffee(new Origin("Costa Rica"), new Roast(2)),
            new Coffee(new Origin("Brazil"), new Roast(3)),
            new Coffee(new Origin("Ethiopia"), new Roast(1))
        };
        for (var c : coffees) {
            System.out.println(c);
        }

        // Chocolate 객체 생성 및 사용 예시
        Chocolate ghana = new Chocolate(new ChocolateBrand("Ghana", "South Korea"), ChocolateType.MILK_CHOCOLATE);
        System.out.println(ghana);

        // Chocolate 객체 배열 생성 및 출력
        Chocolate[] chocolates = new Chocolate[5];
        chocolates[0] = new Chocolate(new ChocolateBrand("Lindt", "Swiss"), ChocolateType.MILK_CHOCOLATE);
        chocolates[1] = new Chocolate(new ChocolateBrand("Godiva", "Belgium"), ChocolateType.DARK_CHOCOLATE);
        chocolates[2] = new Chocolate(new ChocolateBrand("Ghirardelli", "USA"), ChocolateType.DARK_CHOCOLATE);
        chocolates[3] = new Chocolate(new ChocolateBrand("Ferrero Rocher", "Italy"), ChocolateType.NUTELLA_CHOCOLATE);
        chocolates[4] = new Chocolate(new ChocolateBrand("Royce", "Japan"), ChocolateType.PAVE_CHOCOLATE);
        for (Chocolate chocolate: chocolates) {
            System.out.println(chocolate);
        }
    }
}
