import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public List<String> tokenize(String text) {
        String[] tokens = text.split("[ \t\n'\",.?!]");
        List<String> result = new ArrayList<>();
        for (String t : tokens) {
            if (!t.isEmpty()) {
                result.add(t);
            }
        }
        return result;
    }
}
