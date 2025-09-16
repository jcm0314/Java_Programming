// Word 클래스는 "단어" 하나를 표현하는 클래스입니다. (예: "apple")
public final class Word {
    // 실제 단어(문자열)를 저장하는 필드입니다.
    private final String value;

    // 생성자: Word 객체를 만들 때 단어(문자열)를 받아서 저장합니다.
    public Word(String value) {
        this.value = value;
    }

    // 저장된 단어(문자열)를 반환합니다.
    public String getValue() {
        return value;
    }

    // yourcode: 단어의 길이를 반환합니다.
    public int getLength() {
        return value.length();
    }

    // 두 Word 객체가 같은지 비교합니다.
    // 내부의 value(문자열)가 같으면 같은 것으로 간주합니다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return value.equals(word.value);
    }

    // hashCode도 value(문자열) 기준으로 만듭니다.
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    // 단어(문자열) 자체를 반환합니다. (예: "apple")
    @Override
    public String toString() {
        return value;
    }
}
