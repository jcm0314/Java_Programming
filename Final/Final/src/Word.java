public class Word {
    protected String word;

    // Word 클래스의 생성자
    public Word(String word) {
        this.word = word;
    }

    // getter

    public String getWord() {
        return word;
    }

    // toString
    @Override
    public String toString() {
        return getWord();
    }

    





    
}
