
public enum TemperatureConverterType {
    CELSIUS_TO_FAHRENHEIT(1),
    FAHRENHEIT_TO_CELSIUS(2);

    int type;
    TemperatureConverterType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public static TemperatureConverterType valueOf(int type) {
        return switch(type) {
        case 1 -> CELSIUS_TO_FAHRENHEIT;
        case 2 -> FAHRENHEIT_TO_CELSIUS;
        default -> null;
        };
    }
}
