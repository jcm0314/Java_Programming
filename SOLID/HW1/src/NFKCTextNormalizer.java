// 유니코드 NFKC 정규화
import java.text.Normalizer;

public class NFKCTextNormalizer implements ITextNormalizer {
    @Override
	public String normalize(String raw) {
	if (raw == null) return "";
	return Normalizer.normalize(raw,

	Normalizer.Form.NFKC);
	}
}
