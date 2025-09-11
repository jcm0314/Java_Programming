import java.util.*;

public class WordRepository {
    private final Map<Character, List<CountableWord>> map = new HashMap<>();

    public void addWord(Word word) {
        char key = word.getValue().charAt(0);
        List<CountableWord> list = map.computeIfAbsent(key, k -> new ArrayList<>());
        for (CountableWord cw : list) {
            if (cw.getWord().equals(word)) {
                cw.increaseCount();
                return;
            }
        }
        list.add(new CountableWord(word));
    }

    public void removeWord(Word word) {
        char key = word.getValue().charAt(0);
        List<CountableWord> list = map.get(key);
        if (list == null) return;
        for (Iterator<CountableWord> it = list.iterator(); it.hasNext(); ) {
            CountableWord cw = it.next();
            if (cw.getWord().equals(word)) {
                cw.decreaseCount();
                if (cw.getCount() == 0) {
                    it.remove();
                }
                if (list.isEmpty()) map.remove(key);
                return;
            }
        }
    }

    public Map<Character, List<CountableWord>> getAll() {
        return map;
    }
}
