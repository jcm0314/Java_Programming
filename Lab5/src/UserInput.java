import java.util.Scanner;

public class UserInput {
    static Scanner scan = new Scanner(System.in);

    // no parameter & char return
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
