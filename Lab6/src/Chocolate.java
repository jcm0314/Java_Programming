/**
 * 초콜릿을 나타내는 클래스
 * 브랜드(ChocolateBrand)와 종류(ChocolateType)를 포함
 */
public class Chocolate { // Chocolate has ChocolateBrand and ChocolateType
    // 초콜릿의 브랜드 정보를 저장하는 private 필드
    private ChocolateBrand brand;
    // 초콜릿의 종류를 저장하는 private 필드
    private ChocolateType type;

    /**
     * Chocolate 생성자
     * @param brand 초콜릿 브랜드
     * @param type 초콜릿 종류
     */
    public Chocolate(ChocolateBrand brand, ChocolateType type) {
        this.brand = brand;
        this.type = type;
    }

    /**
     * 현재 설정된 브랜드 정보 반환
     * @return ChocolateBrand 객체
     */
    public ChocolateBrand getBrand() {
        return this.brand;
    }

    /**
     * 브랜드 정보 설정
     * @param brand 새로운 ChocolateBrand 객체
     */
    public void setBrand(ChocolateBrand brand) {
        this.brand = brand;
    }

    /**
     * 현재 설정된 초콜릿 종류 반환
     * @return ChocolateType 열거형 값
     */
    public ChocolateType getType() {
        return this.type;
    }

    /**
     * 초콜릿 종류 설정
     * @param type 새로운 ChocolateType 열거형 값
     */
    public void setType(ChocolateType type) {
        this.type = type;
    }

    /**
     * 객체의 문자열 표현을 반환
     * @return "{ brand='브랜드정보', type='초콜릿종류' }" 형식의 문자열
     */
    @Override
    public String toString() {
        return "{" +
            " brand='" + getBrand() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

}
