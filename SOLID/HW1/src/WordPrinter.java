import java.util.List;
import java.util.Map;

public class WordPrinter {
    public void print(Map<Character, List<CountableWord>> map) {
        for (Map.Entry<Character, List<CountableWord>> e : map.entrySet()) {
            System.out.print(e.getKey() + ": ");
            for (CountableWord cw : e.getValue()) {
                System.out.print(cw + " ");
            }
            System.out.println();
        }
    }
}
