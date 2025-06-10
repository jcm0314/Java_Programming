import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class CountableWordsMap { // CountableWordsMap 클래스 선언
    private Map<Character, List<CountableWord>> map; // 맵 선언
    public CountableWordsMap() { // CountableWordsMap 클래스의 생성자
        map = new HashMap<>(); // 맵 초기화
    } 
    public void process(List<String> words) {  // process 메소드 선언
        for (String word : words) {  // 단어 반복
            if (!word.isEmpty()) {  // 단어가 비어있지 않은 경우
                addWord(word);  // addWord 메소드 호출
            } 
        }

} 
    private void addWord(String word) { // addWord 메소드 선언
        char ch = word.charAt(0); // 단어의 첫 문자 가져오기
        List<CountableWord> wordList; // 단어 리스트 선언
        if (map.containsKey(ch)) { // 맵에 해당 문자가 있는 경우
            wordList = map.get(ch); // 단어 리스트 가져오기
        } 
        else { // 맵에 해당 문자가 없는 경우
            wordList = new ArrayList<>(); // 단어 리스트 초기화
            map.put(ch, wordList); // 맵에 단어 리스트 추가
        }                         
        boolean found = false; // 단어가 있는지 확인
        for (CountableWord countableWord : wordList) { // 단어 리스트 반복
            if (countableWord.getWord().equals(word)) { // 단어가 있는 경우
                countableWord.increaseCount(); // 단어 카운트 증가
                found = true; // 단어가 있는 경우 종료
                break; // 단어가 있는 경우 종료
            } 
        }                 
        if (!found) { // 단어가 없는 경우
            wordList.add(new CountableWord(word)); // 단어 리스트에 단어 추가
        } 
    } 
    // print 메소드 선언
    public void print() { // print 메소드 선언
        for (Map.Entry<Character, List<CountableWord>> entry : map.entrySet()) { // 맵 반복
            System.out.print(entry.getKey() + ": "); // 키 출력
            for (CountableWord countableWord : entry.getValue()) { // 단어 리스트 반복
                    System.out.print(countableWord + " "); // 단어 출력
            } 
            System.out.println(); // 줄 바꿈
        } 
    } 
}