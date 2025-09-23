/**
 * CountableWordProcessor 클래스: 텍스트 처리 파이프라인의 전체 과정을 관리하는 클래스
 * 
 * 이 클래스는 텍스트 처리의 전체 파이프라인을 관리합니다:
 * 1. 텍스트 정규화 (여러 정규화기 순차 적용)
 * 2. 토큰화 (텍스트를 단어들로 분리)
 * 3. 저장소에 결과 저장 (단어별 빈도 계산)
 * 
 * Strategy Pattern을 사용하여 다양한 정규화와 토큰화 방법을 조합할 수 있습니다.
 * 
 * 예시:
 * - 파이프라인 1: NFKC → 소문자화 → 정규식 토큰화
 * - 파이프라인 2: ASCII 폴딩 → 형태소 분석 → 공백 토큰화
 */
import java.util.List;

public class CountableWordProcessor {
    // 정규화기들의 리스트 (순서대로 적용됨)
    private final List<ITextNormalizer> textNorms;
    // 토큰화기 (텍스트를 단어들로 분리)
    private final ITokenizer tokenizer;
    // 결과를 저장할 저장소
    private final CountableWordRepository repository;

    /**
     * CountableWordProcessor 생성자
     * 
     * @param textNorms 정규화기들의 리스트 (순서대로 적용됨)
     * @param tokenizer 토큰화기
     * @param repository 결과 저장소
     */
    public CountableWordProcessor(List<ITextNormalizer> textNorms, ITokenizer tokenizer, CountableWordRepository repository) {
        this.textNorms = textNorms;
        this.tokenizer = tokenizer;
        this.repository = repository;
    }

    /**
     * 텍스트를 입력받아 전체 파이프라인을 실행합니다
     * 
     * 처리 과정:
     * 1. 입력 검증 (null, 빈 문자열 체크)
     * 2. 정규화: 모든 정규화기를 순서대로 적용
     * 3. 토큰화: 텍스트를 단어들로 분리
     * 4. 저장: 각 단어를 저장소에 추가 (빈도 계산)
     * 
     * @param text 처리할 텍스트
     */
    public void processText(String text) {
        // 입력 검증: null이거나 빈 문자열이면 처리하지 않음
        if (text == null || text.isEmpty()) return;
        
        // 정규화 단계: 모든 정규화 전략을 순서대로 적용
        for (ITextNormalizer norm : textNorms) {
            text = norm.normalize(text);
        }
        
        // 토큰화 단계: 정규화된 텍스트를 단어들로 분리
        List<String> tokens = tokenizer.tokenize(text);
        
        // 저장 단계: 각 토큰을 저장소에 추가 (빈도 계산)
        for (String token : tokens) {
            if (!token.isEmpty()) {
                repository.addOne(token);
            }
        }
    }

    /**
     * 초성별로 그룹화된 단어 데이터를 반환합니다
     * 
     * @return 초성(Character)을 키로, CountableWord 리스트를 값으로 하는 Map
     */
    public java.util.Map<Character, List<CountableWord>> viewByInitial() {
        return repository.viewByInitial();
    }

    // yourcode: 전체 단어 개수를 반환합니다
    /**
     * 처리된 텍스트의 전체 단어 개수를 반환합니다
     * 
     * @return 전체 단어 개수 (중복 포함)
     */
    public int getTotalWordCount() {
        return repository.getTotalWordCount();
    }
}
