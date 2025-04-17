/**
 * 온도 변환을 수행하는 클래스
 * 섭씨와 화씨 간의 온도 변환을 제공
 */
public class TemperatureConverter {
    private TemperatureConverterType type;    // 변환 방향 (섭씨→화씨 또는 화씨→섭씨)
    private String fromUnit;                  // 변환 전 단위
    private String toUnit;                    // 변환 후 단위
    private float fromValue;                  // 변환 전 온도 값
    private float toValue;                    // 변환 후 온도 값

    /**
     * 생성자
     * @param type 변환 방향
     * @param temperature 변환할 온도 값
     */
    public TemperatureConverter(TemperatureConverterType type, float temperature) {
        this.type = type;
        this.fromValue = temperature;
        this.toValue = convert();  // 온도 변환 수행
        setUnit();                 // 단위 설정
    }

    /**
     * 변환 방향에 따라 단위 설정
     */
    private void setUnit() {
        switch(this.type) {
        case CELSIUS_TO_FAHRENHEIT:
            this.fromUnit = "Celsius";
            this.toUnit = "Fahrenheit";
            break;
        case FAHRENHEIT_TO_CELSIUS:
            this.fromUnit = "Fahrenheit";
            this.toUnit = "Celsius";
            break;
        }
    }

    /**
     * 온도 변환 수행
     * @return 변환된 온도 값
     */
    public float convert() {
        switch(this.type) {
        case CELSIUS_TO_FAHRENHEIT:
            return fromCelsiusToFahrenheit(this.fromValue);
        case FAHRENHEIT_TO_CELSIUS:
            return fromFahrenheitToCelsius(this.fromValue);
        }
        return 0.0f;
    }

    /**
     * 변환 결과를 문자열로 반환
     * @return 변환 전후의 온도와 단위를 포함한 문자열
     */
    public String toString() {
        return String.format("TemperatureConverter %s = %f => %s = %f\n", 
            fromUnit, fromValue, toUnit, toValue);
    }
    
    /**
     * 섭씨를 화씨로 변환
     * @param celsius 섭씨 온도
     * @return 화씨 온도
     */
    private static float fromCelsiusToFahrenheit(float celsius) {
        return (9.0f / 5.0f) * celsius + 32.0f;
    }

    /**
     * 화씨를 섭씨로 변환
     * @param fahrenheit 화씨 온도
     * @return 섭씨 온도
     */
    private static float fromFahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32.0f) * (5.0f / 9.0f);
    }
}
