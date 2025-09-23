package HW2.src;

/**
 * App 클래스: 텍스트 처리 파이프라인을 실행하는 메인 클래스
 * 
 * 이 프로그램은 두 가지 다른 방식으로 텍스트를 처리합니다:
 * 1. 파이프라인 1: NFKC 정규화 + 소문자화 + 정규식 토큰화
 * 2. 파이프라인 2: ASCII 폴딩 + 형태소 분석 + 공백 토큰화
 * 
 * 각 파이프라인의 결과를 초성별로 그룹화하여 빈도를 계산합니다.
 */
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
    // CSV 파일 경로 상수 (현재는 사용하지 않음)
    public static final String FRUITS_CSV = "fruits.csv";

    /**
     * 메인 메서드: 프로그램의 진입점
     * 
     * 실행 과정:
     * 1. 테스트용 텍스트 데이터 준비
     * 2. 두 개의 파이프라인 생성 및 설정
     * 3. 각 파이프라인으로 텍스트 처리
     * 4. 결과를 초성별로 출력
     */
    public static void main(String[] args) throws IOException {
        // 테스트용 텍스트 데이터
        // 다양한 언어(영어, 한글), 특수문자, 악센트가 포함된 단어들을 포함
		String text = """
			Quick, brown FOX!! jumps over 13 lazy dogs.
			QUICK—brown—fox; (NFKC: "quotes", full-width ＡＢＣ, 
			café, naïve)
			You're reading O'Reilly's book... Visit 
			https://example.com/docs.
			Email: test@example.org, #hashtag @handle
			미나 프로그래밍—좋아요! ３가지 항목:\tone, two, three.
			""";

        // ===== 파이프라인 1 설정 =====
        // 정규화 순서: NFKC → 소문자화+공백제거
        // 토큰화: 정규식으로 공백과 구두점 기준 분리
        // 목적: 유니코드 정규화를 통한 일관된 텍스트 처리
		CountableWordProcessor pipeline1 = new CountableWordProcessor(
			List.of(new NFKCTextNormalizer(),        // 유니코드 NFKC 정규화
			new LowercaseTrimTextNormalizer()),       // 소문자화 + 공백제거
			new RegexTokenizer("[\\s\\p{Punct}]+"),   // 공백과 구두점으로 분리
			new CountableWordRepository()            // 결과 저장소
				);
	
        // ===== 파이프라인 2 설정 =====
        // 정규화 순서: ASCII 폴딩 → 형태소 분석
        // 토큰화: 공백 기준으로만 분리
        // 목적: 악센트 제거와 형태소 분석을 통한 단어 정규화
		CountableWordProcessor pipeline2 = new CountableWordProcessor(
			List.of(new AsciiFoldingNormalizer(),     // 악센트 제거 (한글 보존)
			new SimpleStemNormalizer()),              // 간단한 형태소 분석
			new WhitespaceTokenizer(),                // 공백으로만 분리
			new CountableWordRepository()             // 결과 저장소
				);
		
        // 각 파이프라인으로 동일한 텍스트 처리
        pipeline1.processText(text);
		pipeline2.processText(text);

        // ===== 파이프라인 1 결과 출력 =====
        // NFKC 정규화 + 정규식 토큰화 결과를 초성별로 그룹화하여 출력
		System.out.println("\n[Pipeline #1] 초성별 빈도 (CountableWord 적용):");
		new ConsolePrinter().print(pipeline1.viewByInitial());
		
		// yourcode: 파이프라인 1의 전체 단어 개수 출력
		System.out.println("파이프라인 1 전체 단어 개수: " + pipeline1.getTotalWordCount());

        // ===== 파이프라인 2 결과 출력 =====
        // ASCII 폴딩 + 형태소 분석 결과를 초성별로 그룹화하여 출력
		System.out.println("\n[Pipeline #2] 초성별 빈도 (CountableWord적용):");
		new ConsolePrinter().print(pipeline2.viewByInitial());
		
		// yourcode: 파이프라인 2의 전체 단어 개수 출력
		System.out.println("파이프라인 2 전체 단어 개수: " + pipeline2.getTotalWordCount());
	} // end of main
} // end of App class