// Tokenizer 클래스는 긴 문자열을 단어(토큰)로 잘라주는 역할을 합니다.
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    // 문자열을 단어(토큰)로 분리하는 메서드입니다.
    // 예: "apple, banana!" -> ["apple", "banana"]
    public List<String> tokenize(String text) {
        // split() 메서드로 공백, 탭, 줄바꿈, 구두점 등 기준으로 자릅니다.
        String[] tokens = text.split("[ \t\n'\",.?!]");
        List<String> result = new ArrayList<>();
        for (String t : tokens) {
            // 빈 문자열은 제외하고 결과에 추가합니다.
            if (!t.isEmpty()) {
                result.add(t);
            }
        }
        return result;
    }
}
