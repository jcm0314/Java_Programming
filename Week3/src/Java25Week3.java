import java.util.Random;
import java.util.Scanner;

public class Java25Week3 {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) throws Exception {
        // 1. if & random (if num is positive/negative/zero)
        System.out.println("if & random");
        int num = random.nextInt(201) - 100; // -100 ~ 100
        

        // 2. for (print b = 0,1,2,3,4)
        for(int b=1; b<6; b++) {
            System.out.println(b);
        }
        
        // 2. while (print c = 0,1,2,3,4)
        int c = 0;
        while (c < 5) {
            System.out.println(c);
            c++;
        }
        
        // 2. do-while (print d = 0,1,2,3,4)
        int d = 0;
        do {
            System.out.println(d);
            d++;
        } while (d < 5);
        

        // 3. break (print e = 0,1,2,3,4)
        System.out.println("break");
        int e = 0;
        while (true) {
            if (e == 5) {
                break;
            }
            System.out.println(e);
            e++;
        }
    
        

        // 3. continue (print f = 2,4)
        System.out.println("continue");
		int f = 0;
        for (f=1; f<5; f++) {
            if(f % 2 != 0) {
                continue;
            }
            System.out.println(f);
            f++;
        }
		

        // 4. for-for (print width=1.0 height=1.0 ... width=5.0 height=10.0)
        System.out.println("for-for");
        double width = 1.0; // 1~5 (+0.5)
        double height = 1.0; // 1~10 (+0.5)
        for(width=1.0;width <= 5.0; width += 0.5) {
            for(height=5.0;height <= 10.0; height += 0.5)
            System.out.printf("%.1f, %.1f\n", width, height);
        }


        // 4. if & for (print dice roll number & if roll==6 then re-rolling within 5 times rolling)
        System.out.println("if-for");
        for (int i = 0; i < 5; i++) {			
            int roll = random.nextInt(6) + 1;
            if (roll == 6) {
                i--;
                continue;
            }
            System.out.println(roll);
        }
        

        // 4. switch & for (print a month has b days)
        System.out.println("switch-for");
        for (int month = 1; month <= 12; month++) {
            int days = 31;

            switch(month) {
                case 2:
                    days = 28;
                    break;
                case 4: case 6: case 9: case 11:
                    days = 30;
                    break;
                default:
                    days = 31;
            }

            System.out.println(month + "month " + days + "days");
        } 

        
        // 5. for-each & 1D array (char)
        System.out.println("for-each char[]");
        char[] letters = {'A', 'B', 'C', 'D', 'E'};
        for(char ch: letters) {
            System.out.println(ch);
        }
        
        // 5. for-each & 1D array (String)
        System.out.println("for-each String[]");
        String[] strings = {"ABCDE", "APPLE", "BANANA"};
        for(String st: strings) {
            System.out.println(st);
        }
        
        
        // 5. for & 2D array (int) + - * / %
        int[][] nums = {{49,5}, {36,2}, {88,6}};
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d + %d = %d\n", nums[i][0], nums[i][1], nums[i][0] + nums[i][1]);
            System.out.printf("%d - %d = %d\n", nums[i][0], nums[i][1], nums[i][0] - nums[i][1]);
            System.out.printf("%d * %d = %d\n", nums[i][0], nums[i][1], nums[i][0] * nums[i][1]);
            System.out.printf("%d / %d = %d\n", nums[i][0], nums[i][1], nums[i][0] / nums[i][1]);
            System.out.printf("%d %% %d = %d\n", nums[i][0], nums[i][1], nums[i][0] % nums[i][1]);
        }
        // 6. user input
        System.out.print("Please enter the first number:");
        e = Integer.parseInt(scan.nextLine());
        System.out.print("Please enter the second number:");
        f = Integer.parseInt(scan.nextLine());
        System.out.printf("%d + %d = %d\n", e, f, e + f);
    }
}