import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class CountableWordsList implements Iterable<CountableWord> {
    private List<CountableWord> list; // 리스트 선언

    // CountableWordList 클래스의 생성자
    public CountableWordsList() { 
        list = new ArrayList<>(); // 리스트 초기화
    } 
    // (3) CountableWordsList의 addWord 메소드를 구현하라 
    public void addWord(String word) { 
        for (CountableWord cw : list) { // 이미 존재하는 단어인지 확인
            if (cw.getWord().equals(word)) { // 존재하는 단어인 경우
                cw.increaseCount(); // 카운트 증가
                return; // 존재하는 단어인 경우 종료
            }
        }
        list.add(new CountableWord(word)); // 새로운 단어인 경우 리스트에 추가
    } 
    // (4) CountableWordsList의 removeWord 메소드를 구현하라 
    public void removeWord(String word) {
        for (CountableWord cw : list) {
            if (cw.getWord().equals(word)) {
                cw.decreaseCount();
                return;
            }
        }
        list.remove(new CountableWord(word));
}
    // (5) Iterable<CountableWord> 인터페이스의 추상메소드를 구현하라 
    @Override // 이터레이터 반환
    public Iterator<CountableWord> iterator() { // 이터레이터 반환
        return new CountableWordsListIterator(list); // 이터레이터 반환   
    }


}


    
