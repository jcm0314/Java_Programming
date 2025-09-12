// WordRepository 클래스는 단어와 개수를 저장하고 관리하는 역할을 합니다.
// 단어를 알파벳(첫 글자)별로 분류해서 저장합니다.
import java.util.*;

public class WordRepository {
    // map은 알파벳(문자) -> CountableWord(단어+개수) 리스트로 저장합니다.
    // 예: 'a' -> [apple(2), ant(1)]
    private final Map<Character, List<CountableWord>> map = new HashMap<>();

    // 단어를 저장하는 메서드입니다.
    // 이미 있으면 개수만 증가, 없으면 새로 추가합니다.
    public void addWord(Word word) {
        char key = word.getValue().charAt(0); // 단어의 첫 글자를 키로 사용
        List<CountableWord> list = map.computeIfAbsent(key, k -> new ArrayList<>());
        for (CountableWord cw : list) {
            if (cw.getWord().equals(word)) {
                cw.increaseCount(); // 이미 있으면 개수만 증가
                return;
            }
        }
        list.add(new CountableWord(word)); // 없으면 새로 추가
    }

    // 단어를 1개 제거하는 메서드입니다.
    // 개수가 0이 되면 리스트에서 삭제, 리스트가 비면 map에서도 삭제
    public void removeWord(Word word) {
        char key = word.getValue().charAt(0);
        List<CountableWord> list = map.get(key);
        if (list == null) return;
        for (Iterator<CountableWord> it = list.iterator(); it.hasNext(); ) {
            CountableWord cw = it.next();
            if (cw.getWord().equals(word)) {
                cw.decreaseCount(); // 개수 1 감소
                if (cw.getCount() == 0) {
                    it.remove(); // 0이면 리스트에서 삭제
                }
                if (list.isEmpty()) map.remove(key); // 리스트 비면 map에서도 삭제
                return;
            }
        }
    }

    // 전체 단어 목록(map)을 반환합니다.
    public Map<Character, List<CountableWord>> getAll() {
        return map;
    }
}
