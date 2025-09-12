// Normalizer 클래스는 단어를 일정한 형태(소문자, 공백 제거 등)로 바꿔주는 역할을 합니다.
public class Normalizer {
    // 단어를 정규화하는 메서드입니다.
    // 예: " Apple " -> "apple"
    public String normalize(String word) {
        // trim() : 앞뒤 공백 제거, toLowerCase() : 모두 소문자로 변환
        return word.trim().toLowerCase();
    }
}
