// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package model;

/**
 * 화산 폭발 지수(VEI)를 나타내는 열거형
 * 0부터 8까지의 등급으로 화산 폭발의 규모를 표현
 */
public enum VolcanicExplosivityIndex {
    VEI_0(0),
    VEI_1(1),
    VEI_2(2),
    VEI_3(3),
    VEI_4(4),
    VEI_5(5),
    VEI_6(6),
    VEI_7(7),
    VEI_8(8);
    private final int value;
    VolcanicExplosivityIndex(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static VolcanicExplosivityIndex fromInt(int value) {
        for (VolcanicExplosivityIndex vei : values()) {
            if (vei.value == value) {
                return vei;
            }
        }
        throw new IllegalArgumentException("Invalid VEI value: " + value);
    }
} 