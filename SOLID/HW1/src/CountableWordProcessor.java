// CountableWordProcessor 클래스: 텍스트를 정규화하고 토큰화한 뒤, 그 결과를 저장소에 담는 전체적인 과정을 관리
import java.util.List;

public class CountableWordProcessor {
    private final List<ITextNormalizer> textNorms;
    private final ITokenizer tokenizer;
    private final CountableWordRepository repository;

    // 생성자: 정규화기 리스트, 토크나이저, 저장소 객체를 받아 초기화
    public CountableWordProcessor(List<ITextNormalizer> textNorms, ITokenizer tokenizer, CountableWordRepository repository) {
        this.textNorms = textNorms;
        this.tokenizer = tokenizer;
        this.repository = repository;
    }

    // 텍스트를 입력받아 정규화 및 토큰화 과정을 거쳐 저장소에 저장
    public void processText(String text) {
        if (text == null || text.isEmpty()) return;
        // 모든 정규화 전략을 순서대로 적용
        for (ITextNormalizer norm : textNorms) {
            text = norm.normalize(text);
        }
        // 토큰화
        List<String> tokens = tokenizer.tokenize(text);
        for (String token : tokens) {
            if (!token.isEmpty()) repository.addOne(token);
        }
    }

    // 초성별로 그룹화된 단어 데이터를 반환
    public java.util.Map<Character, List<CountableWord>> viewByInitial() {
        return repository.viewByInitial();
    }
}
