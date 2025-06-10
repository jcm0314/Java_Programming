import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class App {  // App 클래스 선언
    public static void main(String[] args) { 
        String[] words = {"apple", "carrot", "banana", "carrot", "carrot", "banana",  
"avocado"};
        // (8) words 배열을 사용하여 List<Word> wordList을 생성하라 
        List<Word> wordList  = new ArrayList<>(); // 리스트 선언
        for (String word : words) {
            wordList.add(new Word(word)); // 리스트에 단어 추가
        }
        wordList.forEach(System.out::println); 

        // (9) wordList.sort의 Comparator를 lambda로 구현하라 (알파벳 순서로 정렬) 
        wordList.sort((a, b) -> a.getWord().compareTo(b.getWord())); // 알파벳 순서로 정렬
        wordList.forEach(System.out::println); // 리스트 출력

        // countableWordList.addWord  
        CountableWordsList countableWordList = new CountableWordsList(); 
        for (var word : words) { 
            countableWordList.addWord(word); // 리스트에 단어 추가
        } 
        // countableWordList.forEach 
        countableWordList.forEach(System.out::println); // 실행결과 
        // apple(1) 
        // carrot(3) 
        // banana(2) 
        // avocado(1) 
        // countableWordList.removeWord 
        countableWordList.removeWord("banana");  
        // countableWordList.forEach 
        countableWordList.forEach(System.out::println); // 실행결과 
        // apple(1) 
        // carrot(3) 
        // banana(1) 
        // avocado(1) 
        // countableWordList.removeWord 
        countableWordList.removeWord("banana"); 
        // countableWordList.forEach 
            countableWordList.forEach(System.out::println); // 실행결과  
        // apple(1) 
        // carrot(3) 
        // avocado(1) 
    
        // (10) 다음 CountableWordsMap 실행 결과를 적어라 
        CountableWordsMap countableWordsMap = new CountableWordsMap(); // 맵 선언
        countableWordsMap.process(Arrays.asList(words)); // 맵에 단어 추가
        countableWordsMap.print(); // 맵 출력
        } 
    } 