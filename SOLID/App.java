// 2025/09/10 Java Programming 2 HW1 - Monolithic Code @ DKU
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Word {                 // 불변 아님, 캡슐화 약함 -> 단어가 바뀔 수 있음음 -> OCP 위반
    public String word;      // 캡슐화 약함 public field -> 외부에서 직접 수정 가능 -> 캡슐화 약함
    Word(String w){ this.word = w; }
    @Override 
    public String toString() { return word; } // 표현-도메인 혼재
    // 👎 LSP 위반: equals(), hashCode() 미구현으로 인한 예상과 다른 동작
}

interface Countable {        // 넓은 인터페이스, 일부 구현체는 불필요할 수 있음 -> ISP 위반
    void increaseCount();
    void decreaseCount();
    int getCount();
    // 👎 ISP 위반: 넓은 인터페이스로 인해 일부 구현체에게 불필요한 메서드 강제
    // 👎 ISP 위반: 클라이언트가 사용하지 않는 메서드에 의존하게 됨
}

// CountableWord는 단어 + 카운트라는 별도 책임을 가짐에도 Word를 상속 -> LSP 위반
// 상속 대신 합성: final class CountableWord { private final Word word; private int count; … }
class CountableWord extends Word implements Countable {
    int count = 1; // public 아님이지만 패키지 접근, equals/hashCode 불일치 예정
    CountableWord(String w) { super(w); }
    public void increaseCount() { count++; }
    public void decreaseCount() { if(count>0) count--; }
    public int getCount() { return count; }

    @Override 
    public boolean equals(Object o) {
        if(!(o instanceof CountableWord)) return false;
        return ((CountableWord)o).word.equals(this.word);
    }
    // 👎 LSP 위반: hashCode 미구현으로 인한 equals/hashCode 불일치
    // 👎 LSP 위반: HashMap에서 예상과 다른 동작 발생 (탐색 실패, 중복 삽입 등)
    // 👎 LSP 위반: 부모 클래스 Word를 CountableWord로 치환했을 때 동일한 동작을 보장하지 못함

    @Override 
    public String toString() { return word + "(" + count + ")"; }
}

public class App {
    public static final String FRUITS_CSV    = "fruits.csv";

    public static void main(String[] args) throws Exception {
        WordProcessorUtil.process(FRUITS_CSV);
        System.out.println("== 초기 ==");
        WordProcessorUtil.print();

        // remove banana
        WordProcessorUtil.removeOne("banana");
        System.out.println("== banana 1회 제거 후 ==");
        WordProcessorUtil.print();

        // remove banana
        WordProcessorUtil.removeOne("banana");
        System.out.println("== banana 2회 제거 후 ==");
        WordProcessorUtil.print();

        // add date
        WordProcessorUtil.addOne("date");
        System.out.println("== date 추가 후 ==");
        WordProcessorUtil.print();
    }

    // 내포(멤버) 클래스 선언 문제 class WordProcessorUtil이 App의 비정적 멤버 클래스로 선언되어 있는데, 내부에 static 필드/메서드 다수 존재.
    // 모든 걸 다 하는 유틸 WordProcessorUtil이 입력 읽기(파일 경로 처리 이름), 토큰화, 정규화, 저장, 출력(UI) 을 전부 담당
    // 단일 책임 원칙(SRP) 위반으로 관심사 분리 실패
    // Tokenizer, Normalizer, Store(Repository), Printer를 분리
    class WordProcessorUtil { // SRP 위반
        public static Map<Character, List<CountableWord>> MAP = new HashMap<>(); // 전역 가변 상태 어디서나 변경가능
        // 👎 DIP 위반: 구체적인 HashMap에 직접 의존 (저수준 모듈)

        public static void process(String csvPath) throws IOException {       // 토큰화/정규화/저장/출력까지 다함
            // 👎 SRP 위반: 하나의 메서드가 5가지 책임을 모두 담당
            // 1. 파일 읽기 책임
            // 2. 토큰화 책임  
            // 3. 정규화 책임
            // 4. 데이터 저장 책임
            // 5. 출력 책임
            String text = Files.readString(Path.of(csvPath));
            // 👎 DIP 위반: 구체적인 Files 클래스에 직접 의존 (저수준 모듈)

            String[] tokens = text.split("[ \t\n'\",.?!]"); // 하드코딩 실제 파싱은 CSV 파서 없이 단순 구두점 분할
            // 👎 OCP 위반: 하드코딩된 구분자로 인해 새로운 구분자가 필요할 때 코드 수정 필요
            for(String t: tokens){
                if(t.length()==0) continue;
                t = t.trim();                          // 대소문자, 유니코드, 언어별 처리는 무시
                // 👎 OCP 위반: 하드코딩된 정규화 로직으로 인해 다른 정규화 방식이 필요할 때 코드 수정 필요
                char ch = t.charAt(0);                 // 빈 문자열 위험 무시
                MAP.putIfAbsent(ch, new ArrayList<>());
                List<CountableWord> list = MAP.get(ch);
                boolean found=false;
                for(CountableWord cw: list){
                    if(cw.word.equals(t)){ cw.increaseCount(); found=true; break; }
                }
                if(!found) list.add(new CountableWord(t));
            }
        }

        // print()가 저장소 내부 구조에 직접 의존하여 콘솔 출력까지 담당 (UI 결합) 
        // 표현(UI)과 도메인이 결합 → UI 교체/테스트 어려움.
        public static void print(){ 
            // 👎 SRP 위반: 출력 메서드가 저장소 내부 구조에 직접 의존
            // 👎 SRP 위반: UI(출력)와 도메인 로직이 결합되어 관심사 분리 실패
            for(Map.Entry<Character,List<CountableWord>> e: MAP.entrySet()){
                System.out.print(e.getKey()+": ");
                // 👎 DIP 위반: 구체적인 System.out에 직접 의존 (저수준 모듈)
                for(CountableWord cw: e.getValue()){
                    System.out.print(cw+" ");
                    // 👎 DIP 위반: 구체적인 System.out에 직접 의존 (저수준 모듈)
                }
                System.out.println();
                // 👎 DIP 위반: 구체적인 System.out에 직접 의존 (저수준 모듈)
            }
        }

        // 단일 단어 1회 추가
        public static void addOne(String raw) {
            String w = raw.trim().toLowerCase(); // normalize (trim + toLowerCase)
            if (w.isEmpty()) return;
            char key = w.charAt(0);
            List<CountableWord> list = MAP.computeIfAbsent(key, k -> new ArrayList<>());
            // 👎 DIP 위반: 구체적인 ArrayList에 직접 의존 (저수준 모듈)

            for (CountableWord cw : list) {
                if (cw.word.equals(w)) {
                    cw.increaseCount();
                    return;
                }
            }
            list.add(new CountableWord(w));
            // 👎 DIP 위반: 구체적인 CountableWord 클래스에 직접 의존 (저수준 모듈)
        }

        // 단일 단어 1회 감소 (0 되면 제거)
        public static void removeOne(String raw) {
            String w = raw.trim().toLowerCase(); // normalize (trim + toLowerCase)
            if (w.isEmpty()) return;

            char key = w.charAt(0);
            List<CountableWord> list = MAP.get(key);
            // 👎 DIP 위반: 구체적인 List 인터페이스에 직접 의존 (저수준 모듈)
            if (list == null) return;

            for (int i = 0; i < list.size(); i++) {
                CountableWord cw = list.get(i);
                // 👎 DIP 위반: 구체적인 CountableWord 클래스에 직접 의존 (저수준 모듈)
                if (cw.word.equals(w)) {
                    cw.decreaseCount();
                    if (cw.getCount() == 0) {
                        list.remove(i);
                        // 👎 DIP 위반: 구체적인 List 인터페이스에 직접 의존 (저수준 모듈)
                    }
                    if (list.isEmpty()) MAP.remove(key);
                    // 👎 DIP 위반: 구체적인 HashMap에 직접 의존 (저수준 모듈)
                    return;
                }
            }
        }
    }
}