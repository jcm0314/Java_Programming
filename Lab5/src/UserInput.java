/**
 * 사용자 입력을 처리하는 유틸리티 클래스
 * 다양한 형태의 입력(정수, 실수, 연산자 등)을 안전하게 처리
 */
import java.util.Scanner;

public class UserInput {
    // 사용자 입력을 받기 위한 Scanner 객체
    static Scanner scan = new Scanner(System.in);

    /**
     * 산술 연산자를 입력받는 메소드
     * @return 유효한 연산자 (+, -, *, /, %)
     */
    public static char getUserInputOp() {
		char value = '\0';
		do {
			System.out.printf("Please enter the operator [+,-,*,/,%%]: ");
			try {
				value = scan.nextLine().charAt(0);
				System.out.println("value=" + value);
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter!\n");
				scan.nextLine();
				continue;
			}
		} while (value != '+' && value != '-' && value != '*' && value != '/' && value != '%');
		return value;
	}

    /**
     * 정수를 입력받는 메소드
     * @return 입력된 정수 값
     */
    public static int getInteger() {
		int value = 0;
    	while(true) { // while
    		try {
    			value = Integer.parseInt(scan.nextLine());
    			break;
    		}
    		catch (Exception e) {
    			System.out.print("Error! Please re-enter float value: ");
    			scan.nextLine();
                continue;
    		}
    	}
        return value;
	}

    /**
     * 실수를 입력받는 메소드
     * @return 입력된 실수 값
     */
    public static float getFloat() {
		float value = 0.0f;
    	while(true) { // while
    		try {
    			value = Float.parseFloat(scan.nextLine());
    			break;
    		}
    		catch (Exception e) {
    			System.out.print("Error! Please re-enter float value: ");
    			scan.nextLine();
                continue;
    		}
    	}
        return value;
	}

	/**
     * 지정된 범위 내의 정수를 입력받는 메소드
     * @param min 허용되는 최소 값
     * @param max 허용되는 최대 값
     * @return min과 max 사이의 정수 값
     */
	public static int getIntegerBetween(int min, int max) {
		int value = 0;
    	do { // do-while
    		//System.out.printf("Enter the number between [%d - %d]", min, max);
    		try {
    			value = Integer.parseInt(scan.nextLine());
    		}
    		catch (Exception e) {
    			System.out.println("Error! Please re-enter integer value");
    			scan.nextLine();
    			continue;
    		}
    	} while(value < min || value > max);
    	return value;
	}

    /**
     * 프로그램 종료 여부를 확인하는 메소드
     * @return 'q' 입력 시 true, 그 외 입력 시 false
     */
    public static boolean getUserExitKey() {
    	System.out.println("Press q-key to exit the program or enter-key to start the program");
		char c = scan.nextLine().charAt(0);
        if (c == 'q') {
            return true;
        }
        else {
            return false;
        }
    }
}
