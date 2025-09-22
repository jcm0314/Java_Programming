// CountableWord 클래스는 단어(Word)와 그 단어가 몇 번 등장했는지(개수)를 함께 저장하는 클래스입니다.
public class CountableWord {
    // 실제 단어를 저장하는 필드 (Word 객체)
    private final Word word;
    // 단어가 등장한 횟수를 저장하는 필드
    private int count;

    // 생성자: 새로운 CountableWord를 만들 때 단어를 받아서 저장하고, 개수는 1로 시작합니다.
    public CountableWord(Word word) {
        this.word = word;
        this.count = 1;
    }

    // 이 객체가 가지고 있는 단어(Word)를 반환합니다.
    public Word getWord() {
        return word;
    }

    // 현재 개수(몇 번 등장했는지)를 반환합니다.
    public int getCount() {
        return count;
    }

    // 단어 개수를 1 증가시킵니다.
    public void increaseCount() {
        count++;
    }

    // 단어 개수를 1 감소시킵니다. (단, 0보다 작아지지 않게)
    public void decreaseCount() {
        if (count > 0) count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 두 CountableWord 객체가 같은지 비교합니다.
    // 내부의 word(단어)가 같으면 같은 것으로 간주합니다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountableWord that = (CountableWord) o;
        return word.equals(that.word);
    }

    // hashCode도 word(단어) 기준으로 만듭니다.
    @Override
    public int hashCode() {
        return word.hashCode();
    }

    // "단어(개수)" 형태의 문자열로 변환합니다. 예: apple(3)
    @Override
    public String toString() {
        return word + "(" + count + ")";
    }
}
