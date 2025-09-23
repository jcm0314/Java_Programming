package HW2.src;
/**
 * SimpleStemNormalizer 클래스: 간단한 형태소 분석을 수행하는 클래스
 * 
 * 형태소 분석이란 단어의 어간(stem)을 추출하는 과정입니다.
 * 복수형, 소유격, 시제 등을 제거하여 단어의 기본 형태로 만듭니다.
 * 
 * 처리하는 패턴들:
 * - 소유격: 's, 's, s' 제거
 * - 복수형: s, es, ies 제거
 * - 과거형/진행형: ed, ing 제거
 * 
 * 예시:
 * - "dogs'" → "dog" (복수형 + 소유격 제거)
 * - "running" → "run" (진행형 제거)
 * - "played" → "play" (과거형 제거)
 * - "flies" → "fli" (복수형 제거)
 */
public class SimpleStemNormalizer implements ITextNormalizer {
    /**
     * 텍스트에서 형태소를 분석하여 어간을 추출합니다
     * 
     * @param text 형태소 분석할 텍스트
     * @return 어간이 추출된 텍스트
     */
    @Override
    public String normalize(String text) {
        // 기본 정규화: 공백 제거 + 소문자 변환
        String norm = text.trim().toLowerCase();
        
        // 소유격 제거: 's, 's, s' 패턴을 단어 끝에서 제거
        norm = norm.replaceAll("('s|'s|s')$", "");
        
        // 복수형 제거: s, es, ies 패턴을 단어 끝에서 제거
        norm = norm.replaceAll("(ies|s|es)$", "");
        
        // 시제 제거: ed, ing 패턴을 단어 끝에서 제거
        norm = norm.replaceAll("(ed|ing)$", "");
        
        return norm;
    }
}
