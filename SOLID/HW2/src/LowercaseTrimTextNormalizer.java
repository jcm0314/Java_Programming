package HW2.src;
/**
 * LowercaseTrimTextNormalizer 클래스: 텍스트를 소문자로 변환하고 앞뒤 공백을 제거하는 클래스
 * 
 * 가장 기본적인 텍스트 정규화 중 하나입니다.
 * 대소문자 구분 없이 단어를 비교하거나 검색할 때 사용됩니다.
 * 
 * 예시:
 * - "  HELLO World  " → "hello world"
 * - "Quick" → "quick"
 * - "  FOX!!  " → "fox!!"
 */
public class LowercaseTrimTextNormalizer implements ITextNormalizer {
    /**
     * 텍스트를 소문자로 변환하고 앞뒤 공백을 제거합니다
     * 
     * @param text 정규화할 텍스트
     * @return 소문자로 변환되고 앞뒤 공백이 제거된 텍스트
     */
    @Override
    public String normalize(String text) {
        // trim(): 앞뒤 공백 제거
        // toLowerCase(): 모든 문자를 소문자로 변환
        return text.trim().toLowerCase();
    }
}
