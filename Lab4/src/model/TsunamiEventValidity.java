// LAB5, 자바 프로그래밍, 2분반, 25.06.04, 32203919 장천명
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
            if (validity.getCode() == code) {
                return validity;
            }
        }
        throw new IllegalArgumentException("Invalid tsunami event validity code: " + code);
    }
}
