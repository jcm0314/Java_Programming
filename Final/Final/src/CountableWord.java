public class CountableWord extends Word implements Countable {
    private int count; 

    // CountableWord 클래스의 생성자
    public CountableWord(String word) { 
        super(word); // 부모 클래스의 생성자 호출
        this.count = 1;
    } 

    // getter
    public int getCount() { 
        return count; 
    }

    // toString
    public String toString() { 
        return word + "(" + count + ")"; 
    } 
     
    // increaseCount
    @Override
    public void increaseCount() {
        count++;
    }

    //decreaseCount
    @Override
    public void decreaseCount() {
        count--;
    }
     
     
     
     
     
} 

