// 공백 기준 토큰화
import java.util.Arrays;
import java.util.List;

public class WhitespaceTokenizer implements ITokenizer {
    @Override
    public List<String> tokenize(String text) {
        return Arrays.asList(text.trim().split("\\s+"));
    }
}
