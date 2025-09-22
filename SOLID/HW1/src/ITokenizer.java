// 토큰화 전략 인터페이스
import java.util.List;

public interface ITokenizer {
    List<String> tokenize(String text);
}
