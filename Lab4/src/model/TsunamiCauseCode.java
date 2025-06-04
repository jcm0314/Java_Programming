// LAB5, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명

package model;

public enum TsunamiCauseCode {
    UNKNOWN(0),
    EARTHQUAKE(1),
    QUESTIONABLE_EARTHQUAKE(2),
    EARTHQUAKE_AND_LANDSLIDE(3),
    VOLCANO_AND_EARTHQUAKE(4),
    VOLCANO_EARTHQUAKE_AND_LANDSLIDE(5),
    VOLCANO(6),
    VOLCANO_AND_LANDSLIDE(7),
    LANDSLIDE(8),
    METEOROLOGICAL(9),
    EXPLOSION(10),
    ASTRONOMICAL_TIDE(11);

    private int code;

    TsunamiCauseCode(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }

    public static TsunamiCauseCode fromCode(int code) {
        for (TsunamiCauseCode cause : values()) {
            if (cause.getCode() == code) {
                return cause;
            }
        }
        throw new IllegalArgumentException("Invalid tsunami cause code: " + code);
    }
}
