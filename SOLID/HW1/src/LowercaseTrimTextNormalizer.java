// 공백제거 및 소문자화
public class LowercaseTrimTextNormalizer implements ITextNormalizer {
    @Override
    public String normalize(String text) {
        return text.trim().toLowerCase();
    }
}
