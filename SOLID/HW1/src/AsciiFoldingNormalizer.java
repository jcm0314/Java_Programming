// 악센트/다이어크리틱 제거 + 공백제거 + 소문자화
import java.text.Normalizer;

public class AsciiFoldingNormalizer implements ITextNormalizer {
    @Override
    public String normalize(String text) {
        String norm = Normalizer.normalize(text, Normalizer.Form.NFD);
        norm = norm.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return norm.trim().toLowerCase();
    }
}
