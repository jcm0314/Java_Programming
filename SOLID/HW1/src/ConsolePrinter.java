// ConsolePrinter 클래스: 저장소에 있는 데이터를 콘솔에 출력하는 역할
import java.util.List;
import java.util.Map;

public class ConsolePrinter {
    // 초성별로 그룹화된 단어 데이터를 입력받아 콘솔에 출력합니다.
    public void print(Map<Character, List<CountableWord>> grouped) {
        for (Map.Entry<Character, List<CountableWord>> entry : grouped.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (CountableWord cw : entry.getValue()) {
                System.out.print(cw + " ");
            }
            System.out.println();
        }
    }
}
