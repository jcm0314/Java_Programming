import java.util.*;

public class ScannerExam {
    public static void main(String[] args) throws Exception {
        Scanner a = new Scanner(System.in); // Scanner 객체 생성
        System.out.println("나이, 체중, 신장을 빈칸으로 분리하여 순서대로 입력하세요");
        System.out.println("당신의 나이는 " + Integer.parseInt(a.next()) + "살 입니다.");
        System.out.println("당신의 체중은 " + Double.parseDouble(a.next()) + "kg 입니다.");
        System.out.println("당신의 신장으 " + Double.parseDouble(a.next()) + "cm 입니다.");
    }
}