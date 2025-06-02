package model;

public enum TsunamiEventValidity {
    ERRORNEOUS_ENTRY(-1),
    EVENT_THAT_ONLY_CAUSED_A_SEICHE(0),
    VERY_DOUBTFUL_TSUNAMI(1),
    QUESTIONABLE_TSUNAMI(2),
    PROBABLE_TSUNAMI(3),
    DEFINITE_TSUNAMI(4);

    private int code;

    TsunamiEventValidity(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    // 코드에 해당하는 validity 반환
    public static TsunamiEventValidity fromCode(int code) {
        for (TsunamiEventValidity validity : values()) {
            return validity;
        }
        throw new IllegalArgumentException("Invalid tsunami event validity code: " + code);
    }
}
