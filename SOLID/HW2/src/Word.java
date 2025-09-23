/**
 * Word 클래스: 하나의 단어를 표현하는 불변(immutable) 클래스
 * 
 * 이 클래스는 단어 하나를 캡슐화하여 저장하고 관리합니다.
 * 불변 객체이므로 생성 후 내용을 변경할 수 없습니다.
 * 
 * 주요 기능:
 * - 단어 저장 및 조회
 * - 단어 길이 계산
 * - 단어 비교 (equals, hashCode)
 * - 문자열 변환 (toString)
 * 
 * 예시:
 * - Word word = new Word("apple");
 * - word.getValue() → "apple"
 * - word.getLength() → 5
 */
public class Word {
    // 실제 단어(문자열)를 저장하는 필드 (final로 불변 보장)
    private final String value;

    /**
     * Word 객체 생성자
     * 
     * @param value 저장할 단어 문자열
     */
    public Word(String value) { 
        this.value = value;
    }

    /**
     * 저장된 단어 문자열을 반환합니다
     * 
     * @return 단어 문자열
     */
    public String getValue() {
        return value;
    }

    /**
     * 단어의 길이(문자 개수)를 반환합니다
     * 
     * @return 단어의 길이
     */
    public int getLength() {
        return value.length();
    }

    /**
     * 두 Word 객체가 같은지 비교합니다
     * 내부의 value(문자열)가 같으면 같은 것으로 간주합니다
     * 
     * @param o 비교할 객체
     * @return 같으면 true, 다르면 false
     */
    @Override
    public boolean equals(Object o) {
        // 같은 객체 참조인지 확인
        if (this == o) return true;
        // null이거나 다른 클래스인지 확인
        if (o == null || getClass() != o.getClass()) return false;
        // Word로 캐스팅하여 내부 값 비교
        Word word = (Word) o;
        return value.equals(word.value);
    }

    /**
     * 객체의 해시코드를 반환합니다
     * equals()와 일관성을 위해 value 기준으로 생성합니다
     * 
     * @return 해시코드 값
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * 단어를 문자열로 변환합니다
     * 
     * @return 단어 문자열 (예: "apple")
     */
    @Override
    public String toString() {
        return value;
    }
}
