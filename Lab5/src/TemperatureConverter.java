
public class TemperatureConverter {
    private TemperatureConverterType type;
    private String fromUnit;
    private String toUnit;
    private float fromValue;
    private float toValue;

    public TemperatureConverter(TemperatureConverterType type, float temperature) {
        this.type = type;
        this.fromValue = temperature;
        this.toValue = convert();
        setUnit();
    }

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

    public float convert() {
        switch(this.type) {
        case CELSIUS_TO_FAHRENHEIT:
            return fromCelsiusToFahrenheit(this.fromValue);
        case FAHRENHEIT_TO_CELSIUS:
            return fromFahrenheitToCelsius(this.fromValue);
        }
        return 0.0f;
    }

    public String toString() {
        return String.format("TemperatureConverter %s = %f => %s = %f\n", fromUnit, fromValue, toUnit, toValue);
    }
    
    // F = (9/5) * C + 32
	private static float fromCelsiusToFahrenheit(float celsius) {
		return (9.0f / 5.0f) * celsius + 32.0f;
	}

	// C = (F - 32) * 5/9
	private static float fromFahrenheitToCelsius(float fahrenheit) {
		return (fahrenheit - 32.0f) * (5.0f / 9.0f);
	}
}
