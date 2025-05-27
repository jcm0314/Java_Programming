// LAB4, 자바 프로그래밍, 2분반, 25.05.20, 32203919 장천명
package sort;

import java.util.Arrays;
import comparator.*;
import model.Earthquake;

/**
 * 지진 데이터를 정렬하는 클래스
 * 다양한 기준(연도, 월, 일, 위치, 좌표, 깊이, 규모)으로 정렬 가능
 * 각 정렬 기준은 별도의 Comparator 클래스로 구현
 */
public class EarthquakeSorter {
    public static void sort(Earthquake[] earthquakes, int index) {
        switch (index) {
            case 0:
                Arrays.sort(earthquakes, new NaturalHazardYearComparator());
                break;
            case 1:
                Arrays.sort(earthquakes, new EarthquakeMonthComparator());
                break;
            case 2:
                Arrays.sort(earthquakes, new EarthquakeDayComparator());
                break;
            case 3:
                Arrays.sort(earthquakes, new EarthquakeLocationComparator());
                break;
            case 4:
                Arrays.sort(earthquakes, new EarthquakeLatitudeComparator());
                break;
            case 5:
                Arrays.sort(earthquakes, new EarthquakeLongitudeComparator());
                break;
            case 6:
                Arrays.sort(earthquakes, new EarthquakeDepthComparator());
                break;
            case 7:
                Arrays.sort(earthquakes, new EarthquakeMagnitudeComparator());
                break;
            default:
                throw new IllegalArgumentException("Invalid sort index: " + index);
        }
    }
} 