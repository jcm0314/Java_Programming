// 정규식 기반 토큰화
import java.util.Arrays;
import java.util.List;

public class RegexTokenizer implements ITokenizer {
    private final String pattern;
    public RegexTokenizer(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public List<String> tokenize(String text) {
        return Arrays.asList(text.split(pattern));
    }
}
