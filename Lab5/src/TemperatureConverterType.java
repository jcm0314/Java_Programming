/**
 * 온도 변환 타입을 정의하는 열거형(Enum) 클래스
 * 섭씨와 화씨 간의 변환 방향을 지정
 */
public enum TemperatureConverterType {
    CELSIUS_TO_FAHRENHEIT(1), // 섭씨에서 화씨로 변환
    FAHRENHEIT_TO_CELSIUS(2); // 화씨에서 섭씨로 변환

    int type; // 변환 타입을 저장하는 필드

    /**
     * 생성자
     * @param type 변환 타입 (1: 섭씨→화씨, 2: 화씨→섭씨)
     */
    TemperatureConverterType(int type) {
        this.type = type;
    }

    /**
     * 변환 타입 반환
     * @return 변환 타입 값
     */
    public int getType() {
        return this.type;
    }

    /**
     * 정수 값을 해당하는 TemperatureConverterType으로 변환
     * @param type 변환할 정수 값
     * @return 해당하는 TemperatureConverterType 객체, 일치하는 타입이 없으면 null
     */
    public static TemperatureConverterType valueOf(int type) {
        return switch(type) {
            case 1 -> CELSIUS_TO_FAHRENHEIT;
            case 2 -> FAHRENHEIT_TO_CELSIUS;
            default -> null;
        };
    }
}
