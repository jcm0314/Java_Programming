// LAB4, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
package parser;

import java.util.List;

public interface IParser<T> {
    List<T> parse(String[][] data); // 데이터를 파싱하여 리스트로 반환
}
