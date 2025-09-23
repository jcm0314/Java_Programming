package HW2.src;
/**
 * WhitespaceTokenizer 클래스: 공백만을 기준으로 텍스트를 토큰으로 분리하는 클래스
 * 
 * 가장 간단한 토큰화 방법 중 하나입니다.
 * 공백(스페이스, 탭, 줄바꿈 등)만을 기준으로 텍스트를 분리합니다.
 * 구두점이나 특수문자는 그대로 유지됩니다.
 * 
 * 예시:
 * - "Hello world!" → ["Hello", "world!"]
 * - "apple, banana, cherry" → ["apple,", "banana,", "cherry"]
 * - "  spaced   out  " → ["spaced", "out"] (앞뒤 공백 제거)
 */
import java.util.Arrays;
import java.util.List;

public class WhitespaceTokenizer implements ITokenizer {
    /**
     * 공백을 기준으로 텍스트를 토큰들로 분리합니다
     * 
     * @param text 토큰화할 텍스트
     * @return 공백으로 분리된 토큰들의 리스트
     */
    @Override
    public List<String> tokenize(String text) {
        // trim(): 앞뒤 공백 제거
        // split("\\s+"): 하나 이상의 공백 문자로 분리
        // Arrays.asList(): 배열을 리스트로 변환
        return Arrays.asList(text.trim().split("\\s+"));
    }
}
