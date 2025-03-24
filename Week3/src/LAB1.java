import java.util.Scanner;
import java.util.Random; // 랜덤 정수 생서


public class LAB1 {
    enum Color { // 5번 문제를 위한 enum
        Red(255, 0, 0), 
        Green(0, 255, 0), 
        Blue(0, 0, 255), 
        Yellow(255, 255, 0), 
        White(255, 255, 255), 
        Black(0, 0, 0);

        private final int r, g, b; // r g b 저장할 변수(final로 고정) 선언

        Color(int r, int g, int b) { // enum 선언으로 각각의 r g b 값으 설정
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
    public static void main(String[] args) throws Exception{ // main 함수




        // 1
        System.out.println("첫번째 문제");

        int a = 3; // 첫 번째 분수 분자
        int b = 7; // 첫 번째 분수 분모
        int c = 15; // 두 번째 분수 분자
        int d = 2; // 두 번째 분수 분모 

        int child = a * c;
		int parent = b * d;
        
        double result = (double) child/parent; // 소수점으로 출력해야 하기 때문에 double로 바꿈 
        System.out.printf("결과: %.9f\n", result); // 포매팅하여 아옵번째까지 소수점 출력
		



        // 2
        System.out.println("\n두번째 문제");

		Random random = new Random(); // 랜덤 정수 객체 생서
        int ran = random.nextInt(101); // 랜덤 정수를 0~100의 값으로 설정
        if (ran % 3 == 0) {
            System.out.println("The number " + ran + " is a multiple of 3"); // 3일 때, 출력갑
        }
        else {
            System.out.println("The number " + ran + " is not a multiple of 3"); // 3이 아닐 때, 출력 갑
        }




        // 3
        System.out.println("\n세번째 문제");

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




        // 4
        System.out.println("\n네번째 문제");

        Scanner scanner = new Scanner(System.in); // 사용자 입력값 받는 객체 생성
        int input_value; // 사용자 입력값을 받는 정수 변수 선언
        
        do { // do-while 문을 통해서 범위값 내에 받도록 설정
            System.out.println("0부터 20까지 숫자를 입력하시오.");    
            input_value = scanner.nextInt(); // 사용자 입력값 받기
        } while ((input_value > 20) || (input_value < 0)); // 20 초과 또는 0미만일 때, 사용자 입력값 다시 입력 받기
		
        for (int i = 1; i <= 10; i++) { // 1부터 10까지 
            System.out.println(input_value + " x " + i + " = " + input_value*i); // 구구단 출력
        }
        



        // 5
        System.out.println("\n다섯번째 문제");

        scanner.nextLine(); //
        System.out.print("색상(Red, Green, Blue, Yellow, White, Black) 중 하나를 입력하시오: ");
        String userInput = scanner.nextLine(); // 앞의 nextInt 때문에 개행 문자 제거

        Color[] colors = Color.values(); // Color enum 값을 배열로 저장
        Color randomColor = colors[random.nextInt(colors.length)]; // random 객체를 통해 색상 중 무작위로 선택

        System.out.println("사용자 입력 색상: " + userInput); // 사용자 입력 값 
        System.out.println("랜덤 선택 색상: " + randomColor); // 랜덤 값

        if (userInput.equalsIgnoreCase(randomColor.name())) { // 사용자 입력 값이랑 랜덤 값이 같으면 
            System.out.println("The user selected const color and the random enum color is the same.");
        } else { // 사용자 입력 값이랑 랜덤 값이 다르면
            System.out.println("The user selected const color and the random enum color is different");
        
        scanner.close(); // 스캐너 자원 정리


        // 6
        System.out.println("\n여섯번째 문제, your code"); // case 문에 익숙하지 않아서 case문을 your code로 했습니다.
	
        for (int month = 1; month <= 12; month++) { // 1월부터 12월까지
            int days = 31;  // int days을 31로 선언

            switch(month) {
                case 2: // 2월
                    days = 28;
                    break; // case 문은 break를 꼭해줘야함. 만약 여기에 break 가 없으면 밑의 코드도 실행되서 30이됨.
                case 4: case 6: case 9: case 11: // 30일로 끝나는 달
                    days = 30;
                    break;
                default: // 31로 끝나는 달
                    days = 31;
            }

            System.out.println(month + "month " + days + "days");
        } 
    }
}
}
