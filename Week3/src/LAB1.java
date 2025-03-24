import java.util.Scanner;
import java.util.Random; // 랜덤 정수 생서

public class LAB1 {
    public static void main(String[] args) throws Exception {
        System.out.println("첫번째 문제");
        int a = 3; // 첫 번째 분수 분자
        int b = 7; // 첫 번째 분수 분모
        int c = 15; // 두 번째 분수 분자
        int d = 2; // 두 번째 분수 분모 

        int child = a * c;
		int parent = b * d;
        
        double result = (double) child/parent; // 소수점으로 출력해야 하기 때문에 double로 바꿈 
        System.out.printf("결과: %.9f\n", result); // 포매팅하여 아옵번째까지 소수점 출력
		


        System.out.println("두번째 문제");
		Random random = new Random(); // 랜덤 정수 객체 생서
        int ran = random.nextInt(101); // 랜덤 정수를 0~100의 값으로 설정
        if (ran % 3 == 0) {
            System.out.println("The number " + ran + " is a multiple of 3"); // 3일 때, 출력갑
        }
        else {
            System.out.println("The number " + ran + " is not a multiple of 3"); // 3이 아닐 때, 출력 갑
        }
        System.out.println("세번째 문제");
        int answer3; // answer3 선언
        int base = random.nextInt(10) + 1; // 1부터 10까지 생성
        int exponent = random.nextInt(6) + 1; // 1부터 6까지 생성
        System.out.println("base = " + base + ", exponent = " + exponent); // base, exponent 값 출력
        if (Math.pow(base, exponent) % 2 == 0) { // 짝수일 때
            double half = Math.pow(base, exponent/2); // base^(exponent/2) 값 
			answer3 = (int) Math.pow(half,2); // (base^(exponent/2))^2 값
            System.out.println(answer3); // 결과값 출력
        } 
        else { // 홀수일 떄
            answer3 = (int) (base * Math.pow(base, exponent - 1)); //base * base^(eexponent-1) 값
            System.out.println(answer3); // 결과값 출력
        }
        System.out.println("네번째 문제");
        Scanner scanner = new Scanner(System.in); // 입력값 받는 객체 생서
        int input_value;
        do {
            System.out.println("0부터 20까지 숫자를 입력하시오.");    
            input_value = scanner.nextInt();
        } while ((input_value > 20) || (input_value < 0));
		for (int i = 1; i <= 10; i++) {
            System.out.println(input_value + " x " + i + " = " + input_value*i);
        }
        
        System.out.println("네번째 문제");


    }
    
}
