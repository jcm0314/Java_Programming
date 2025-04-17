/**
 * 초콜릿 브랜드를 나타내는 클래스
 * 브랜드 이름과 생산 국가를 포함
 */
public class ChocolateBrand {
    // 브랜드 이름을 저장하는 private 필드
    private String name;
    // 생산 국가를 저장하는 private 필드
    private String country;

    /**
     * ChocolateBrand 생성자
     * @param name 브랜드 이름
     * @param country 생산 국가
     */
    public ChocolateBrand(String name, String country) {
        this.name = name;
        this.country = country;
    }

    /**
     * 현재 설정된 브랜드 이름 반환
     * @return 브랜드 이름
     */
    public String getName() {
        return this.name;
    }

    /**
     * 브랜드 이름 설정
     * @param name 새로운 브랜드 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 현재 설정된 생산 국가 반환
     * @return 생산 국가
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * 생산 국가 설정
     * @param country 새로운 생산 국가
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 객체의 문자열 표현을 반환
     * @return "{ name='브랜드이름', country='생산국가' }" 형식의 문자열
     */
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}
