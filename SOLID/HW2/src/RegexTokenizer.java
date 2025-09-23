package HW2.src;
/**
 * RegexTokenizer 클래스: 정규식을 사용하여 텍스트를 토큰으로 분리하는 클래스
 * 
 * 정규식 패턴을 사용하여 텍스트를 분리할 수 있어 매우 유연합니다.
 * 공백, 구두점, 특수문자 등 다양한 기준으로 토큰화가 가능합니다.
 * 
 * 사용 예시:
 * - "[\\s\\p{Punct}]+": 공백과 구두점으로 분리
 * - "[^a-zA-Z]+": 알파벳이 아닌 문자로 분리
 * - "\\s+": 공백으로만 분리
 * 
 * 예시:
 * - "Hello, world!" → ["Hello", "world"] (공백과 구두점으로 분리)
 * - "apple123banana" → ["apple", "banana"] (숫자로 분리)
 */
import java.util.Arrays;
import java.util.List;

public class RegexTokenizer implements ITokenizer {
    // 토큰화에 사용할 정규식 패턴
    private final String pattern;
    
    /**
     * RegexTokenizer 생성자
     * 
     * @param pattern 토큰화에 사용할 정규식 패턴
     */
    public RegexTokenizer(String pattern) {
        this.pattern = pattern;
    }
    
    /**
     * 정규식 패턴을 사용하여 텍스트를 토큰들로 분리합니다
     * 
     * @param text 토큰화할 텍스트
     * @return 분리된 토큰들의 리스트
     */
    @Override
    public List<String> tokenize(String text) {
        // String.split()을 사용하여 정규식 패턴으로 텍스트 분리
        // Arrays.asList()로 배열을 리스트로 변환
        return Arrays.asList(text.split(pattern));
    }
}
