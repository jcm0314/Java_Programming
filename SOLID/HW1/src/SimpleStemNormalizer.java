// 간단한 형태소 처리(복수형, 시제 등 제거)
public class SimpleStemNormalizer implements ITextNormalizer {
    @Override
    public String normalize(String text) {
        String norm = text.trim().toLowerCase();
        norm = norm.replaceAll("(’s|'s|s')$", "");
        norm = norm.replaceAll("(ies|s|es)$", "");
        norm = norm.replaceAll("(ed|ing)$", "");
        return norm;
    }
}
