package HW2.src;
/**
 * NFKCTextNormalizer 클래스: 유니코드 NFKC 정규화를 수행하는 클래스
 * 
 * NFKC (Normalization Form Composed Compatibility)는:
 * - 호환 문자들을 정규 문자로 변환 (예: Ａ → A)
 * - 결합형 문자들을 조합형으로 변환 (예: é → é)
 * - 전각 문자를 반각 문자로 변환
 * 
 * 예시:
 * - "café" → "café" (변화 없음)
 * - "ＡＢＣ" → "ABC" (전각 → 반각)
 * - "３가지" → "3가지" (전각 숫자 → 반각 숫자)
 */
import java.text.Normalizer;

public class NFKCTextNormalizer implements ITextNormalizer {
    /**
     * 텍스트를 NFKC 형태로 정규화합니다
     * 
     * @param raw 정규화할 원본 텍스트
     * @return NFKC로 정규화된 텍스트 (null인 경우 빈 문자열 반환)
     */
    @Override
	public String normalize(String raw) {
		// null 체크: 입력이 null이면 빈 문자열 반환
		if (raw == null) return "";
		
		// NFKC 정규화 수행
		// - 호환 문자들을 정규 문자로 변환
		// - 결합형 문자들을 조합형으로 변환
		return Normalizer.normalize(raw, Normalizer.Form.NFKC);
	}
}
