package HW2.src;
/**
 * ITokenizer 인터페이스: 텍스트 토큰화 전략을 정의하는 인터페이스
 * 
 * Strategy Pattern을 사용하여 다양한 텍스트 분리 방법을 구현할 수 있습니다.
 * 토큰화란 긴 텍스트를 의미 있는 단위(토큰)로 나누는 과정입니다.
 * 
 * 구현 클래스들:
 * - RegexTokenizer: 정규식을 사용한 토큰화 (공백, 구두점 등으로 분리)
 * - WhitespaceTokenizer: 공백만을 기준으로 토큰화
 */
import java.util.List;

public interface ITokenizer {
    /**
     * 텍스트를 토큰들로 분리하는 메서드
     * 
     * @param text 토큰화할 텍스트
     * @return 분리된 토큰들의 리스트
     */
    List<String> tokenize(String text);
}
