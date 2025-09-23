/**
 * CountableWordRepository 클래스: 텍스트 처리 결과를 저장하고 관리하는 저장소
 * 
 * 이 클래스는 단어들을 초성(첫 글자)별로 그룹화하여 저장하고 관리합니다.
 * 각 단어의 등장 횟수도 함께 추적하여 빈도 분석을 지원합니다.
 * 
 * 주요 기능:
 * - 단어 추가 (빈도 계산)
 * - 단어 제거 (빈도 감소)
 * - 초성별 그룹화된 데이터 조회
 * 
 * 데이터 구조:
 * - 키: Character (단어의 첫 글자)
 * - 값: List<CountableWord> (해당 글자로 시작하는 단어들의 리스트)
 * 
 * 예시:
 * - 'a': [apple(2), ant(1)]
 * - 'b': [banana(3), book(1)]
 */
import java.util.*;

public class CountableWordRepository {
    // 단어의 첫 글자(Character)를 키로, 해당 글자로 시작하는 CountableWord 리스트를 값으로 저장
    private final Map<Character, List<CountableWord>> map = new HashMap<>();

    /**
     * 단어를 저장소에 추가합니다
     * 
     * 동작 과정:
     * 1. 입력 검증 (null, 빈 문자열 체크)
     * 2. 단어의 첫 글자를 키로 사용
     * 3. 해당 키의 리스트가 없으면 새로 생성
     * 4. 리스트에서 같은 단어가 있는지 검색
     * 5. 있으면 빈도 증가, 없으면 새로 추가
     * 
     * @param token 추가할 단어
     */
    public void addOne(String token) {
        // 입력 검증
        if (token == null || token.isEmpty()) return;
        
        // 단어의 첫 글자를 키로 사용
        char key = token.charAt(0);
        
        // 해당 키의 리스트가 없으면 새로 생성 (computeIfAbsent 사용)
        List<CountableWord> list = map.computeIfAbsent(key, k -> new ArrayList<>());
        
        // 리스트에서 같은 단어가 있는지 검색
        for (CountableWord cw : list) {
            if (cw.getWord().toString().equals(token)) {
                // 같은 단어가 있으면 빈도 증가
                cw.increaseCount();
                return;
            }
        }
        
        // 같은 단어가 없으면 새로 추가 (빈도는 1로 시작)
        list.add(new CountableWord(new Word(token)));
    }

    /**
     * 단어를 저장소에서 제거합니다 (빈도 감소)
     * 
     * 동작 과정:
     * 1. 입력 검증 (null, 빈 문자열 체크)
     * 2. 단어의 첫 글자를 키로 사용
     * 3. 해당 키의 리스트에서 단어 검색
     * 4. 찾으면 빈도 감소
     * 5. 빈도가 0이 되면 리스트에서 제거
     * 6. 리스트가 비어있으면 키도 제거
     * 
     * @param token 제거할 단어
     */
    public void removeOne(String token) {
        // 입력 검증
        if (token == null || token.isEmpty()) return;
        
        // 단어의 첫 글자를 키로 사용
        char key = token.charAt(0);
        List<CountableWord> list = map.get(key);
        
        // 해당 키의 리스트가 없으면 아무것도 하지 않음
        if (list == null) return;
        
        // Iterator를 사용하여 안전하게 리스트 순회 및 수정
        Iterator<CountableWord> it = list.iterator();
        while (it.hasNext()) {
            CountableWord cw = it.next();
            if (cw.getWord().toString().equals(token)) {
                // 같은 단어를 찾으면 빈도 감소
                cw.decreaseCount();
                
                // 빈도가 0이 되면 리스트에서 제거
                if (cw.getCount() == 0) {
                    it.remove();
                }
                
                // 리스트가 비어있으면 키도 제거
                if (list.isEmpty()) {
                    map.remove(key);
                }
                return;
            }
        }
    }

    /**
     * 초성별로 그룹화된 단어 리스트를 반환합니다
     * 
     * @return 초성(Character)을 키로, CountableWord 리스트를 값으로 하는 Map
     */
    public Map<Character, List<CountableWord>> viewByInitial() {
        return map;
    }

    // yourcode: 전체 단어 개수를 반환합니다 (중복 포함)
    /**
     * 저장소에 있는 모든 단어의 총 개수를 반환합니다
     * 
     * 이 메서드는 각 단어의 등장 횟수를 모두 합산하여 전체 단어 개수를 계산합니다.
     * 예를 들어, "apple(3)", "banana(2)"가 있다면 총 5개를 반환합니다.
     * 
     * @return 전체 단어 개수 (중복 포함)
     */
    public int getTotalWordCount() {
        int totalCount = 0;
        
        // 모든 초성 그룹을 순회
        for (List<CountableWord> wordList : map.values()) {
            // 각 그룹의 모든 단어를 순회
            for (CountableWord cw : wordList) {
                // 각 단어의 등장 횟수를 총합에 추가
                totalCount += cw.getCount();
            }
        }
        
        return totalCount;
    }
}
