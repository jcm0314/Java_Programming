package parser;

import java.util.List;

public interface IParser<T> {
    List<T> parse(String[][] data); // 데이터를 파싱하여 리스트로 반환
}
