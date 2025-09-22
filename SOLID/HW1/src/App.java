
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static final String FRUITS_CSV = "fruits.csv";

    public static void main(String[] args) throws IOException {
		String text = "Quick, brown FOX!! jumps over 13 lazy dogs. QUICK—brown—fox; "
    + "(NFKC: “quotes”, full-width ABC, café, naïve) You're reading O'Reilly's book... "
    + "Visit https://example.com/docs. Email: test@example.org, #hashtag @handle "
    + "미나 프로그래밍—좋아요! 3가지 항목:\tone, two, three.";

        // 파이프라인 1: (NFKC → lower+trim) → RegexTokenizer
		CountableWordProcessor pipeline1 = new CountableWordProcessor(List.of(new NFKCTextNormalizer(), new LowercaseTrimTextNormalizer()), new RegexTokenizer("[\\s\\p{Punct}]+"), new CountableWordRepository());
	
		// 파이프라인 2: (AsciiFolding -> SimpleStem) → WhitespaceTokenizer

		CountableWordProcessor pipeline2 = new CountableWordProcessor(List.of(new AsciiFoldingNormalizer(), new SimpleStemNormalizer()), new WhitespaceTokenizer(), new CountableWordRepository());
		
        pipeline1.processText(text);
		pipeline2.processText(text);

        // === CountableWord 적용: 파이프라인1 결과를 집계 ===
		System.out.println("\n[Pipeline #1] 초성별 빈도 (CountableWord 적용):");

		new ConsolePrinter().print(pipeline1.viewByInitial());

		// === CountableWord 적용: 파이프라인2 결과를 집계 ===
		System.out.println("\n[Pipeline #2] 초성별 빈도 (CountableWord적용):");

		new ConsolePrinter().print(pipeline2.viewByInitial());
	} // end of main
} // end of App class