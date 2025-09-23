package HW2.src;
/**
 * ITextNormalizer 인터페이스: 텍스트 정규화 전략을 정의하는 인터페이스
 * 
 * Strategy Pattern을 사용하여 다양한 텍스트 정규화 방법을 구현할 수 있습니다.
 * 예: 소문자화, 공백제거, 유니코드 정규화, 악센트 제거 등
 * 
 * 구현 클래스들:
 * - NFKCTextNormalizer: 유니코드 NFKC 정규화
 * - LowercaseTrimTextNormalizer: 소문자화 + 공백제거
 * - AsciiFoldingNormalizer: 악센트 제거 (한글 보존)
 * - SimpleStemNormalizer: 간단한 형태소 분석
 */
public interface ITextNormalizer {
    /**
     * 텍스트를 정규화하는 메서드
     * 
     * @param raw 정규화할 원본 텍스트
     * @return 정규화된 텍스트
     */
    String normalize(String raw);
}
