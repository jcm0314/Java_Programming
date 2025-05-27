// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
/* Your Code     
 출력할 떄 출력 형식을 지정하는 클래스로 보기 좋게 표시되도록 함
*/

package util;

public class PrintUtil {
    public static void printSeparator() {
        System.out.println("----------------------------------------");
    }

    public static void printTitle(String title) {
        printSeparator();
        System.out.println(title);
        printSeparator();
    }

    public static void printCount(String type, int count) {
        System.out.printf("총 %s 개수: %d개\n", type, count);
    }
} 