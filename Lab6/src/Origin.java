/**
 * 커피 원두의 원산지를 나타내는 클래스
 * 원산지 이름을 문자열로 저장
 */
public class Origin {
    // 원산지 이름을 저장하는 private 필드
    private String name;

    /**
     * Origin 생성자
     * @param name 원산지 이름
     */
    public Origin(String name) {
        this.name = name;
    }

    /**
     * 현재 원산지 이름 반환
     * @return 원산지 이름
     */
    public String getName() {
        return this.name;
    }

    /**
     * 원산지 이름 설정
     * @param name 새로운 원산지 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 객체의 문자열 표현을 반환
     * @return "{ name='원산지이름' }" 형식의 문자열
     */
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }
}
