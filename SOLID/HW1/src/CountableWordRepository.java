// CountableWordRepository 클래스: 텍스트 처리 결과를 저장하고 관리하는 저장소 역할
import java.util.*;

public class CountableWordRepository {
    // 단어의 첫 글자(Character)를 키로, 해당 글자로 시작하는 CountableWord 리스트를 값으로 저장
    private final Map<Character, List<CountableWord>> map = new HashMap<>();

    // 단어를 저장소에 추가합니다.
    public void addOne(String token) {
        if (token == null || token.isEmpty()) return;
        char key = token.charAt(0);
        List<CountableWord> list = map.computeIfAbsent(key, k -> new ArrayList<>());
        for (CountableWord cw : list) {
            if (cw.getWord().toString().equals(token)) {
                cw.increaseCount();
                return;
            }
        }
        list.add(new CountableWord(new Word(token)));
    }

    // 단어를 저장소에서 제거합니다.
    public void removeOne(String token) {
        if (token == null || token.isEmpty()) return;
        char key = token.charAt(0);
        List<CountableWord> list = map.get(key);
        if (list == null) return;
        Iterator<CountableWord> it = list.iterator();
        while (it.hasNext()) {
            CountableWord cw = it.next();
            if (cw.getWord().toString().equals(token)) {
                cw.decreaseCount();
                if (cw.getCount() == 0) it.remove();
                if (list.isEmpty()) map.remove(key);
                return;
            }
        }
    }

    // 초성별로 그룹화된 단어 리스트를 반환합니다.
    public Map<Character, List<CountableWord>> viewByInitial() {
        return map;
    }
}
