
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class App {
    public static final String FRUITS_CSV = "fruits.csv";

    public static void main(String[] args) throws IOException {
        // 의존성 조립
        Tokenizer tokenizer = new Tokenizer();
        Normalizer normalizer = new Normalizer();
        WordRepository repository = new WordRepository();
        WordPrinter printer = new WordPrinter();

        // 파일 읽기 및 처리
        String text = Files.readString(Path.of(FRUITS_CSV));
        List<String> tokens = tokenizer.tokenize(text);
        for (String t : tokens) {
            String norm = normalizer.normalize(t);
            if (!norm.isEmpty()) {
                repository.addWord(new Word(norm));
            }
        }

        System.out.println("== 초기 ==");
        printer.print(repository.getAll());

        // remove banana
        repository.removeWord(new Word(normalizer.normalize("banana")));
        System.out.println("== banana 1회 제거 후 ==");
        printer.print(repository.getAll());

        // remove banana
        repository.removeWord(new Word(normalizer.normalize("banana")));
        System.out.println("== banana 2회 제거 후 ==");
        printer.print(repository.getAll());

        // add date
        repository.addWord(new Word(normalizer.normalize("date")));
        System.out.println("== date 추가 후 ==");
        printer.print(repository.getAll());

        // yourcode: 단어 길이 기능 테스트
        System.out.println("\n=== yourcode: 단어 길이 기능 테스트 ===");
        testWordLengthFeature(repository);
    }

    // yourcode: 단어 길이 기능을 테스트하는 메서드
    private static void testWordLengthFeature(WordRepository repository) {
        System.out.println("단어별 길이 정보:");
        for (Map.Entry<Character, List<CountableWord>> entry : repository.getAll().entrySet()) {
            for (CountableWord cw : entry.getValue()) {
                Word word = cw.getWord();
                System.out.println("- " + word + " (길이: " + word.getLength() + "글자, 개수: " + cw.getCount() + "번)");
            }
        }
    }
}