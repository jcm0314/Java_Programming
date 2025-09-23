package HW2.src;
/**
 * CountableWord 클래스: 단어와 그 단어의 등장 횟수를 함께 관리하는 클래스
 * 
 * 이 클래스는 Word 객체와 해당 단어가 텍스트에서 몇 번 나타났는지를 함께 저장합니다.
 * 텍스트 분석에서 단어의 빈도를 계산할 때 사용됩니다.
 * 
 * 주요 기능:
 * - 단어 저장 및 조회
 * - 등장 횟수 관리 (증가, 감소)
 * - 빈도 확인
 * - 단어 비교 (equals, hashCode)
 * 
 * 예시:
 * - CountableWord cw = new CountableWord(new Word("apple"));
 * - cw.increaseCount(); // 등장 횟수 증가
 * - cw.toString() → "apple(2)"
 */
public class CountableWord {
    // 실제 단어를 저장하는 필드 (Word 객체, 불변)
    private final Word word;
    // 단어가 등장한 횟수를 저장하는 필드 (가변)
    private int count;

    /**
     * CountableWord 생성자
     * 새로운 CountableWord를 생성할 때 단어를 받아서 저장하고, 개수는 1로 시작합니다
     * 
     * @param word 저장할 단어 객체
     */
    public CountableWord(Word word) {
        this.word = word;
        this.count = 1; // 처음 생성 시 등장 횟수는 1
    }

    /**
     * 이 객체가 가지고 있는 단어(Word)를 반환합니다
     * 
     * @return 저장된 Word 객체
     */
    public Word getWord() {
        return word;
    }

    /**
     * 현재 개수(몇 번 등장했는지)를 반환합니다
     * 
     * @return 등장 횟수
     */
    public int getCount() {
        return count;
    }

    /**
     * 단어 개수를 1 증가시킵니다
     * 같은 단어가 다시 나타났을 때 호출됩니다
     */
    public void increaseCount() {
        count++;
    }

    /**
     * 단어 개수를 1 감소시킵니다
     * 단, 0보다 작아지지 않도록 보장합니다
     */
    public void decreaseCount() {
        if (count > 0) count--;
    }

    /**
     * 등장 횟수가 0인지 확인합니다
     * 
     * @return 등장 횟수가 0이면 true, 아니면 false
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 두 CountableWord 객체가 같은지 비교합니다
     * 내부의 word(단어)가 같으면 같은 것으로 간주합니다
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
        // CountableWord로 캐스팅하여 내부 단어 비교
        CountableWord that = (CountableWord) o;
        return word.equals(that.word);
    }

    /**
     * 객체의 해시코드를 반환합니다
     * equals()와 일관성을 위해 word 기준으로 생성합니다
     * 
     * @return 해시코드 값
     */
    @Override
    public int hashCode() {
        return word.hashCode();
    }

    /**
     * "단어(개수)" 형태의 문자열로 변환합니다
     * 
     * @return 문자열 표현 (예: "apple(3)")
     */
    @Override
    public String toString() {
        return word + "(" + count + ")";
    }
}
