/**
 * ConsolePrinter 클래스: 저장소에 있는 데이터를 콘솔에 출력하는 클래스
 * 
 * 이 클래스는 CountableWordRepository의 데이터를 읽어서
 * 초성별로 그룹화된 단어들을 정렬하여 콘솔에 출력합니다.
 * 
 * 출력 형식:
 * - 초성: 단어1(빈도) 단어2(빈도) ...
 * - 예: a: apple(2) ant(1)
 * 
 * 정렬 규칙:
 * - 키(초성) 정렬: 숫자 → 알파벳 → 한글 순
 * - 값(단어) 정렬: 각 그룹 내에서 알파벳순
 */
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ConsolePrinter {
    /**
     * 초성별로 그룹화된 단어 데이터를 콘솔에 출력합니다
     * 
     * 출력 과정:
     * 1. 키(초성) 정렬: TreeMap을 사용하여 자동 정렬
     * 2. 각 그룹 내 단어 정렬: Stream API를 사용하여 알파벳순 정렬
     * 3. 콘솔 출력: "초성: 단어1(빈도) 단어2(빈도) ..." 형식
     * 
     * @param grouped 초성별로 그룹화된 CountableWord 데이터
     */
    public void print(Map<Character, List<CountableWord>> grouped) {
        // 키(초성)를 정렬하기 위해 TreeMap 사용
        // TreeMap은 키를 자동으로 정렬해줍니다 (숫자 → 알파벳 → 한글 순)
        Map<Character, List<CountableWord>> sortedGrouped = new TreeMap<>(grouped);
        
        // 정렬된 그룹들을 순회하며 출력
        for (Map.Entry<Character, List<CountableWord>> entry : sortedGrouped.entrySet()) {
            // 초성 출력
            System.out.print(entry.getKey() + ": ");
            
            // 각 리스트 내의 단어들을 알파벳순으로 정렬
            List<CountableWord> sortedWords = entry.getValue().stream()
                .sorted((cw1, cw2) -> cw1.getWord().toString().compareTo(cw2.getWord().toString()))
                .collect(Collectors.toList());
            
            // 정렬된 단어들을 출력
            for (CountableWord cw : sortedWords) {
                System.out.print(cw + " "); // cw.toString()은 "단어(빈도)" 형식
            }
            System.out.println(); // 줄바꿈
        }
    }
}
