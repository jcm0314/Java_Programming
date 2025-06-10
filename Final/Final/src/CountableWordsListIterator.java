import java.util.Iterator;
import java.util.List;

// (6) CountableWordsListIterator 클래스 내부를 구현하라 
public class CountableWordsListIterator implements Iterator<CountableWord> {
    private int index = 0; 
    private List<CountableWord> list; // 리스트 선언

    public CountableWordsListIterator(List<CountableWord> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public CountableWord next() {
        return list.get(index++);
    }

    @Override
    public void remove() {
        list.remove(--index);
    }
}





