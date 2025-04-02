import java.util.*;

public class LAB3 {

    // 문제 1: Fraction 연산
    public static void fraction(double a, double b, double c, double d) {
        double add = (a * d + b * c) / (b * d);
        double sub = (a * d - b * c) / (b * d);
        double mul = (a * c) / (b * d);
        double div = (a * d) / (b * c);

        System.out.printf("Fraction Addition: %.1f/%.1f + %.1f/%.1f = %.1f/%.1f\n", a, b, c, d, (a*d + b*c), (b*d));
        System.out.printf("Fraction Subtraction: %.1f/%.1f - %.1f/%.1f = %.1f/%.1f\n", a, b, c, d, (a*d - b*c), (b*d));
        System.out.printf("Fraction Multiplication: %.1f/%.1f * %.1f/%.1f = %.1f/%.1f\n", a, b, c, d, (a*c), (b*d));
        System.out.printf("Fraction Division: %.1f/%.1f / %.1f/%.1f = %.1f/%.1f\n", a, b, c, d, (a*d), (b*c));
    }

    // 문제 2: 숫자 성질 확인
    public static int getRandomIntBetween(int a, int b) {
        return new Random().nextInt(b - a + 1) + a;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isMultiplesOfThree(int n) {
        return n % 3 == 0;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void checkNumber(int num) {
        System.out.println(num + (isEven(num) ? " is even number." : " is odd number."));
        System.out.println(num + (isMultiplesOfThree(num) ? " is a multiple of 3." : " is NOT a multiple of 3."));
        System.out.println(num + (isPrime(num) ? " is a prime number." : " is NOT a prime number."));
    }

    // 문제 3: 빠른 지수 계산
    public static long powerCalculation(long base, long exponent) {
        if (exponent == 0) return 1;
        long half = powerCalculation(base, exponent / 2);
        return exponent % 2 == 0 ? half * half : base * half * half;
    }

    // 문제 4: 구구단 출력
    public static int getUserInputBetween(String msg, int min, int max, Scanner scanner) {
        int value;
        do {
            System.out.print(msg);
            value = scanner.nextInt();
        } while (value < min || value > max);
        return value;
    }

    public static void multiplicationTable() {
        Scanner scanner = new Scanner(System.in);
        int value = getUserInputBetween("Please enter a number between [2-20]: ", 2, 20, scanner);
        System.out.println("Multiplication Table for " + value + ":");
        for (int i = 1; i <= 9; i++) {
            System.out.println(value + " x " + i + " = " + (value * i));
        }
    }

    // 문제 5: Color enum 처리
    enum Color {
        RED(255,0,0), GREEN(0,255,0), BLUE(0,0,255),
        YELLOW(255,255,0), WHITE(255,255,255), BLACK(0,0,0);

        private final int r, g, b;
        Color(int r, int g, int b) {
            this.r = r; this.g = g; this.b = b;
        }

        public static Color getColor(int r, int g, int b) {
            for (Color c : values()) {
                if (c.r == r && c.g == g && c.b == b) return c;
            }
            return null;
        }
    }

    // 문제 6: 소수점 자리 반올림
    public static double decimalValue(double num, int decimalPlace) {
        double floor = Math.floor(num);
        double fraction = num - floor;
        double rounded = Math.round(fraction * Math.pow(10, decimalPlace)) / Math.pow(10, decimalPlace);
        return rounded;
    }

    // 문제 7: 모음만 대문자로
    public static String emphasizeVowels(String str) {
        String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(vowels.indexOf(c) >= 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
        }
        return sb.toString();
    }

    // 문제 8: 시간 변환
    public static int convertToSeconds(int h, int m, int s) {
        int total = h * 3600 + m * 60 + s;
        System.out.printf("%d hours, %d minutes, %d seconds converted to total seconds is: %d sec\n", h, m, s, total);
        return total;
    }

    public static void convertFromSeconds(int total) {
        int hours = total / 3600;
        int minutes = (total % 3600) / 60;
        int seconds = total % 60;
        System.out.printf("%d seconds is: %d hours, %d minutes, %d seconds\n", total, hours, minutes, seconds);
    }

    // 문제 9: 좌석표 출력
    public static String[][] createSeatingChart(int rows, int cols) {
        String[][] chart = new String[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                chart[r][c] = "R" + (r + 1) + "C" + (c + 1);
        return chart;
    }

    public static void printSeatingChart(String[][] chart) {
        for (String[] row : chart) {
            for (String seat : row) {
                System.out.print(seat + "\t");
            }
            System.out.println();
        }
    }

    public static void seatingChart() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter row column number [e.g. 4,5]: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) break;
            try {
                String[] tokens = input.split(",");
                int rows = Integer.parseInt(tokens[0].trim());
                int cols = Integer.parseInt(tokens[1].trim());
                printSeatingChart(createSeatingChart(rows, cols));
            } catch (Exception e) {
                System.out.println("입력이 잘못되었습니다. 예: 4,5");
            }
            System.out.print("Press 'q' to exit the process or any-key to continue: ");
            if (scanner.nextLine().equalsIgnoreCase("q")) break;
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
        System.out.println("getColor(255,0,0) --> " + Color.getColor(255,0,0));
        System.out.println("getColor(0,255,0) --> " + Color.getColor(0,255,0));
        System.out.println("getColor(0,0,255) --> " + Color.getColor(0,0,255));
        System.out.println("getColor(255,255,0) --> " + Color.getColor(255,255,0));
        System.out.println("getColor(255,255,255) --> " + Color.getColor(255,255,255));
        System.out.println("getColor(0,0,0) --> " + Color.getColor(0,0,0));
        System.out.println("getColor(255,0,255) --> " + Color.getColor(255,0,255));

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
    }
}
