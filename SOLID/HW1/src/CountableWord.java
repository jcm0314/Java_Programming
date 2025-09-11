public class CountableWord {
    private final Word word;
    private int count;

    public CountableWord(Word word) {
        this.word = word;
        this.count = 1;
    }

    public Word getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        if (count > 0) count--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountableWord that = (CountableWord) o;
        return word.equals(that.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word + "(" + count + ")";
    }
}
