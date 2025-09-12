// WordPrinter 클래스는 저장된 단어 목록을 예쁘게(보기 좋게) 출력해주는 역할을 합니다.
import java.util.List;
import java.util.Map;

public class WordPrinter {
    // print 메서드는 단어 목록(map)을 받아서, 각 알파벳별로 단어와 개수를 출력합니다.
    // 예: a: apple(2) ...
    public void print(Map<Character, List<CountableWord>> map) {
        // map의 각 항목(알파벳, 단어 리스트)을 하나씩 꺼냅니다.
        for (Map.Entry<Character, List<CountableWord>> e : map.entrySet()) {
            System.out.print(e.getKey() + ": "); // 알파벳 출력
            for (CountableWord cw : e.getValue()) {
                System.out.print(cw + " "); // 단어(개수) 출력
            }
            System.out.println(); // 줄 바꿈
        }
    }
}
