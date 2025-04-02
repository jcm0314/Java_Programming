// LAB2, 자바프로그래밍, 2분반, 2025.04.02, 32203919, 장천명

import java.util.*;

public class LAB2 {

    // 문제 1
    public static void fraction(double a, double b, double c, double d) { // fraction 메서드드 구현
        double add = (a * d + b * c) / (b * d); // 실수형 이므로 double로
        double sub = (a * d - b * c) / (b * d);
        double mul = (a * c) / (b * d);
        double div = (a * d) / (b * c);

        System.out.printf("Fraction Addition: %.1f/%.1f + %.1f/%.1f = %.1f/%.1f\n", a, b, c, d, (a*d + b*c), (b*d)); // 소수 첫번째 자리까지지
        System.out.printf("Fraction Subtraction: %.1f/%.1f - %.1f/%.1f = %.1f/%.1f\n", a, b, c, d, (a*d - b*c), (b*d));
        System.out.printf("Fraction Multiplication: %.1f/%.1f * %.1f/%.1f = %.1f/%.1f\n", a, b, c, d, (a*c), (b*d));
        System.out.printf("Fraction Division: %.1f/%.1f / %.1f/%.1f = %.1f/%.1f\n", a, b, c, d, (a*d), (b*c));
    }

    // 문제 2
    public static int getRandomIntBetween(int a, int b) { // getRandomIntBetween 메서드 구현
        return new Random().nextInt(b - a + 1) + a;
    }

    public static boolean isEven(int n) { // 짝수인지 판단하는 isEven 메서드 구현
        return n % 2 == 0;
    }

    public static boolean isMultiplesOfThree(int n) { // 3의 배수인지 판단하는 isMultipleOfThree 메서드 구현
        return n % 3 == 0;
    }

    public static boolean isPrime(int n) { // 소수 인지 판별하는 isPrime 메서드 구현
        if (n <= 1) return false; // 1이하는 false 반환환
        for (int i = 2; i*i <= n; i++) { // n이 소수인지 확인하고 아니면 false 반환
            if (n % i == 0) return false;
        }
        return true; // i로 안 나눠질 때 true 반환
    }

    public static void checkNumber(int num) { // checkNumber 메서드 구현
        System.out.println(num + (isEven(num) ? " is even number." : " is odd number.")); // 짝수인지 판별
        System.out.println(num + (isMultiplesOfThree(num) ? " is a multiple of 3." : " is NOT a multiple of 3.")); // 3의 배수인지 판별
        System.out.println(num + (isPrime(num) ? " is a prime number." : " is NOT a prime number.")); // 소수인지 판별별
    }

    // 문제 3
    public static long powerCalculation(long base, long exponent) { // powerCalculation 메서드 구현
        if (exponent == 0) return 1; // 기저 조건 설정
        long half = powerCalculation(base, exponent / 2); // 절반 지수로 재귀
        return exponent % 2 == 0 ? half * half : base * half * half; // 홀짝 구분
    }

    // 문제 4
    public static int getUserInputBetween(String msg, int min, int max, Scanner scanner) { // getUserInputBetween 메서드 구현, 매개변수는 multiplicationTable에서 받을 예정정
        int value; 
        do {
            System.out.print(msg); // msg 문자열 출력
            value = scanner.nextInt(); // 입력값 받음
        } while (value < min || value > max); // min보다 작거나 max보다 크면 반복복
        return value;
    }

    public static void multiplicationTable() { // miltiplicationTable 메서드 구현
        Scanner scanner = new Scanner(System.in); // 사용자 입력값을 받을 객체 생성
        int value = getUserInputBetween("Please enter a number between [2-20]: ", 2, 20, scanner); // getUserInputBetween 메서드 호출
        System.out.println("Multiplication Table for " + value + ":"); 
        for (int i = 1; i <= 9; i++) { // 구구단 출력
            System.out.println(value + " x " + i + " = " + (value * i));
        }
    }

    // 문제5 
    enum Color { // 열거형 Color 정의
        RED(255,0,0), GREEN(0,255,0), BLUE(0,0,255),
        YELLOW(255,255,0), WHITE(255,255,255), BLACK(0,0,0);

        private final int r, g, b; // rgb값 고정정
        Color(int r, int g, int b) { // 생성자에서 rgb 값 지정
            this.r = r; this.g = g; this.b = b;
        }

        // 입력된 RGB가 enum의 색상과 일치하는지 확인
        public static Color getColor(int r, int g, int b) { // getColor 메서드 구현, 반환타입은 Color임 
            for (Color c : values()) { // Color의 모든 열거 상수를 배열로 반환 ex)[Red, Green, Blue], 각 c에 대해 순차적으로 접근하면서 비교
                if (c.r == r && c.g == g && c.b == b) return c; // c 값의 rgb 값이 enum 상수의 rgb 값과 동일하다면 열거형 값 반환
            }
            return null; // 일치하는 색상 없으면 null 값 반환
        }
    }

    // 문제 6
    public static double decimalValue(double num, int decimalPlace) { // decimalValue 메서드 구현
        double floor = Math.floor(num); // 소수점 아래를 버린 정수
        double fraction = num - floor; // 소수 부분만, 1번의 fraction과 충돌될 수 있지 않을까 싶은데 서로 다른 영역에 존재하므로 상관 X
        double rounded = Math.round(fraction * Math.pow(10, decimalPlace)) / Math.pow(10, decimalPlace); // 소수 부분 반올림
        return rounded; // 소수 부분 decimalPlace자리 반올림 한 것것 반환
    }

    // 문제 7
    public static String emphasizeVowels(String str) { // emphasizeVowels 메서드 구현
        String vowels = "aeiouAEIOU"; // 모음 정의
        StringBuilder sb = new StringBuilder(); // 문자열을 빠르게 연결하거나 수정시키는 문자열 조립 도구 객체 생성
        for (char c : str.toCharArray()) { // c에 문자열을 문자 배열로 변환, 각 문자 하나를 c에 할당하여 순회
            sb.append(vowels.indexOf(c) >= 0 ? Character.toUpperCase(c) : Character.toLowerCase(c)); // 삼항 연산자로, c가 vowels에 포함되어 있다면 대문자로, 아니라면 소문자로 변환
        }
        return sb.toString(); // 모든 변환을 마친 후, StringBuilder를 통하여 문자열로 변환
    }

    // 문제 8
    public static int convertToSeconds(int h, int m, int s) { // 초로 변환하는 convertTSEconds 메서드 구현
        int total = h * 3600 + m * 60 + s; // 시간 단위 * 3600 + 분 단위 * 60 + 초초
        System.out.printf("%d hours, %d minutes, %d seconds converted to total seconds is: %d sec\n", h, m, s, total);
        return total; // 전체 초값 반환환
    }

    public static void convertFromSeconds(int total) { // 초가 시 분 초로 변환하는 convertFromSeconds 메서드 구현현
        int hours = total / 3600; // 시간은 3600으로 나눈 몫
        int minutes = (total % 3600) / 60; // 분은 3600으로 나눈 후 남은 값들로 60으로 나눈 몫
        int seconds = total % 60; // 60으으로 나눈 나머지 값
        System.out.printf("%d seconds is: %d hours, %d minutes, %d seconds\n", total, hours, minutes, seconds);
    }

    // 문제 9
    public static String[][] createSeatingChart(int rows, int cols) { // 좌석 만들기 createSeatingChart 메서드 구현현
        String[][] chart = new String[rows][cols]; // 2차원 배열로 행 * 열 의 크기를 가지는 chart 객체 생성
        for (int r = 0; r < rows; r++) // 행
            for (int c = 0; c < cols; c++) // 열
                chart[r][c] = "R" + (r + 1) + "C" + (c + 1); // r,c 값에 r+1,c+1 좌석 지정 ex) R1C1
        return chart; // 좌석 2차원 배열로로 만든 값 반환
    }

    public static void printSeatingChart(String[][] chart) { // 좌석 출력하는 printSeatingChar 메서드 구현
        for (String[] row : chart) { // chart의 행 순회
            for (String seat : row) { // chart의 열 순회
                System.out.print(seat + "\t"); // 지금 순회하는 seat 출력
            }
            System.out.println(); // 열 끝나면 행으로 넘어가도록
        }
    }

    public static void seatingChart() { // seatingchar 메서드 구현
        Scanner scanner = new Scanner(System.in); // 사용자 값 입력을 받기 위한 객체 생성성
        while (true) { // 무한 반복문 실행
            System.out.print("Please enter row column number [e.g. 4,5]: "); 
            String input = scanner.nextLine(); // 사용자 입력 값 받기기
            if (input.equalsIgnoreCase("q")) break; // q를 입력하면 break하면서 무한 반복문 종료
            try { // 프로그램 멈추면 안되니깐 문제 생겨도 안내할 수 있게 try써주기
                String[] tokens = input.split(","); // split을 통해 ,을 기준으로 문자열 나누기
                int rows = Integer.parseInt(tokens[0].trim()); // 나눠진 첫번째 문자열은 rows로
                int cols = Integer.parseInt(tokens[1].trim()); // 나눠진 두번째 문자열은 cols로
                printSeatingChart(createSeatingChart(rows, cols));
            } catch (Exception e) { // 예외 처리
                System.out.println("입력이 잘못되었습니다. 예: 4,5");
            }
            System.out.print("Press 'q' to exit the process or any-key to continue: ");
            if (scanner.nextLine().equalsIgnoreCase("q")) break; // q 입력하면 종료
        }
    }

    // 메인 함수: 문제 실행 예시
    public static void main(String[] args) {
        System.out.println("\n1번 문제");
        fraction(3.0, 7.0, 2.0, 15.0);

        System.out.println("\n2번 문제");
        int num = getRandomIntBetween(1, 100);
        checkNumber(num);

        System.out.println("\n3번 문제");
        long base = getRandomIntBetween(1,10);
        long exp = getRandomIntBetween(1,6);
        long result = powerCalculation(base, exp);
        System.out.println("[Power Calculation using Fast Exponentiation] " + base + " ^ " + exp + " = " + result);

        System.out.println("\n4번 문제");
        multiplicationTable();

        System.out.println("\n5번 문제");
        System.out.println("getColor(255,0,0) --> " + Color.getColor(255,0,0)); // Red
        System.out.println("getColor(0,255,0) --> " + Color.getColor(0,255,0)); // Green
        System.out.println("getColor(0,0,255) --> " + Color.getColor(0,0,255)); // Blue
        System.out.println("getColor(255,255,0) --> " + Color.getColor(255,255,0)); // Yellow
        System.out.println("getColor(255,255,255) --> " + Color.getColor(255,255,255)); // White
        System.out.println("getColor(0,0,0) --> " + Color.getColor(0,0,0)); // Black
        System.out.println("getColor(255,0,255) --> " + Color.getColor(255,0,255)); // null 값

        System.out.println("\n6번 문제");
        System.out.println("3.14159265 Decimal5 value: " + decimalValue(3.14159265, 5));
        System.out.println("5.983 Decimal2 value: " + decimalValue(5.983, 2));

        System.out.println("\n7번 문제");
        System.out.println(emphasizeVowels("aStringThatLooksLikeThis"));
        System.out.println(emphasizeVowels("Hello World, Java!"));

        System.out.println("\n8번 문제");
        int totalSec = convertToSeconds(2, 30, 15);
        convertFromSeconds(totalSec);

        System.out.println("\n9번 문제");
        seatingChart();

        System.out.println("\n10번 문제");
        System.out.println("3.14159265 Decimal5 value: " + decimalValue(3.14159265, -1));
    }
}
