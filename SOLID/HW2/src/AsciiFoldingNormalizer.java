package HW2.src;
/**
 * AsciiFoldingNormalizer 클래스: 악센트/다이어크리틱을 제거하면서 한글은 보존하는 클래스
 * 
 * ASCII 폴딩이란 유럽어의 악센트나 특수 기호를 제거하여 기본 ASCII 문자로 변환하는 과정입니다.
 * 하지만 한글은 보존하여 깨지지 않도록 합니다.
 * 
 * 예시:
 * - "café" → "cafe" (악센트 제거)
 * - "naïve" → "naive" (악센트 제거)
 * - "프로그래밍" → "프로그래밍" (한글 보존)
 * - "résumé" → "resume" (악센트 제거)
 */
import java.text.Normalizer;

public class AsciiFoldingNormalizer implements ITextNormalizer {
    /**
     * 텍스트에서 악센트를 제거하되 한글은 보존합니다
     * 
     * @param text 정규화할 텍스트
     * @return 악센트가 제거되고 소문자로 변환된 텍스트 (한글은 보존)
     */
    @Override
    public String normalize(String text) {
        // 결과를 저장할 StringBuilder
        StringBuilder result = new StringBuilder();
        
        // 각 문자를 하나씩 처리
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            // 한글 범위인지 확인 (유니코드 범위로 판단)
            if ((c >= 0xAC00 && c <= 0xD7AF) || // 한글 완성형 (가-힣)
                (c >= 0x1100 && c <= 0x11FF) || // 한글 자모
                (c >= 0x3130 && c <= 0x318F)) { // 한글 호환 자모
                // 한글은 그대로 보존
                result.append(c);
            } else {
                // 한글이 아닌 문자는 NFD로 정규화 후 결합형 문자 제거
                String charStr = String.valueOf(c);
                String norm = Normalizer.normalize(charStr, Normalizer.Form.NFD);
                // 결합형 문자(악센트 등) 제거
                norm = norm.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                result.append(norm);
            }
        }
        
        // 최종 결과: 앞뒤 공백 제거 + 소문자 변환
        return result.toString().trim().toLowerCase();
    }
}
