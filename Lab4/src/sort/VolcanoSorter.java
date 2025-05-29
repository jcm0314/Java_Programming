// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package sort;

import java.util.Arrays;

import comparator.*;
import model.Volcano;

/**
 * 화산 데이터를 정렬하는 클래스
 * 다양한 기준(연도, 월, 일, 이름, 위치, 국가, 좌표, 고도, 유형, VEI)으로 정렬 가능
 * 각 정렬 기준은 별도의 Comparator 클래스로 구현
 * Comparator 메서드를 이용하기 위해서 compare(Object1, Object2)를 구현해야함
 */
public class VolcanoSorter {
    public static void sort(Volcano[] volcanoes, int index) {
        switch (index) {
            case 0:
                Arrays.sort(volcanoes, new NaturalHazardYearComparator());
                break;
            case 1:
                Arrays.sort(volcanoes, new VolcanoMonthComparator());
                break;
            case 2:
                Arrays.sort(volcanoes, new VolcanoDayComparator());
                break;
            case 3:
                Arrays.sort(volcanoes, new VolcanoNameComparator());
                break;
            case 4:
                Arrays.sort(volcanoes, new VolcanoLocationComparator());
                break;
            case 5:
                Arrays.sort(volcanoes, new VolcanoCountryComparator());
                break;
            case 6:
                Arrays.sort(volcanoes, new VolcanoLatitudeComparator());
                break;
            case 7:
                Arrays.sort(volcanoes, new VolcanoLongitudeComparator());
                break;
            case 8:
                Arrays.sort(volcanoes, new VolcanoElevationComparator());
                break;
            case 9:
                Arrays.sort(volcanoes, new VolcanoTypeComparator());
                break;
            case 10:
                Arrays.sort(volcanoes, new VolcanoVeiComparator());
                break;
            default:
                throw new IllegalArgumentException("Invalid sort index: " + index);
        }
    }
} 